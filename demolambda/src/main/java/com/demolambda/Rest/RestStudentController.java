package com.demolambda.Rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demolambda.DAO.StudentsDAO;
import com.demolambda.entity.Student;
import com.demolambda.entity.staff;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/rest/")
public class RestStudentController {
    

    @Autowired
    StudentsDAO dao ;


    @GetMapping("index")
    public String getForm(ModelMap model){
        model.addAttribute("STUDENT", new Student());
        model.addAttribute("liststudent", dao.getModel());   
        return"layout/index";
    }

    @PostMapping("create")
    public String postMethodName(@ModelAttribute("STUDENT") Student st,ModelMap model ){
        dao.CreateStudent(st);
         return"redirect:/rest/index";
    }
    @RequestMapping("update/{key}")
    public String update(ModelMap model,@PathVariable("key") String key,@ModelAttribute("STUDENT") Student st) {
        dao.updateData(key, st);
        return"redirect:/rest/edit/"+key;
    }
     @RequestMapping("edit/{key}")
    public String edit(ModelMap model ,@PathVariable("key") String key) {
        model.addAttribute("key", key);
        model.addAttribute("STUDENT",dao.getModel().get(key));
        model.addAttribute("liststudent", dao.getModel());   
        return"layout/index";
    }
 
 @RequestMapping("delete/{key}")
    public String update(ModelMap model,@PathVariable("key") String key) {
        dao.deleteData(key);
            return"redirect:/rest/index";
    }
    
}
