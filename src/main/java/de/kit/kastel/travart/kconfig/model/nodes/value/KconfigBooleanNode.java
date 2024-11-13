package de.kit.kastel.travart.kconfig.model.nodes.value;

import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;

public class KconfigBooleanNode extends KconfigValueNode<Boolean> {

	public KconfigBooleanNode(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);
	}

	@Override
	public boolean isConfigured() {
		return getValue();
	}

	@Override
	public void setConfigured(boolean selected) {
		setValue(selected);
	}

}
