public class SharedResource {
    private volatile boolean flag=false;

    public void setFlagTrue(){
        System.out.println("Writer thread made the flag true now");
        flag=true;
    }
    public void printIfFlagTrue(){
        while(!flag){
            // do nothing
        }
        System.out.println("Flag is true");
    }

}