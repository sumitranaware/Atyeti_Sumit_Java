package sets.que2;

public class CollisionObj {
    private final int id;

    public CollisionObj(int id){
        this.id=id;
    }
    public boolean equals(Object obj){
        if (this==obj)return true;
        if (!(obj instanceof CollisionObj))return false;
        CollisionObj other=(CollisionObj) obj;
        return this.id==other.id;


    }

    @Override
    public String toString() {
        return "CollisionObj{" +
                "id=" + id +
                '}';
    }
}
