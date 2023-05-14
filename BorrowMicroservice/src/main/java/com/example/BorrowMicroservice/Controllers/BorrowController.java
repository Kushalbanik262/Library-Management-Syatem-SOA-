package com.example.BorrowMicroservice.Controllers;

import com.example.BorrowMicroservice.Entities.Borrow;
import com.example.BorrowMicroservice.Entities.BorrowDto;
import com.example.BorrowMicroservice.Services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService service;

    @GetMapping("/getall")
    public ResponseEntity<List<Borrow>> getAllBorrows(){
        return new ResponseEntity<>(service.getAllBorrows(), HttpStatus.FOUND);
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Borrow> getBorrowById(@PathVariable("id") int id){
        if(service.getById(id) == null){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service.getById(id),HttpStatus.FOUND);
    }

    @PostMapping("/save")
    public ResponseEntity<BorrowDto> dispatchBorrow(@RequestBody Borrow borrow){
        return new ResponseEntity<>(service.dispatchBorrow(borrow),HttpStatus.CREATED);
    }
}
