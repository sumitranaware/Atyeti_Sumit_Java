package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class LogAnalyzerServiceTest {
    LogAnalyzerService logAnalyzerService;
    List<String> sample;
    @BeforeEach
    void setUp() {
        logAnalyzerService=new LogAnalyzerService();
        sample=Arrays.asList("C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\LogAnalyzerAndReportGenerator\\src\\utility\\samplelogs.log");
    }


    @Test
     void processLogs_validFile(){
        assertDoesNotThrow(()-> logAnalyzerService.processLogs(sample));
    }

     @Test
     void getLogCount() throws IOException {
         logAnalyzerService.processLogs(sample);
         Map<String, Integer> countMap = logAnalyzerService.getLogCount();
         for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
             assertTrue(entry.getValue() > 0, "Log should be greater than zero"+entry.getKey()+"should be greater than zero");
         }
     }
    @Test
    void processLogs() throws IOException {
        logAnalyzerService.processLogs(sample);
    }
}