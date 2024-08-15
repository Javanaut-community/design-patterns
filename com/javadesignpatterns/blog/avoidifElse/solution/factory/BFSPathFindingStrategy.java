package com.javadesignpatterns.blog.avoidifElse.solution.factory;

import java.util.List;

public class BFSPathFindingStrategy implements PathFindingStrategy{
    @Override
    public List<String> findPath(String start, String end) {
        System.out.println("Executing BFS...");
        return List.of("Start -> ... -> End (BFS Path)");
    }
}
