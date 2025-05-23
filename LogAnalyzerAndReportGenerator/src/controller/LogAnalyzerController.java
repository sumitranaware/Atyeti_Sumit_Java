package controller;

import dao.LogDao;
import service.LogAnalyzerService;

import java.io.IOException;
import java.util.List;

public class LogAnalyzerController {
    public void LogRunner(List<String>dir){
        LogAnalyzerService logAnalyzerService=new LogAnalyzerService();
        try{
            logAnalyzerService.processLogs(dir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LogDao logDao=new LogDao();
        logDao.saveLog(logAnalyzerService.getLocalDateTime(),logAnalyzerService.getLogCount());
    }
}
