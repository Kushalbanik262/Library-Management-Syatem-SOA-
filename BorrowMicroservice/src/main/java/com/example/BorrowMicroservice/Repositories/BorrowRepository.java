package com.example.BorrowMicroservice.Repositories;

import com.example.BorrowMicroservice.Entities.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow,Integer> {
}
