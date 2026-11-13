package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String owner) {
        switch (owner.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                return getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default:
                return new HashSet<>();
        }
    }

    @SafeVarargs
    public final Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> result = new HashSet<>();
        for (Set<Task> set : sets) {
            if (set != null) {
                result.addAll(set);
            }
        }
        return result;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }

    public Set<Task> getDifferences(Set<Task> first, Set<Task> second) {
        Set<Task> result = new HashSet<>(first);
        result.removeAll(second);
        return result;
    }
}
