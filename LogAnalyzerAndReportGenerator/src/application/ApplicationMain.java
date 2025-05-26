package application;

import controller.LogAnalyzerController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationMain {
    public static void main(String[] args) {
        List<String> allLog = Arrays.asList(
                "C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\LogAnalyzerAndReportGenerator\\logs",
 "C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\LogAnalyzerAndReportGenerator\\log1"
        );
LogAnalyzerController logAnalyzerController =new LogAnalyzerController();
logAnalyzerController.LogRunner(allLog);
        System.out.println("Data inserted");

    }
}