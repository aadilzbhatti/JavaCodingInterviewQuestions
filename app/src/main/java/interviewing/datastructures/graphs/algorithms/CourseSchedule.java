package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.DirectedGraph;
import interviewing.datastructures.graphs.structure.Graph;
import interviewing.datastructures.graphs.structure.GraphNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseSchedule {

    public static boolean isPossibleToCompleteCourses(int numCourses, int[][] prerequisites) {
        Graph<Integer> g = new DirectedGraph<>();
        List<GraphNode<Integer>> vertices = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            GraphNode<Integer> vertex = new GraphNode<>(i);
            vertices.add(vertex);
            g.addVertex(vertex);
        }
        for (int[] prereq : prerequisites) {
            g.addEdge(vertices.get(prereq[0]), vertices.get(prereq[1]));
        }
        for (GraphNode<Integer> vertex : g.vertices()) {
            if (containsCycle(g, vertex)) {
                return false;
            }
        }
        return true;
    }

    private static boolean containsCycle(Graph<Integer> g, GraphNode<Integer> start) {
        Set<GraphNode<Integer>> seen = new HashSet<>();
        Deque<GraphNode<Integer>> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            GraphNode<Integer> vertex = stack.pop();
            if (seen.contains(vertex)) {
                return true;
            }
            seen.add(vertex);
            for (GraphNode<Integer> neighbor : g.getNeighborsOf(vertex)) {
                stack.push(neighbor);
            }
        }
        return false;
    }
}
