package com.javadesignpatterns.blog.avoidifElse.solution.factory;

import java.util.List;

public class DijkstraPathFindingStrategy implements PathFindingStrategy{
    @Override
    public List<String> findPath(String start, String end) {
        // Implement Dijkstra's algorithm
        System.out.println("Executing Dijkstra...");
        return List.of("Start -> ... -> End (Dijkstra Path)");
    }
}
