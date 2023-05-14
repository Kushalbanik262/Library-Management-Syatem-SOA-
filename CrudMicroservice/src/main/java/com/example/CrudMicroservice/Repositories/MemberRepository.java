package com.example.CrudMicroservice.Repositories;

import com.example.CrudMicroservice.Entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}
