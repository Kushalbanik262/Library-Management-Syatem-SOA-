package com.example.CrudMicroservice.Controllers;

import com.example.CrudMicroservice.Entities.Admin;
import com.example.CrudMicroservice.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService service;

    @GetMapping("/getall")
    public ResponseEntity<List<Admin>> getAllAdmins(){
        return new ResponseEntity<>(service.getAllAdmins(), HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Admin> getById(@PathVariable("id") int id){
        if(service.getById(id) == null){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(service.addNewAdmin(admin),HttpStatus.OK);
    }

}
