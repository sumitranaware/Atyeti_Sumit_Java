package contact_manager;

import java.util.*;

import static contact_manager.Contact.searchByName;

public class ContactMain {
    public static void main(String[] args) {
        List<Contact> contactList=new ArrayList<>();
        contactList.add(new Contact("Sumit","Ranaware",9899999899L));
        contactList.add(new Contact("Shubham","Palkar", 497649334L));
        contactList.add(new Contact("Sumit","Ranaware",9899999899L));
        contactList.add(new Contact("Rohit","Patil",878689669L));

        Set<Contact> s1=new HashSet(contactList);

        for (Object s2:s1){
            System.out.println(s2);

        }

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name to search");
        String name=sc.nextLine();
        searchByName(s1,name);

    }
}
