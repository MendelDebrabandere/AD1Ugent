package Grafen.TopologischSorteren;

import graphlib.graphs.DirectedGraph;
import graphlib.nodes.Node;

import java.util.List;


public interface TopologischSorteren {
    
    List<Node<String>> bepaalTopologischeOrdening(DirectedGraph<String> graph);
    
}
