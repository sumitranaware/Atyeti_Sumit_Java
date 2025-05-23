package utility;

import java.io.*;
import java.util.List;

public class FileWriterUtility {
    public void writeLogsToFile(List<String> inputFiles, String filePath) throws IOException {
        try (BufferedWriter brw = new BufferedWriter(new FileWriter(filePath))) {
            for (String file : inputFiles) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        brw.write(line);
                        brw.newLine();
                    }
                }
            }
        }
    }
}
