package LinkedList.que2;

import java.util.LinkedList;

public class PerformanceMeasure {
    private static final int ELEMENTS=100_000;
    public static void measureInsertionAtHead(){
        LinkedList<Integer>list=new LinkedList<>();
        long start=System.currentTimeMillis();

        for (int i=0;i<ELEMENTS;i++){
                list.add(0,i);
            }
        long end=System.currentTimeMillis();
        System.out.println("Time to insert at head "+(end-start)+ "ms");
        }
        public static void measureInsertAtMiddle(){
        LinkedList<Integer>list=new LinkedList<>();
        long start=System.currentTimeMillis();
        for(int i=0;i<ELEMENTS;i++){
            list.add(list.size()/2,i);
        }
        long end=System.currentTimeMillis();
            System.out.println("Time to insert at middle "+(end-start)+" ms");
        }

        public static void measureInsertionAtTail(){
        LinkedList<Integer>list =new LinkedList<>();
        long start=System.currentTimeMillis();
        for (int i=0;i<ELEMENTS;i++){
            list.add(i);
        }
        long end=System.currentTimeMillis();
            System.out.println("Time to insert at end " +(end-start)+" ms");
        }

    }



