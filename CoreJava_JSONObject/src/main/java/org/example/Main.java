package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

import static org.example.service.JSONService.updateNames;

public class Main {
    public static void main(String[] args) {

        String FILE_NAME = "C:\\Users\\SumitRanaware\\OneDrive - Atyeti Inc\\Desktop\\Atyeti_Sumit_Java\\CoreJava_JSONObject\\src\\main\\java\\org\\example\\database\\data.json";
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode read;
        try {
            read = objectMapper.readTree(new File(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        updateNames(read);

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_NAME), read);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(read));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}