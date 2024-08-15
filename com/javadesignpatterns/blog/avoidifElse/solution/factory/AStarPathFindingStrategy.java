package com.javadesignpatterns.blog.avoidifElse.solution.factory;

import java.util.List;

public class AStarPathFindingStrategy implements PathFindingStrategy{
    @Override
    public List<String> findPath(String start, String end) {
        // Implement A* algorithm
        System.out.println("Executing A*...");
        return List.of("Start -> ... -> End (A* Path)");
    }
}
