package email_log_analyzer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExtractRecipients {
    public static void main(String[] args) {
        Set<String> uniqueRec=new HashSet<>();
        try(BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\CoreJava_Strings\\src\\email_log_analyzer\\email_logs.log"))){
       String line;
       while ((line=br.readLine())!=null){
           String [] parts=line.split("\\|");

           for (String part:parts){
               part=part.trim();
               if (part.startsWith("From:")){
                   String email=part.substring(3).trim();
                   uniqueRec.add(email);
               }
           }
       }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Unique Recipients");
        for (String email:uniqueRec ){
            System.out.println(email);
        }
    }
}
