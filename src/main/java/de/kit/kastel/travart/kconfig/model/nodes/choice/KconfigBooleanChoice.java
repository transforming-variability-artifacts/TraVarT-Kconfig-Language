package de.kit.kastel.travart.kconfig.model.nodes.choice;

import de.kit.kastel.travart.kconfig.model.nodes.menu.KconfigMenuNode;
import de.kit.kastel.travart.kconfig.model.nodes.value.KconfigBooleanNode;

public class KconfigBooleanChoice extends KconfigChoice<KconfigBooleanNode> {

	public KconfigBooleanChoice(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);
	}
	
}