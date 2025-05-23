package service;

import utility.FileWriterUtility;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogAnalyzerService  {
    private final Map<String ,Integer>logCount=new ConcurrentHashMap<>();
    private  LocalDateTime localDateTime=LocalDateTime.now();
    private final ExecutorService executorService= Executors.newFixedThreadPool(4);
  //   FileWriterUtility fileWriterUtility=new FileWriterUtility();
    private final List<String> collectedFilePaths = new ArrayList<>();
    public Map<String, Integer> getLogCount() {
        return logCount;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public  void  processLogs(List<String>directoryPath) throws IOException {
        List<Runnable> tasks = new ArrayList<>();

        for (String dir : directoryPath) {
            File directory = new File(dir);
            File[] logFiles = directory.listFiles((d, name) -> name.endsWith(".log"));

            if (logFiles == null || logFiles.length == 0) return;

            for (File logFile : logFiles) {
                tasks.add(() -> processSingleFile(logFile));
            }
        }

        for (Runnable task : tasks) {
            executorService.submit(task);
        }

        executorService.shutdown();

    }

    private   void processSingleFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("ERROR")) {
                    logCount.merge("ERROR", 1, Integer::sum);
                } else if (line.contains("WARNING")) {
                    logCount.merge("WARNING", 1, Integer::sum);
                } else if (line.contains("INFO")) {
                    logCount.merge("INFO", 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            System.err.println("Error processing file: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }
    // this code is just for copying the logs to different log file - file operation

//    public void copyFilesTo(String destinationPath) throws IOException {
//        if (collectedFilePaths.isEmpty()) {
//            System.out.println("No log files to copy.");
//        } else {
//            System.out.println("Copying files to: " + destinationPath);
//            collectedFilePaths.forEa  ch(System.out::println);
//            fileWriterUtility.writeLogsToFile(collectedFilePaths, destinationPath);
//            System.out.println("Copy complete.");
//        }




    }

