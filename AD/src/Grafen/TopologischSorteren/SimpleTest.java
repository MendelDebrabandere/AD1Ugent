package Grafen.TopologischSorteren;

import graphlib.edges.DirectedEdge;
import graphlib.graphs.DirectedGraph;
import graphlib.util.Graphs;
import graphlib.nodes.Node;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

public class SimpleTest {

    private static TopologischSorteren ts;


    @BeforeClass
    public static void init() {
        ts = new MijnTopologischSorteren();
    }

    @Test
    public void test1() {

        DirectedGraph<String> graph = new DirectedGraph<>();

        graph.addNode(new Node<>("n"));

        List<Node<String>> topolOrdStud = ts.bepaalTopologischeOrdening(Graphs.unmodifiableDirectedGraph(graph));

        //Bij deze graaf is de oplossing uniek!
        List<Node<String>> expectedSolution = Collections.singletonList(
                graph.getNode("n")
        );

        Assert.assertEquals(expectedSolution, topolOrdStud);

    }

    @Test
    public void test2() {

        DirectedGraph<String> graph = new DirectedGraph<>();

        for(int i = 0; i < 3; i++){
            graph.addNode(new Node<>("n" + i));
        }

        voegBoogToe(graph,"n1","n0");
        voegBoogToe(graph,"n1","n2");
        voegBoogToe(graph,"n2","n0");

        List<Node<String>> topolOrdStud = ts.bepaalTopologischeOrdening(Graphs.unmodifiableDirectedGraph(graph));

        //Bij deze graaf is de oplossing uniek!
        List<Node<String>> expectedSolution = Arrays.asList(
                graph.getNode("n1"),
                graph.getNode("n2"),
                graph.getNode("n0")
        );

        Assert.assertEquals(expectedSolution, topolOrdStud);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test3() {

        DirectedGraph<String> graph = new DirectedGraph<>();

        for(int i = 0; i < 3; i++){
            graph.addNode(new Node<>("n" + i));
        }

        voegBoogToe(graph,"n1","n0");
        voegBoogToe(graph,"n0","n1");
        voegBoogToe(graph,"n1","n2");
        voegBoogToe(graph,"n2","n0");

        ts.bepaalTopologischeOrdening(Graphs.unmodifiableDirectedGraph(graph));

    }

    @Test
    public void test4() {

        DirectedGraph<String> graph = new DirectedGraph<>();

        for(int i = 0; i < 4; i++){
            graph.addNode(new Node<>("n" + i));
        }

        voegBoogToe(graph,"n1","n0");
        voegBoogToe(graph,"n2","n0");
        voegBoogToe(graph,"n2","n1");
        voegBoogToe(graph,"n3","n0");
        voegBoogToe(graph,"n3","n1");
        voegBoogToe(graph,"n3","n2");

        List<Node<String>> topolOrdStud = ts.bepaalTopologischeOrdening(Graphs.unmodifiableDirectedGraph(graph));

        //Bij deze graaf is de oplossing uniek!
        List<Node<String>> topolOrdOpl = Arrays.asList(
                graph.getNode("n3"),
                graph.getNode("n2"),
                graph.getNode("n1"),
                graph.getNode("n0")
        );

        Assert.assertEquals(topolOrdOpl, topolOrdStud);

    }

    @Test
    public void test5() {

        DirectedGraph<String> graph = new DirectedGraph<>();

        for(int i = 0; i < 7; i++){
            graph.addNode(new Node<>("n" + i));
        }

        voegBoogToe(graph,"n0","n1");
        voegBoogToe(graph,"n1","n3");
        voegBoogToe(graph,"n1","n4");
        voegBoogToe(graph,"n2","n0");
        voegBoogToe(graph,"n2","n3");
        voegBoogToe(graph,"n2","n5");
        voegBoogToe(graph,"n3","n4");
        voegBoogToe(graph,"n3","n5");
        voegBoogToe(graph,"n3","n6");
        voegBoogToe(graph,"n4","n6");
        voegBoogToe(graph,"n6","n5");

        List<Node<String>> topolOrdStud = ts.bepaalTopologischeOrdening(Graphs.unmodifiableDirectedGraph(graph));

        //Bij deze graaf is de oplossing uniek!
        List<Node<String>> topolOrdOpl = Arrays.asList(
                graph.getNode("n2"),
                graph.getNode("n0"),
                graph.getNode("n1"),
                graph.getNode("n3"),
                graph.getNode("n4"),
                graph.getNode("n6"),
                graph.getNode("n5")
        );

        Assert.assertEquals(topolOrdOpl, topolOrdStud);

    }

    @Test
    public void test6() {

        DirectedGraph<String> graph = new DirectedGraph<>();

        for(int i = 0; i < 7; i++){
            graph.addNode(new Node<>("n" + i));
        }

        voegBoogToe(graph,"n0","n1");
        voegBoogToe(graph,"n0","n2");
        voegBoogToe(graph,"n0","n4");
        voegBoogToe(graph,"n0","n6");
        voegBoogToe(graph,"n1","n5");
        voegBoogToe(graph,"n2","n3");
        voegBoogToe(graph,"n3","n4");
        voegBoogToe(graph,"n4","n1");
        voegBoogToe(graph,"n4","n6");
        voegBoogToe(graph,"n4","n5");
        voegBoogToe(graph,"n6","n1");

        List<Node<String>> topolOrdStud = ts.bepaalTopologischeOrdening(Graphs.unmodifiableDirectedGraph(graph));

        //Bij deze graaf is de oplossing uniek!
        List<Node<String>> topolOrdOpl = Arrays.asList(
                graph.getNode("n0"),
                graph.getNode("n2"),
                graph.getNode("n3"),
                graph.getNode("n4"),
                graph.getNode("n6"),
                graph.getNode("n1"),
                graph.getNode("n5")
        );

        System.out.println(graph.toMermaid());

        Assert.assertEquals(topolOrdOpl, topolOrdStud);

    }

    @Test(expected = IllegalArgumentException.class)
    public void test7() {

        DirectedGraph<String> graph = new DirectedGraph<>();

        for(int i = 0; i < 5; i++){
            graph.addNode(new Node<>("n" + i));
        }

        voegBoogToe(graph,"n0","n1");
        voegBoogToe(graph,"n1","n2");
        voegBoogToe(graph, "n1", "n4");
        voegBoogToe(graph, "n4", "n1");
        voegBoogToe(graph,"n2","n3");

        ts.bepaalTopologischeOrdening(Graphs.unmodifiableDirectedGraph(graph));

    }

    public void voegBoogToe(DirectedGraph<String> graph, String n1, String n2){
        graph.addEdge(new DirectedEdge<>(graph.getNode(n1), graph.getNode(n2)));
    }

}
