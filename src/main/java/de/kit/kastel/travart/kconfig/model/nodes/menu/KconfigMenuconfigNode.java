package de.kit.kastel.travart.kconfig.model.nodes.menu;

import de.kit.kastel.travart.kconfig.model.nodes.value.KconfigBooleanNode;

public class KconfigMenuconfigNode extends KconfigMenuNode {
	
	private KconfigBooleanNode underlyingNode;

	public KconfigMenuconfigNode(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);
		underlyingNode = new KconfigBooleanNode(nodeName, enclosingNode);
	}

	public KconfigBooleanNode getUnderlyingNode() {
		return underlyingNode;
	}
}
