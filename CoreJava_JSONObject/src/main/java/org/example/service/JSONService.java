package org.example.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Iterator;
import java.util.Map;

public class JSONService {
    public static void updateNames(JsonNode node){
        if(node.isObject()){
            ObjectNode objectNode=(ObjectNode) node;
            Iterator<Map.Entry<String,JsonNode>>fields=objectNode.fields();
            while(fields.hasNext()){
                Map.Entry<String,JsonNode>entry=fields.next();
                String key=entry.getKey();
                JsonNode value=entry.getValue();

                if("name".equals(key)&&value.isTextual()){
                    objectNode.put(key,"New Name");

                }
                else{
                    updateNames(value);
                }
            }
        }
        else if (node.isArray()){
            for (JsonNode names:node){
                updateNames(names);
            }
        }
    }
}
