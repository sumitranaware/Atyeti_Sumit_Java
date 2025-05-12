package org.example.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileHandler {
    private static final ObjectMapper objectMapper=new ObjectMapper();

    public static <T>List<T> readFromJsonFile(String filePath , Class<T>cla){
        File file=new File(filePath);
        if(!file.exists()){
            return new ArrayList<>();
        }
        try{
            return objectMapper.readValue(file,objectMapper.getTypeFactory().constructCollectionType(List.class,cla));

        }catch (IOException e){
            System.out.println("Error while reading the JSON file");
            return new ArrayList<>();
        }
    }


    public static <T> void writeToJsonFile(String filePath, List<T> list){
        try{
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath),list);
        }catch (IOException e){
            System.out.println("Error while writing to JSON file"+e.getMessage());
        }
    }
}
