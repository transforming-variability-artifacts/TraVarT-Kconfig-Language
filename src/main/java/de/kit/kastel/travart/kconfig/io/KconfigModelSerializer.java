/*******************************************************************************
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors:
 * 	@author Kaan Berk Yaman
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig.io;

import org.apache.commons.lang3.tuple.MutablePair;
import org.logicng.formulas.Formula;

import at.jku.cps.travart.core.common.Format;
import at.jku.cps.travart.core.common.ISerializer;
import at.jku.cps.travart.core.exception.NotSupportedVariabilityTypeException;
import de.kit.kastel.travart.kconfig.model.*;
import de.kit.kastel.travart.kconfig.model.nodes.value.*;

public class KconfigModelSerializer implements ISerializer<IKconfigModel> {

	/**
	 * WIP
	 */
	public String serialize(final IKconfigModel km) throws NotSupportedVariabilityTypeException {
		StringBuilder fileContents = new StringBuilder();
		// throw new UnsupportedOperationException("Not implemented!");
		for (KconfigNode node : km.getNodes()) {
			StringBuilder nodeCode = new StringBuilder();
			if (node instanceof KconfigValueNode) {
				// FIXME Do not ignore menu and choice blocks
				// TODO Ensure that the order in which config symbols occur is valid
				nodeCode.append("config " + node.getName() + "\n\r");
				switch (node) {
				case KconfigBooleanNode b:
					nodeCode.append("\t bool\n\r");
					break;
				case KconfigIntNode i:
					nodeCode.append("\t int\n\r");
					break;
				case KconfigTristateNode t:
					nodeCode.append("\t tristate\n\r");
					break;
				case KconfigStringNode s:
					nodeCode.append("\t string\n\r");
					break;
				default:
					throw new IllegalStateException("Cannot write illegal Kconfig model!");
				}
				if (km.getDependencies().keySet().contains(node)) {
					for (MutablePair<Formula, Boolean> dep : km.getDependencies().get(node)) {
						if (dep.right) {
							nodeCode.append("\t select " + detoxDependencyExpression(dep.left.toString()) + "\n\r");
						} else {
							nodeCode.append("\t depends on " + detoxDependencyExpression(dep.left.toString()) + "\n\r");
						}
					}
					nodeCode.append("\n\r");
					fileContents.append(nodeCode.toString());
				}
			}
		}
		return fileContents.toString();
	}

	private String detoxDependencyExpression(String dependencyExpression) {
		// TODO Find all discrepancies between LogicNG and Kconfig expression syntax
		return dependencyExpression.replace('~', '!').replace("$", "");

	}

	@Override
	public Format getFormat() {
		return KconfigFormat.getInstance();
	}
}
