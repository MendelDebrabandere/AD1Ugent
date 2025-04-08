package Grafen.TopologischSorteren;

import graphlib.edges.Edge;
import graphlib.graphs.DirectedGraph;
import graphlib.nodes.Node;

import java.util.*;

public class MijnTopologischSorteren implements TopologischSorteren {
    @Override
    public List<Node<String>> bepaalTopologischeOrdening(DirectedGraph<String> graph) {

        List<Node<String>> nodes = new ArrayList<>(graph.getAllNodes());
        List<Node<String>> result = new ArrayList<>();
        Queue<Node<String>> queue = new LinkedList<>();


        Map<Node<String>, Integer> nodeToIndex = new HashMap<>();
        for (int i = 0; i < nodes.size(); i++) {
            nodeToIndex.put(nodes.get(i), i);
        }

        int[] indegrees = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            indegrees[i] = graph.getIndegree(nodes.get(i));
            if (indegrees[i] == 0) {
                queue.add(nodes.get(i));
            }
        }


        int visited = 0;
        while (!queue.isEmpty()) {
            Node<String> node = queue.poll();
            result.add(node);
            visited++;

            for (Edge<String> edge : graph.getOutgoingEdges(node)) {
                Node<String> neighbor = edge.getNode2();
                int index = nodeToIndex.get(neighbor);
                indegrees[index]--;
                if (indegrees[index] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (visited != nodes.size()) {
            throw new IllegalArgumentException("Graph contains a cycle, cannot topologically sort");
        }

        return result;
    }
}
