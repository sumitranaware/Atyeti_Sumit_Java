package ArrayList.que2;

import java.util.ArrayList;

/***
 * 2. What is the cost of inserting elements at different positions in an ArrayList?
 * 🔍 Problem: Measure and compare the time to insert elements at:
 * Beginning
 * Middle
 * End
 * Using 100,000 elements in each case.
 */



public class InsertionPerformance {
    public static void main(String[] args) {
       measureInsertion("Beginnig",0);
       measureInsertion("Middle",-1);
       measureInsertion("End",Integer.MAX_VALUE);
    }

    public static void measureInsertion(String position, int indexType){
        int TOTAL_INSERTIONS=100_000;
        ArrayList<Integer>list=new ArrayList<>();
        long startTime=System.nanoTime();
        for (int i=0;i<TOTAL_INSERTIONS;i++){
            int index;
            switch (indexType){
                case 0->index=0;
                case -1->index=list.size()/2;
                default -> index=list.size();
            }
            list.add(index,i);
        }

        long endTime=System.nanoTime();
        long duration=(endTime-startTime)/1_000_000;

        System.out.println("Insertion took "+position +" "+duration);
    }
}
