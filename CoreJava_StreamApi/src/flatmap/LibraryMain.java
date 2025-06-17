package flatmap;

import flatmap.model.Book;
import flatmap.model.Library;
import flatmap.model.Shelf;
import flatmap.service.LibraryService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class LibraryMain {
    public static void main(String[] args) {
        Book b1=new Book("Effective Java", Optional.of(List.of("Java","Programming")));
        Book b2=new Book("Clean code ",Optional.of(List.of("Coding","Best Practices")));
        Book b3=new Book("Refactoring",Optional.empty());
        Book b4=new Book("Spring in action",Optional.of(List.of("Java","Spring")));
        Book b5=new Book("Design Pattern",Optional.of(List.of("Architecture")));

        Shelf shelf1=new Shelf("Shelf A",List.of(b1,b2));
        Shelf shelf2=new Shelf("Shelf B",List.of(b3,b4,b5));
        Library library=new Library("City Library",List.of(shelf1,shelf2));


        LibraryService libraryService=new LibraryService();
        System.out.println("All Book Titles");
        libraryService.getAllBooks(library).forEach(System.out::println);

        System.out.println("Unique tags");
        libraryService.getAllUnique(library).forEach(System.out::println);

        System.out.println("Book with tags");
        libraryService.getBookWithTags(library).forEach(System.out::println);

        System.out.println("Tag to books map");
        libraryService.getTagBookMap(library).forEach((tag,books)->System.out.println(tag+" "+books));

        System.out.println(" Flatten Section Map");
        Map<String, List<Book>>stringListMap=Map.of(
                "Tech",List.of(b1,b4),
                "Clean",List.of(b2,b3)
        );
        libraryService.flattenSectionMap(stringListMap).forEach(System.out::println);
    }
}
