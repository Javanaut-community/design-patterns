package com.javadesignpatterns.blog.avoidifElse.solution;


import java.util.List;

interface PathFindingStrategy { //(1)!
    List<String> findPath(String start, String end);
}

class BFSPathFindingStrategy implements PathFindingStrategy { //(2)!
    public List<String> findPath(String start, String end) {
        // Implement BFS algorithm
        System.out.println("Executing BFS...");
        return List.of("Start -> ... -> End (BFS Path)");
    }
}

class DFSPathFindingStrategy implements PathFindingStrategy {
    public List<String> findPath(String start, String end) {
        // Implement DFS algorithm
        System.out.println("Executing DFS...");
        return List.of("Start -> ... -> End (DFS Path)");
    }
}

class DijkstraPathFindingStrategy implements PathFindingStrategy {
    public List<String> findPath(String start, String end) {
        // Implement Dijkstra's algorithm
        System.out.println("Executing Dijkstra...");
        return List.of("Start -> ... -> End (Dijkstra Path)");
    }
}

class AStarPathFindingStrategy implements PathFindingStrategy {
    public List<String> findPath(String start, String end) {
        // Implement A* algorithm
        System.out.println("Executing A*...");
        return List.of("Start -> ... -> End (A* Path)");
    }
}

public class PathFinder {

    private PathFindingStrategy strategy; //(3)!

    public void setPathFindingStrategy(PathFindingStrategy strategy) { //(4)!
        this.strategy = strategy;
    }

    public List<String> findPath(String start, String end) { //(5)!
        return strategy.findPath(start, end);
    }

    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder();

        pathFinder.setPathFindingStrategy(new BFSPathFindingStrategy());
        System.out.println("Path found using BFS: " + pathFinder.findPath("A", "B"));

        pathFinder.setPathFindingStrategy(new DFSPathFindingStrategy());
        System.out.println("Path found using DFS: " + pathFinder.findPath("A", "B"));

        pathFinder.setPathFindingStrategy(new DijkstraPathFindingStrategy());
        System.out.println("Path found using Dijkstra: " + pathFinder.findPath("A", "B"));

        pathFinder.setPathFindingStrategy(new AStarPathFindingStrategy());
        System.out.println("Path found using A*: " + pathFinder.findPath("A", "B"));
    }

}
