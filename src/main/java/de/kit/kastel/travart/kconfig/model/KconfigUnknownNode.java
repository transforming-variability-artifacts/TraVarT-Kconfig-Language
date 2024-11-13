package de.kit.kastel.travart.kconfig.model;

// TODO Is this class really necessary?
/**
 * Corresponds to the former KconfigType.UNKNOWN enum entry
 */
public class KconfigUnknownNode extends KconfigNode {
	
	public KconfigUnknownNode(String name) {
		super(name);
	}

	@Override
	public boolean isConfigured() {
		throw new UnsupportedOperationException("Cannot invoke isSelected() on placeholder node: Faulty model!");
	}

	@Override
	public void setConfigured(boolean configured) {
		throw new UnsupportedOperationException("Cannot invoke setSelected() on placeholder node: Faulty model!");
	}

}
