package de.kit.kastel.travart.kconfig.model.nodes.choice;

import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;
import de.kit.kastel.travart.kconfig.model.nodes.value.KconfigValueNode;

public abstract class KconfigChoice<T extends KconfigValueNode<?>> extends KconfigMenuNode<T> {

	public KconfigChoice(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);
	}

	// TODO Should we override isSelected/setSelected?
}