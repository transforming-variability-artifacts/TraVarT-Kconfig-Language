package de.kit.kastel.travart.kconfig.model.nodes.value;

import de.kit.kastel.travart.kconfig.model.TristateLogic;
import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;

public class KconfigTristateNode extends KconfigValueNode<TristateLogic> {

	public KconfigTristateNode(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);
	}
	
	@Override
	public boolean isConfigured() {
		if (getValue() == TristateLogic.FALSE) return false;
		return true;
	}

	@Override
	public void setConfigured(boolean selected) {
		if (selected) {
			setValue(TristateLogic.SELECTED);
		} else {
			setValue(TristateLogic.FALSE);
		}
	}

}
