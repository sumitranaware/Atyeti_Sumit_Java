import dao.LogDao;
import service.LogAnalyzerService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

            List<String> allDirectories = Arrays.asList(
                    "C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\LogAnalyzerAndReportGenerator\\logs"
            );

            LogAnalyzerService logAnalyzerService = new LogAnalyzerService();

            logAnalyzerService.processLogs(allDirectories);

            String FILE_PATH = "C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\LogAnalyzerAndReportGenerator\\src\\utility\\LogCopy.log";
           // logAnalyzerService.copyFilesTo(FILE_PATH);
        }
}