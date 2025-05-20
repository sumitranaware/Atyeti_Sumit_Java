package contact_manager;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Contact {
    private String name;
    private String lastname;
    private Long phoneno;


    public Contact(String name, String lastname, Long phoneno) {
        this.name = name;
        this.lastname = lastname;
        this.phoneno = phoneno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(Long phoneno) {
        this.phoneno = phoneno;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;

        if(!(obj instanceof Contact))
            return false;

        Contact contact=(Contact) obj;
        return phoneno.equals(contact.phoneno)
                && lastname.equalsIgnoreCase(contact.lastname)
                && name.equalsIgnoreCase(contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(),lastname.toLowerCase(),phoneno);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phoneno=" + phoneno +
                '}';
    }
    public static void searchByName(Set<Contact> contacts, String searchname){
        boolean found=false;
        for(Contact contact:contacts){
            if(contact.getName().equalsIgnoreCase(searchname)){
                System.out.println("Found"+contact);
                found=true;
            }
        }
    if(!found){
        System.out.println("No Contacts found with: "+searchname);
    }
    }
}
