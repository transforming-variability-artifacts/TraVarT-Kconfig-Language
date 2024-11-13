package de.kit.kastel.travart.kconfig.model.nodes.value;

import java.util.Objects;

import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;

public class KconfigStringNode extends KconfigValueNode<String> {

	public KconfigStringNode(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);
	}

	@Override
	public boolean isConfigured() {
		if (Objects.isNull(getValue())) return false;
		return true;
	}

	@Override
	public void setConfigured(boolean selected) {
		if (selected) {
			if (!this.isConfigured()) {
				setValue("");
			}
		} else {
			setValue(null);
		}		
	}

}
