package com.demolambda.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJackson {
    public static void main(String[] args) throws Exception{

     demo2();
    }

    private static void demo2() throws IOException {
        // Đọc data từ file JSON bên ngoài 
     
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new File("demolambda/src/main/resources/static/demo.json"));

        System.out.println(node.get("name").asText());
        node.get("subjects").iterator().forEachRemaining(arg0 -> {String subject = arg0.asText();System.out.println(subject);});
    }

    private static void demo1() throws Exception {
        //Reading JSON
           String json = "{\r\n" +
                " \"name\": \"Nguyen ngoc Lam\",\r\n" +
                " \"marks\": 7.5,\r\n" +
                " \"gender\": true,\r\n" +
                " \"contacts\":{\r\n" +
                " \"email\": \"Nguyen@gmail.com\",\r\n" +
                " \"phone\": \"0984629221\"\r\n" +
                "}\r\n" +
                "}";             
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);


        String name = node.get("name").asText();
        double marks = node.get("marks").asDouble();
        boolean gender = node.get("gender").asBoolean();
        String email = node.get("contacts").get("email").asText();
        String phone = node.get("contacts").get("phone").asText();

        

        // Print the extracted values
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);

    }
}