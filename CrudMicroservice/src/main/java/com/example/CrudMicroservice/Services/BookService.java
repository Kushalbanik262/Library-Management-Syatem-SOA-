package com.example.CrudMicroservice.Services;

import com.example.CrudMicroservice.Entities.Admin;
import com.example.CrudMicroservice.Entities.Book;
import com.example.CrudMicroservice.Entities.BookDto;
import com.example.CrudMicroservice.Repositories.AdminRepository;
import com.example.CrudMicroservice.Repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private AdminService adminService;


    public List<Book> getAllBooks(){
        return bookRepo.findAll();
    }

    public Book getBookById(int id){
        Optional<Book> book = bookRepo.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }

    public Book saveBook(BookDto bookDto){
        logger.info("Saving Book:{}",bookDto);

       Book book = bookDto.getBook();
       int adminId = bookDto.getAdminId();
       Admin admin = adminService.getById(adminId);

       admin.getBooks().add(book);
       adminService.updateAdmin(admin);
       bookRepo.save(book);
       return book;
    }

    public Book updateBook(Book book){
        return bookRepo.save(book);
    }

}
