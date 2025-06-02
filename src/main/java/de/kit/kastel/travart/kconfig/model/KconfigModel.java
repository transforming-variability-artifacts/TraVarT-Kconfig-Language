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
package de.kit.kastel.travart.kconfig.model;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.tuple.MutablePair;
import org.logicng.formulas.Formula;

import at.jku.cps.travart.core.common.IConfigurable;
import at.jku.cps.travart.core.common.IValidate;

public interface KconfigModel extends IValidate, IConfigurable {

	/**
	 * Returns the factoryId which created this {@link IDecisionModel}.
	 *
	 * @return the factoryId
	 */
	String getFactoryId();

	/**
	 * Returns the file location where the model is stored.
	 *
	 * @return the file location.
	 */
	String getSourceFile();

	/**
	 * Update the storage location of this {@link IDecisionModel}.
	 *
	 * @param sourceFile the location of this {@link IDecisionModel}.
	 */
	void setSourceFile(String sourceFile);

	void setName(String name);

	@Override
	String getName();

	void add(KconfigNode node);

	void removeDependency(KconfigNode source, KconfigNode target);

	void removeDependencies(KconfigNode source);

	void addAll(Collection<KconfigNode> nodes);

	boolean remove(KconfigNode node);

	void clear();

	KconfigNode get(String name);

	Collection<String> getNodeNames();

	Collection<KconfigNode> getNodes();

	Map<KconfigNode, Collection<MutablePair<Formula, Boolean>>> getDependencies();

	boolean contains(KconfigNode node);

	boolean containsAll(Collection<KconfigNode> nodes);

	boolean containsAll(Map<KconfigNode, Collection<MutablePair<Formula, Boolean>>> dependencies);

	// Should return the number of KConfigNode instances in inner graph
	int size();


	void addAll(final KconfigGraph graph);

	KconfigGraph getInnerGraph();

	void addDependency(KconfigNode source, KconfigNode target, boolean reverse);

	void addDependencies(KconfigNode source, Collection<KconfigNode> target, boolean reverse);
}
