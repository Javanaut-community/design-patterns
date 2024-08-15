package com.javadesignpatterns.blog.avoidifElse;

import java.util.List;

public class PathFinder {

    public List<String> findPath(String algorithm, String start, String end) { //(1)!
        if (algorithm.equals("BFS")) { //(2)!
            return bfs(start, end);
        } else if (algorithm.equals("DFS")) {
            return dfs(start, end);
        } else if (algorithm.equals("Dijkstra")) {
            return dijkstra(start, end);
        } else if (algorithm.equals("A*")) {
            return aStar(start, end);
        } else {
            throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        }
    }

    private List<String> bfs(String start, String end) { //(3)!
        // Implement BFS algorithm
        System.out.println("Executing BFS...");
        return List.of("Start -> ... -> End (BFS Path)");
    }

    private List<String> dfs(String start, String end) {
        // Implement DFS algorithm
        System.out.println("Executing DFS...");
        return List.of("Start -> ... -> End (DFS Path)");
    }

    private List<String> dijkstra(String start, String end) {
        // Implement Dijkstra's algorithm
        System.out.println("Executing Dijkstra...");
        return List.of("Start -> ... -> End (Dijkstra Path)");
    }

    private List<String> aStar(String start, String end) {
        // Implement A* algorithm
        System.out.println("Executing A*...");
        return List.of("Start -> ... -> End (A* Path)");
    }

    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder();

        List<String> path1 = pathFinder.findPath("BFS", "A", "B");
        System.out.println("Path found using BFS: " + path1);

        List<String> path2 = pathFinder.findPath("DFS", "A", "B");
        System.out.println("Path found using DFS: " + path2);

        List<String> path3 = pathFinder.findPath("Dijkstra", "A", "B");
        System.out.println("Path found using Dijkstra: " + path3);

        List<String> path4 = pathFinder.findPath("A*", "A", "B");
        System.out.println("Path found using A*: " + path4);
    }

}
