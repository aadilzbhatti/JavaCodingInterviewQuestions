package interviewing.datastructures.graphs.algorithms;

import interviewing.datastructures.graphs.structure.Graph;
import interviewing.datastructures.graphs.structure.GraphNode;
import interviewing.datastructures.graphs.structure.UndirectedGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputeEnclosedRegions {

    public static void fillEnclosedRegions(int[][] arr) {
        Graph<Point> g = new UndirectedGraph<>();
        List<List<GraphNode<Point>>> vertices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<GraphNode<Point>> row = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                GraphNode<Point> vertex;
                if (arr[i][j] == 0) {
                    vertex = new GraphNode<>(new Point(i, j, Color.WHITE));
                    g.addVertex(vertex);
                } else {
                    vertex = new GraphNode<>(new Point(i, j, Color.BLACK));
                }
                row.add(vertex);
            }
            vertices.add(row);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                GraphNode<Point> curr = vertices.get(i).get(j);
                if (curr.getData().color == Color.WHITE) {
                    if (i < arr.length - 1) {
                        GraphNode<Point> downVertex = vertices.get(i + 1).get(j);
                        if (downVertex.getData().color == curr.getData().color) {
                            g.addEdge(curr, downVertex);
                        }
                    }
                    if (j < arr.length - 1) {
                        GraphNode<Point> rightVertex = vertices.get(i).get(j + 1);
                        if (rightVertex.getData().color == curr.getData().color) {
                            g.addEdge(curr, rightVertex);
                        }
                    }
                }
            }
        }
        Deque<GraphNode<Point>> queue = new ArrayDeque<>();
        Set<GraphNode<Point>> seen = new HashSet<>();
        for (GraphNode<Point> vertex : g.vertices()) {
            if (!seen.contains(vertex)) {
                boolean reachesBoundary = false;
                queue.add(vertex);
                while (!queue.isEmpty()) {
                    GraphNode<Point> v = queue.poll();
                    if (!seen.contains(v)) {
                        seen.add(v);
                        if (v.getData().i == 0 || v.getData().j == 0 ||
                                v.getData().i == arr.length - 1 || v.getData().j == arr.length - 1) {
                            reachesBoundary = true;
                        }
                        queue.addAll(g.getNeighborsOf(v));
                    }
                }
                if (!reachesBoundary) {
                    Set<GraphNode<Point>> visited = new HashSet<>();
                    queue.add(vertex);
                    while (!queue.isEmpty()) {
                        GraphNode<Point> v = queue.poll();
                        if (!visited.contains(v)) {
                            arr[v.getData().i][v.getData().j] = 1;
                            queue.addAll(g.getNeighborsOf(v));
                            visited.add(v);
                        }
                    }
                }
            }
        }
    }

    private static class Point {
        int i;
        int j;
        Color color;

        Point(int i, int j, Color color) {
            this.i = i;
            this.j = j;
            this.color = color;
        }

        @Override
        public String toString() {
            return "(" + i + ", " + j + ", " + color + ")";
        }
    }

    private static enum Color {
        WHITE,
        BLACK
    }
}
