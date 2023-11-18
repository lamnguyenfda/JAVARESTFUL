package com.demolambda.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home/")  
public class HomeController {

     @GetMapping("index")
     public String getPage(ModelMap model){
       model.addAttribute("message", "HelloooLam");
        return "#";
     }
          @GetMapping("link")
     public String getLInk(ModelMap model){
       model.addAttribute("message", "HelloLam");
        return "link";
     }
}
