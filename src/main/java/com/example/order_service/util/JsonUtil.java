package com.example.order_service.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 *json工具
 */
public class JsonUtil {

    private static final ObjectMapper objMapper = new ObjectMapper();


    /**
     * json字符串转JsonNode
     * @param str
     * @return
     */
    public static JsonNode str2JsonNode(String str){
        try {
            return objMapper.readTree(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
