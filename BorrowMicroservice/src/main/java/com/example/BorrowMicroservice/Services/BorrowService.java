package com.example.BorrowMicroservice.Services;

import com.example.BorrowMicroservice.Controllers.BorrowController;
import com.example.BorrowMicroservice.Entities.Book;
import com.example.BorrowMicroservice.Entities.Borrow;
import com.example.BorrowMicroservice.Entities.BorrowDto;
import com.example.BorrowMicroservice.Entities.Member;
import com.example.BorrowMicroservice.Feign.CrudFeign;
import com.example.BorrowMicroservice.Repositories.BorrowRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BorrowService {
    @Autowired
    private CrudFeign feign;

    @Autowired
    private BorrowRepository repository;

    Logger logger = LoggerFactory.getLogger(BorrowService.class);

    public List<Borrow> getAllBorrows(){
        return repository.findAll();
    }

    public Borrow getById(int id){
        Optional<Borrow> borrow =  repository.findById(id);
        return borrow.orElse(null);
    }

    public BorrowDto dispatchBorrow(Borrow borrow){
        List<Integer> bookIds = borrow.getBookIds();
        int memberId = borrow.getMemberId();
        logger.info("Resolving The Borrow:{}",borrow);

        List<Book>  books = new ArrayList<>();

        for(int br:bookIds){
            Book cuBook = feign.getBookById(br);
            if(cuBook!= null && !cuBook.isEngaged()){
                logger.debug("Getting the books:{}",cuBook);
                books.add(cuBook);
            }
        }

        borrow.setBookIds(
                books.stream().map(Book::getId).collect(Collectors.toList())
        );


       borrow.setDateTime(LocalDateTime.now().toString());

        repository.save(borrow);


        Member member = feign.getMemberById(memberId);
        BorrowDto dto = new BorrowDto(borrow,books,member);
        for(Book bk:books){
            logger.info("Updating Books:{}",bk);
            bk.setEngaged(true);
            feign.updateBook(bk);
        }

        logger.info("The BorrowDto is:{}",dto);

        return dto;
    }

//    public BorrowDto resolveBorrow(Borrow borrow){
//
//    }
}
