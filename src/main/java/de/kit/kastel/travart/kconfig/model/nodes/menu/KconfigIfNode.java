package de.kit.kastel.travart.kconfig.model.nodes.menu;

import org.logicng.formulas.Formula;

@SuppressWarnings("rawtypes")
public class KconfigIfNode extends KconfigMenuNode {
	
	final Formula condition;

	public KconfigIfNode(String nodeName, KconfigMenuNode enclosingNode, Formula exp) {
		super(nodeName, enclosingNode);
		this.condition = exp;
	}

	public Formula getCondition() {
		return condition;
	}
}
