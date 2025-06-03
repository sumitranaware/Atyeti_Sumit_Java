package ArrayList.que1;

import javax.management.ObjectName;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCapacity {
  private Object[] data;
  private int size;
  private int capacity;

  public ListCapacity(){
      capacity=10;
      data=new Object[capacity];
  }

  public void add(Object element){
      if(size==capacity){
          grow();
      }
      data[size++]=element;
  }

  private void grow(){
      int oldCap=capacity;
      capacity=oldCap+(oldCap>>1);
      Object[] newData=new Object[capacity];
      System.arraycopy(data,0,newData,0,size);
      data=newData;

      System.out.println("Capacity increased from "+oldCap+" to "+capacity);
  }

    public Object get(int index) {
        if(index>=size||index<0)throw  new IndexOutOfBoundsException();
        return data[index];
    }

    public void setData(Object[] data) {
        this.data = data;
    }
    public int size() {
        return size;
    }
    public int currentCapacity() {
        return capacity;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
