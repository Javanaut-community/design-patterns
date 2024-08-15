package com.javadesignpatterns.blog.avoidifElse.solution.factory;

public enum PathFindingStrategyType {

    A_STAR(new AStarPathFindingStrategy()), //(1)!
    BFS(new BFSPathFindingStrategy()),
    DFS(new DFSPathFindingStrategy()),
    DIJKSTRA(new DijkstraPathFindingStrategy());

    private PathFindingStrategy strategy; //(2)!

    PathFindingStrategyType(PathFindingStrategy strategy) { //(3)!
        this.strategy = strategy;
    }

    public PathFindingStrategy getStrategy() {
        return strategy;
    }
}
