package QueueAndDeque.que5;

import java.util.Comparator;

public class Task implements Comparable<Task> {
    private String name;
    private int priority;

    public Task(String name, int priority){
        this.name=name;
        this.priority=priority;
    }
    public String getName(){
        return name;
    }

    public int compareTo(Task task){
        return Integer.compare(this.priority,task.priority);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}
