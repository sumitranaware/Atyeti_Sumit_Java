package flatmap.service;

import flatmap.model.Book;
import flatmap.model.Library;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class LibraryService {
    public List<String>getAllBooks(Library library){
        return library.getShelves().stream()
                .flatMap(shelf -> shelf.getBooks().stream())
                .map(Book::getTitle)
                .toList();
    }
    public Set<String>getAllUnique(Library library){
        return library.getShelves().stream()
                .flatMap(shelf -> shelf.getBooks().stream())
                .flatMap(book -> book.getTag().stream()
                .flatMap(List::stream))
                .collect(Collectors.toSet());

    }
    public List<String>getBookWithTags(Library library){
        return library.getShelves().stream()
                .flatMap(shelf -> shelf.getBooks().stream())
                .filter(book -> book.getTag().isPresent())
                .map(Book::getTitle)
                .toList();
    }
    public Map<String, List<String>>getTagBookMap(Library library){
        return library.getShelves().stream()
                .flatMap(shelf -> shelf.getBooks().stream())
                .flatMap(book -> book.getTag()
                        .stream()
                        .flatMap(List::stream)
                        .map(tag->Map.entry(tag,book.getTitle())))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue,Collectors.toList())
                ));

    }
    public List<String>flattenSectionMap(Map<String,List<Book>>sectionMap){
        return sectionMap.values().stream()
                .flatMap(List::stream)
                .map(Book::getTitle)
                .toList();
    }
}
