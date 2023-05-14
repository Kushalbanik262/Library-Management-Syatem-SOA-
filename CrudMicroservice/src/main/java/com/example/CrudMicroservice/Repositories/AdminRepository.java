package com.example.CrudMicroservice.Repositories;

import com.example.CrudMicroservice.Entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
