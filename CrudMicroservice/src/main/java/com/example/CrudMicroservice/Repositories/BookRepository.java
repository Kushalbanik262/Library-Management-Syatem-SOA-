package com.example.CrudMicroservice.Repositories;

import com.example.CrudMicroservice.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
