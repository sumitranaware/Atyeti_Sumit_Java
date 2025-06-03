package que1;

import ArrayList.que1.ListCapacity;

import javax.naming.PartialResultException;

/***
 que- How does ArrayList grow internally when capacity is exceeded?
 Tried with ArrayList and reflection, but it's not working so created the custom Array to check the capacity.
 */

public class ListCapacityMain {
    public static void main(String[] args) {


        ListCapacity listCapacity = new ListCapacity();
        for (int i = 0; i < 1000; i++) {
            listCapacity.add(i);
            if(i%10==0)
                System.out.println("Added: " + i + " | Size: " + listCapacity.size() + " | Capacity: " + listCapacity.currentCapacity());

        }
    }
}