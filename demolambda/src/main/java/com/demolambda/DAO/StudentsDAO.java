package com.demolambda.DAO;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.demolambda.entity.Student;
import com.fasterxml.jackson.databind.JsonNode;

@Repository
public class StudentsDAO {

    RestTemplate rest = new RestTemplate();

    String url = "https://restfullservice-949ef-default-rtdb.firebaseio.com/students.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public StudentMap getModel() {
        StudentMap stm = rest.getForObject(url, StudentMap.class);
        return stm;
    }

    public Student FindByKey(String Key) {
        return rest.getForObject(getUrl(Key), Student.class);
    }

    public String CreateStudent(Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();
    }

    public Student updateData(String Key, Student data) {
        HttpEntity<Student> entity = new HttpEntity<>(data);
        rest.put(getUrl(Key), entity);
        return data;
    }
    public void deleteData(String key){
        rest.delete(getUrl(key));
    }
}