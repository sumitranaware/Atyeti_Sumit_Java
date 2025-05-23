package utility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorWriter {
    static String  ERROR_FILE = "C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\LogAnalyzerAndReportGenerator\\src\\utility\\Erros.txt";

    public static void saveError(String message) {
        try (
            BufferedWriter br = new BufferedWriter(new FileWriter(ERROR_FILE))){
            String line;
            br.write(message);
            br.newLine();
        }
        catch (Exception e){
            System.out.println("Error while reading the file"+e.getMessage());
        }
    }
}