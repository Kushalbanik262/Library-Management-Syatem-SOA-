package com.example.CrudMicroservice.Controllers;

import com.example.CrudMicroservice.Entities.Book;
import com.example.CrudMicroservice.Entities.BookDto;
import com.example.CrudMicroservice.Services.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/getall")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(service.getAllBooks(), HttpStatus.FOUND);
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        if(service.getBookById(id) == null){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service.getBookById(id),HttpStatus.FOUND);
    }


    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody BookDto bookDto){
        return new ResponseEntity<>(service.saveBook(bookDto),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(Book book){
        return new ResponseEntity<>(service.updateBook(book),HttpStatus.FOUND);
    }

}
