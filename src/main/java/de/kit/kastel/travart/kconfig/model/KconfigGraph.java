package de.kit.kastel.travart.kconfig.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.logicng.formulas.Formula;

// FIXME Try to use a less nested structure (use other representation of dependencies?)
public record KconfigGraph(Map<String, KconfigNode> nodes, ListValuedMap<KconfigNode, MutablePair<Formula, Boolean>> dependencies) {}