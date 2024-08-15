package com.javadesignpatterns.blog.avoidifElse.solution.factory;

import java.util.List;

public interface PathFindingStrategy {

    List<String> findPath(String start, String end);

}
