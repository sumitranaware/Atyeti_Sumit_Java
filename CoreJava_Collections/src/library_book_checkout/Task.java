package library_book_checkout;

import java.time.LocalDate;
import java.util.*;

public class Task {
    public static void main(String[] args) {
        List<CheckoutRecords>checkoutRecords=new ArrayList<>();
        checkoutRecords.add(new CheckoutRecords("sumitranaware","Java", LocalDate.of(2025,5,10)));
        checkoutRecords.add(new CheckoutRecords("shubham","Spring",LocalDate.of(2025,5,15)));
        checkoutRecords.add(new CheckoutRecords("rohit","Clean COde",LocalDate.of(2025,5,16)));
        checkoutRecords.add(new CheckoutRecords("sumitranaware","DSA",LocalDate.of(2025,5,12)));


        Map<String , Set<String>> stringSetMap=new HashMap<>();

        for (CheckoutRecords c1:checkoutRecords){
            stringSetMap
                    .computeIfAbsent(c1.getUsername(),k->new HashSet<>())
                    .add(c1.getBookTitle());
        }
        String maxUser=null;
        int maxCount=0;

        for(Map.Entry<String ,Set<String>>entry:stringSetMap.entrySet()){
            String user=entry.getKey();
            Set <String>books=entry.getValue();
            System.out.println("user :"+user);
            System.out.println("book :"+books);
            System.out.println("bookSize :"+books.size());

            if(books.size()>maxCount){
                maxCount=books.size();
                maxUser=user;
            }
        }
        System.out.println("User "+maxUser+" with count "+ maxCount);
    }
}
