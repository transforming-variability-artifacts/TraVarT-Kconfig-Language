package de.kit.kastel.travart.kconfig.model.nodes.menu;

import java.util.HashSet;
import java.util.Set;

import de.kit.kastel.travart.kconfig.model.KconfigNode;

public class KconfigMenuNode<T extends KconfigNode> extends KconfigNode {
	
	public Set<T> contents;
	
	public KconfigMenuNode(String nodeName, KconfigMenuNode enclosingNode) {
		super(nodeName, enclosingNode);
		this.contents = new HashSet<T>();		
	}

	@Override
	public boolean isConfigured() {
		// Cannot be selected; menu nodes are, by default, abstract
		return false;
	}

	@Override
	public void setConfigured(boolean selected) {
		return;
	}
	
}
