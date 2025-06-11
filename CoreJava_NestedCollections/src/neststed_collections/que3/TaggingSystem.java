package neststed_collections.que3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 3. Map<String, Set<String>> — Tagging System
 Store tags per post/user uniquely.
 Problem:
 Given a map of user → tags, perform:
 Add a new tag
 Merge tags of two users
 Count users with a specific tag
 */
public class TaggingSystem {
    public static void main(String[] args) {
        Map<String , Set<String>>userTags=new HashMap<>();
        userTags.put("User1",new HashSet<>(Set.of("Java","Spring")));
        userTags.put("User2",new HashSet<>(Set.of("Java","Docker")));
        userTags.put("User3",new HashSet<>(Set.of("html","css")));

        userTags.computeIfAbsent("User1",k->new HashSet<>()).add("Hibernate");
        Set<String>mergedTags=new HashSet<>(userTags.get("User1"));
        mergedTags.addAll(userTags.get("User2"));
        userTags.put("User4",mergedTags);

        long javaCount=userTags.values().stream()
                .filter(tags->tags.contains("Java"))
                .count();

        System.out.println("Updated user tags");
        userTags.forEach((user,tags)-> System.out.println(user+" "+tags));

        System.out.println("\nUsers with java tag: "+javaCount);
    }
}
