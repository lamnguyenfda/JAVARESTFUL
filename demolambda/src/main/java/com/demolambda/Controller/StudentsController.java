package com.demolambda.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demolambda.entity.Student;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/student/")
public class StudentsController {
    
    @GetMapping("list")
    public String getStudents(ModelMap model,@RequestParam("index") Optional<Integer> index   ) throws StreamReadException, DatabindException, IOException {
    ObjectMapper op = new ObjectMapper();
    TypeReference<List<Student>> type  = new TypeReference<List<Student>>(){};
    List<Student> ls = op.readValue(new ClassPathResource("/static/demo2.json").getFile(),type);
       System.out.println( ls.get(index.orElse(0)).toString());
        model.addAttribute("sv",ls.get(index.orElse(0)));
        model.addAttribute("dssv",ls);
        return "list-student";
    }
    
}
