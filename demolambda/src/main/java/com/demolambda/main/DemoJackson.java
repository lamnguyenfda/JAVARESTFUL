package com.demolambda.main;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demolambda.entity.staff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJackson {
    public static void main(String[] args) throws Exception{

     demo5();
    }

    private static void demo5() throws IOException {
        //Writing map to json string 

        Map<String,String> contacts = new HashMap<>();
        contacts.put("email", "slamnguyengp01@gmail.com");
        contacts.put("phone", "0982912623");
        List<String> subjects = Arrays.asList("Com107" , "ent201");
        Map<String,Object> staffs = new HashMap<>();
        staffs.put("name", "NGuyen van a ");
        staffs.put("gender",true);
        staffs.put("marks", 8.9);
        staffs.put("Contacts",contacts);
        staffs.put("subjects",subjects);
        

        ObjectMapper ops = new ObjectMapper();
        // String json = ops.writeValueAsString(staffs) ; 
       ops.writeValue(new File("demolambda/src/main/resources/static/demo2.json"),staffs) ; 
        // System.out.println(json);
    }

    private static void demo4() throws Exception {
         //Read Json File to Java planin object

         ObjectMapper op = new ObjectMapper();
         staff staf = op.readValue(new File("demolambda/src/main/resources/static/demo.json"), staff.class);
         System.out.println(staf.toString());
    }

    private static void demo3() throws Exception {
        //Read Json File to Map
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> mapp = mapper.readValue(new File("demolambda/src/main/resources/static/demo.json"),Map.class);
        System.out.println("Name : " + mapp.get("name"));
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

        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Gender: " + gender);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}