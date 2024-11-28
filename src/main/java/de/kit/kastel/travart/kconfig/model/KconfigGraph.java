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

import java.util.Map;

import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.lang3.tuple.MutablePair;
import org.logicng.formulas.Formula;

// FIXME Try to use a less nested structure (use other representation of dependencies?)
public record KconfigGraph(Map<String, KconfigNode> nodes, ListValuedMap<KconfigNode, MutablePair<Formula, Boolean>> dependencies) {}