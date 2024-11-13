package de.kit.kastel.travart.kconfig.model.nodes.value;

import java.util.Objects;

import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;

// TODO Also implement KconfigHexNode
// Right now, hex config symbols are parsed as integer confsyms
public class KconfigIntNode extends KconfigValueNode<Integer> {

	public KconfigIntNode(String nodeName, KconfigMenuNode enclosingNode) {
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
				setValue(0);
			}
		} else {
			setValue(null);
		}		
	}
	
}
