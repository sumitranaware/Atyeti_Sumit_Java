package stream_api.que7.model;

import java.util.List;

public class Employee {
    private String name;
    private String department;
    private int rating;
    private boolean isActive;
    private List<String>skills;

    public Employee(String name, String department, int rating, boolean isActive, List<String> skills) {
        this.name = name;
        this.department = department;
        this.rating = rating;
        this.isActive = isActive;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", rating=" + rating +
                ", isActive=" + isActive +
                ", skills=" + skills +
                '}';
    }
}
