package HashMap.que1;

import java.util.Objects;

public class HashMapKeyValue {
    private String value;
    public HashMapKeyValue(String value){
        this.value=value;
    }
    public int hashCode(){
        return 42;
    }
    public boolean equals(Object o){
        if(this==o)return true;

        if (!(o instanceof HashMapKeyValue)) return false;
        HashMapKeyValue  that=(HashMapKeyValue) o;
        return Objects.equals(value,that.value);
    }

    @Override
    public String toString() {
        return "HashMapKeyValue{" +
                "value='" + value + '\'' +
                '}';
    }
}
