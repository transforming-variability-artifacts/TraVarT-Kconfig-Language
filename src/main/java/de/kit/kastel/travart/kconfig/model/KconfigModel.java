/*******************************************************************************
 * TODO: explanation what the class does
 *  
 *  @author Kevin Feichtinger
 *  
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
 * All rights reserved
 *******************************************************************************/
package de.kit.kastel.travart.kconfig.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import org.logicng.formulas.Formula;
import org.logicng.formulas.FormulaFactory;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import at.jku.cps.travart.core.common.IConfigurable;
import de.kit.kastel.travart.kconfig.exc.RangeValueException;

@SuppressWarnings("rawtypes")
public final class KconfigModel implements IKconfigModel {

	public static final String DEFAULT_NAME = "Kconfig";
	private final String factoryId;
	private String sourceFile;
	private String name;

	private final KconfigGraph graph;
	
	// FIXME Perhaps we should initialize KconfigGraphs exclusively over models?
	public KconfigModel(final String factoryId, final String name, final KconfigGraph existingGraph) {
		this.factoryId = Objects.requireNonNull(factoryId);
		this.name = Objects.requireNonNull(name);
		this.graph = existingGraph;
	}

	public KconfigModel(final String factoryId) {
		this(factoryId, DEFAULT_NAME);
	}

	public KconfigModel(final String factoryId, final String name) {
		this.factoryId = Objects.requireNonNull(factoryId);
		this.name = Objects.requireNonNull(name);
		this.graph = new KconfigGraph(new HashMap<String, KconfigNode>(), new ArrayListValuedHashMap<KconfigNode, MutablePair<Formula, Boolean>>());
	}

	@Override
	public KconfigNode get(final String name) {
		for (KconfigNode node : getNodes()) {
			if (node.getName().equals(name)) {
				return node;
			}
		}
		return null;
	}

	@Override
	public void add(final KconfigNode node) {
		graph.nodes().put(node.getName(), node);
	}
	
	@Override
	public void addDependency(final KconfigNode source, final KconfigNode target, boolean reverse) {
		FormulaFactory f = new FormulaFactory();
		graph.dependencies().put(source, MutablePair.of(f.variable(target.getName()), reverse));
	}
	
	public void addDependency(final KconfigNode source, final Formula exp, boolean reverse) {
		graph.dependencies().put(source, MutablePair.of(exp, reverse));
	}
	
	@Override
	public void addDependencies(final KconfigNode source, final Collection<KconfigNode> target, boolean reverse) {
		for (KconfigNode node : target) {
			addDependency(source, node, reverse);
		}
	}
	
	@Override
	public void addAll(final Collection<KconfigNode> nodes) {
		for (KconfigNode node : nodes) {
			this.graph.nodes().put(node.getName(), node);
		}
	}
	
	@Override
	public void addAll(final KconfigGraph graph) {
		this.graph.nodes().putAll(graph.nodes());
		this.graph.dependencies().putAll(graph.dependencies());
	}

	@Override
	public boolean remove(final KconfigNode node) {
		KconfigNode prev = graph.nodes().remove(node.getName());
		if (Objects.nonNull(prev)) {
			// Assuming that the graph contains no cycles
			graph.dependencies().remove(prev);
			// Should always return true...
			return prev.equals(node);
		} else {
			return false;
		}
	}

	@Override
	public void clear() {
		graph.nodes().clear();
		graph.dependencies().clear();
	}

	@Override
	public int size() {
		return graph.nodes().size();
	}

	@Override
	public Collection<String> getNodeNames() {
		return graph.nodes().keySet();
	}

	@Override
	public Collection<KconfigNode> getNodes() {
		return graph.nodes().values();
	}
	
	@Override
	public Map<KconfigNode, Collection<MutablePair<Formula, Boolean>>> getDependencies() {
		return graph.dependencies().asMap();
	}
	
	@Override
	public boolean contains(final KconfigNode node) {
		return graph.nodes().containsKey(node.getName());
	}

	@Override
	public boolean containsAll(final Collection<KconfigNode> nodes) {
		for (KconfigNode node : nodes) {
			if (!this.graph.nodes().containsKey(node.getId())) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean containsAll(final Map<KconfigNode, Collection<MutablePair<Formula, Boolean>>> dependencies) {
		for (Map.Entry<KconfigNode, Collection<MutablePair<Formula, Boolean>>> dependency : dependencies.entrySet()) {
			if (!this.graph.dependencies().containsMapping(dependency.getKey(), dependency.getValue())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getFactoryId() {
		return factoryId;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getSourceFile() {
		return sourceFile;
	}

	@Override
	public boolean isValid() {
		return false;
		/*
		// I am not sure what I should I check here...
		for (KconfigNode node : getNodes()) {
			// Ensure that the graph does not contain any cycles
			for (var dependency : graph.dependencies().get(node)) {
				if (graph.dependencies().get(dependency.getLeft()).stream().map(e -> e.getLeft()).toList().contains(node)) {
					return false;
				}
			}
		}
		return true;
		*/
	}

	/*
	@Override
	public void reset() throws RangeValueException {
		for (IDecision decision : getDecisions()) {
			decision.reset();
		}
	}
	*/

	@Override
	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public void setSourceFile(final String sourceFile) {
		this.sourceFile = sourceFile;
	}

	/*
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DecisionModel");
		builder.append(name);
		builder.append("[");
		for (IDecision decision : getDecisions()) {
			builder.append(decision);
			builder.append("[selected=");
			builder.append(decision.isSelected());
			builder.append("; value=");
			builder.append(decision.getValue());
			builder.append("]");
			builder.append("; ");
		}
		if (builder.lastIndexOf(";") >= 0) {
			builder.deleteCharAt(builder.lastIndexOf(";"));
		}
		builder.append("]");
		return builder.toString();
	}

	@Override
	public Map<IConfigurable, Boolean> getCurrentConfiguration() {
		Map<IConfigurable, Boolean> configuration = new HashMap<>();
		for (IDecision decision : getDecisions()) {
			configuration.put(decision, decision.isSelected());
		}
		return configuration;
	}
	*/

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof KconfigModel)) {
			return false;
		}
		KconfigModel other = (KconfigModel) o;
		if (!name.equals(other.name) || size() != other.size() || !containsAll(other.getNodes()) || !containsAll(other.getDependencies())) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for (KconfigNode node : getNodes()) {
			hash += node.hashCode();
		}
		return hash * 14851;
	}

	@Override
	public void removeDependency(KconfigNode source, KconfigNode target) {
		this.graph.dependencies().removeMapping(source, target);

	}

	@Override
	public void removeDependencies(KconfigNode source) {
		this.graph.dependencies().remove(source);		
	}

	@Override
	public void reset() throws RangeValueException {
		// TODO
	}

	@Override
	public Map<IConfigurable, Boolean> getCurrentConfiguration() {
		// TODO
		return null;
	}

	@Override
	public KconfigGraph getInnerGraph() {
		return graph;
	}

	@Override
	public boolean isConfigured() {
		return graph.nodes().values().stream().allMatch(e -> e.isConfigured());
	}

	@Override
	public void setConfigured(boolean selected) {
		graph.nodes().values().stream().forEach(e -> e.setConfigured(selected));
	}
}
