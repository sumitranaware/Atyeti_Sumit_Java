package longest_sub_string;

import java.util.Map;

public class SubString {
    public static boolean unique(String str, int i , int j){
        boolean[]visited=new boolean[26];

        for(int k=i;k<=j;k++){
            if (visited[str.charAt(k)-'a']==true)
            return false;
            visited[str.charAt(k)-'a']=true;
        }
        return true;
    }

    public static int uniqueSub(String str){
        int n=str.length();

        int result=0;

        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                if (unique(str,i,j))
                    result= Math.max(result,j-i+1);


        }
        return result;
    }

}
