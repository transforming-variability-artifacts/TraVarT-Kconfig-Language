package de.kit.kastel.travart.kconfig.model.nodes.choice;

import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;
import de.kit.kastel.travart.kconfig.model.nodes.value.KconfigTristateNode;

public class KconfigTristateChoice extends KconfigChoice<KconfigTristateNode> {
	
	public KconfigTristateChoice(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);	
	}
	
}
