package flatmap.model;

import java.util.List;

public class Library {
    private String name;
    private List<Shelf>shelves;

    public Library(String name, List<Shelf> shelves) {
        this.name = name;
        this.shelves = shelves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Shelf> getShelves() {
        return shelves;
    }

    public void setShelves(List<Shelf> shelves) {
        this.shelves = shelves;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", shelves=" + shelves +
                '}';
    }
}
