package com.rcm.dataStructure.Graph;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

/**
 * Custom class that implements a bidirectional & unweighted Graph using an adjacency list to define the node connectivity
 * Making use of HashTable available in the Java API
 */
public class MyGraph {

    private int _size;
    private Hashtable<Integer, List<GraphNode>> _adjacentList;

    MyGraph() {
        this._adjacentList = new Hashtable<>();
    }

    /**
     * Method to add unique nodes to the graph
     * Time Complexity - O(1)
     * @param val
     * @return
     */
    public boolean addVertex(int val) {
        GraphNode node = new GraphNode(val);
        if(!_adjacentList.containsKey(val)) {
            _adjacentList.put(val, new ArrayList<>());
            _size++;
            return true;
        }
        return false;
    }

    /**
     * Builds the adjacency list used to define the node connections
     * @param v1
     * @param v2
     * @return
     */
    public boolean addEdge(int v1, int v2) {
        if(_adjacentList.containsKey(v1) && _adjacentList.containsKey(v2)) { // Ensure that the node is first present in the graph
            List<GraphNode> list = _adjacentList.get(v1);
            List<GraphNode> list2 = _adjacentList.get(v2);
            GraphNode edge = new GraphNode(v2);
            GraphNode edge2 = new GraphNode(v1);
            if(!list.contains(edge)) { // adding bidirectional relationship
                list.add(edge);
            }
            if(!list2.contains(edge2)) { // adding bidirectional relationship
                list2.add(edge2);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "MyGraph{" +
                "_size=" + _size +
                ", _adjacentList=" + _adjacentList +
                '}';
    }
}

class GraphNode {

    int value;

    GraphNode() {

    }

    public GraphNode(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return value == graphNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "value=" + value +
                '}';
    }
}

class TestMyGraph {
    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        System.out.println("Add 0: "+graph.addVertex(0));
        System.out.println("Add 1: "+graph.addVertex(1));
        System.out.println("Add 2: "+graph.addVertex(2));
        System.out.println("Add 3: "+graph.addVertex(3));
        System.out.println("Add 4: "+graph.addVertex(4));
        System.out.println("Add 5: "+graph.addVertex(5));
        System.out.println("Add 6: "+graph.addVertex(6));
        System.out.println("Adding edge 3, 1 : "+graph.addEdge(3,1));
        System.out.println("Adding edge 3, 4 : "+graph.addEdge(3,4));
        System.out.println("Adding edge 3, 4 : "+graph.addEdge(3,4));
        System.out.println("Adding edge 4, 2 : "+graph.addEdge(4,2));
        System.out.println("Adding edge 4, 5 : "+graph.addEdge(4,5));
        System.out.println("Adding edge 1, 2 : "+graph.addEdge(1,2));
        System.out.println("Adding edge 1, 0 : "+graph.addEdge(1,0));
        System.out.println("Adding edge 0, 2 : "+graph.addEdge(0,2));
        System.out.println("Adding edge 6, 5 : "+graph.addEdge(6,5));


        System.out.println(graph);
    }
}
