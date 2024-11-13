package de.kit.kastel.travart.kconfig.model.nodes.value;

import de.kit.kastel.travart.kconfig.model.KconfigNode;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;

public abstract class KconfigValueNode<T> extends KconfigNode {
	
	private T value;
	
	public KconfigValueNode(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
