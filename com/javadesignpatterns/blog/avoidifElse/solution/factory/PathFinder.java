package com.javadesignpatterns.blog.avoidifElse.solution.factory;

import java.util.List;

public class PathFinder {

    public List<String> findPath(PathFindingStrategyType type, String start, String end) { //(5)!
        return type.getStrategy().findPath(start, end); //(1)!
    }

    public static void main(String[] args) {
        PathFinder pathFinder = new PathFinder();

        System.out.println("Path found using BFS: " + pathFinder.findPath(PathFindingStrategyType.BFS, "A", "B"));
        System.out.println("Path found using DFS: " + pathFinder.findPath(PathFindingStrategyType.DFS, "A", "B"));
        System.out.println("Path found using Dijkstra: " + pathFinder.findPath(PathFindingStrategyType.DIJKSTRA, "A", "B"));
        System.out.println("Path found using A*: " + pathFinder.findPath(PathFindingStrategyType.A_STAR, "A", "B"));
    }

}
