package com.example.controller;


import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.controller.services.CustomerService;
import com.example.entity.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin("*")
@RestController
public class HomeController {
   
    @Autowired
    CustomerService dao ;

   @GetMapping("/rest/customers")
   public List<Customer> getAll()  throws IOException{
        List<Customer> ls = dao.findAll();
        return ls;
   }
   @GetMapping("/rest/customers/{id}")
   public Customer getBId(@PathVariable("id") Integer id) {
       return dao.findById(id).get();
   }
   @PostMapping("/rest/customers")
   public Customer post(@RequestBody Customer entity){
    dao.save(entity);
       return entity;
   }
   @PutMapping("/rest/customers/{id}")
   public Customer put(@PathVariable("id") Integer id,@RequestBody Customer entity) {
     if (dao.findById(id).isPresent()) {
         dao.save(entity);
         return entity;
     }
       return null;
       
   }
   @DeleteMapping("/rest/customers/{id}")
   public void delete(@PathVariable("id") Integer id) {
          dao.deleteById(id);
   }
}
