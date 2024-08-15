package com.javadesignpatterns.blog.avoidifElse.solution.factory;

import java.util.List;

public class DFSPathFindingStrategy implements PathFindingStrategy{
    @Override
    public List<String> findPath(String start, String end) {
        // Implement DFS algorithm
        System.out.println("Executing DFS...");
        return List.of("Start -> ... -> End (DFS Path)");
    }
}
