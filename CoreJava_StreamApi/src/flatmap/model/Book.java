package flatmap.model;

import java.util.List;
import java.util.Optional;

public class Book {
    private String title;
    private Optional<List<String>>tag;

    public Book(String title, Optional<List<String>> tag) {
        this.title = title;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Optional<List<String>> getTag() {
        return tag;
    }

    public void setTag(Optional<List<String>> tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", tag=" + tag +
                '}';
    }
}
