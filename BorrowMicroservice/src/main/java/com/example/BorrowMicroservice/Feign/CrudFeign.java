package com.example.BorrowMicroservice.Feign;

import com.example.BorrowMicroservice.Entities.Book;
import com.example.BorrowMicroservice.Entities.Member;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="CRUDMS")
public interface CrudFeign {
    @GetMapping("/book/getall")
    public List<Book> getAllBooks();

    @GetMapping("/book/getbyid/{id}")
    public Book getBookById(@PathVariable("id") int id);

    @PutMapping("/book/update")
    public Book updateBook(@RequestBody Book book);

    @GetMapping("/member/getbyid/{id}")
    public Member getMemberById(@PathVariable("id") int id);


}
