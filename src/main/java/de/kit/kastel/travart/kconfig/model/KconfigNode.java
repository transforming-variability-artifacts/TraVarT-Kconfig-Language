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

import at.jku.cps.travart.core.common.IConfigurable;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;

@SuppressWarnings("rawtypes")
public abstract class KconfigNode implements IConfigurable {

	// TODO Remove immutable attribute and close() method
	private boolean immutable = false;
	private boolean optional = true;
	private String name;
	private KconfigMenuNode enclosingNode; // TODO How to model menuconfig value nodes?

	protected KconfigNode() {
		this.enclosingNode = null;
	}

	protected KconfigNode(String name) {
		this.name = name;
		this.enclosingNode = null;
	}

	protected KconfigNode(String name, KconfigMenuNode enclosing) {
		this.name = name;
		this.enclosingNode = enclosing;
	}

	public void setEnclosingNode(KconfigMenuNode enclosingNode) {
		this.enclosingNode = enclosingNode;
	}

	public KconfigNode getEnclosingNode() {
		return enclosingNode;
	}

	public boolean isOptional() {
		return optional;
	}

	public void toggleOptional() {
		this.optional = !this.optional;
	}

	// TODO Move this method to an interface "Closable"
	public void close() {
		if (immutable) {
			throw new UnsupportedOperationException("This instance has already been consummated!");
		}
		this.immutable = true;
	}

	public String getId() {
		return getName();
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (immutable) {
			throw new UnsupportedOperationException("This instance has already been consummated!");
		}
		this.name = name;
	};

	@Override
	public boolean equals(Object o) {
		// Two config symbols cannot have the same name
		// This should cause a mismatch regardless of the symbol type
		return o instanceof KconfigNode && this.name.equals(((KconfigNode) o).getName());
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
