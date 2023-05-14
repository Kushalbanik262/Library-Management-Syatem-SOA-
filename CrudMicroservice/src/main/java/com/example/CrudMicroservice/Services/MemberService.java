package com.example.CrudMicroservice.Services;

import com.example.CrudMicroservice.Entities.Admin;
import com.example.CrudMicroservice.Entities.Member;
import com.example.CrudMicroservice.Entities.MemberDto;
import com.example.CrudMicroservice.Repositories.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepo;

    Logger logger  = LoggerFactory.getLogger(MemberService.class);
    @Autowired
    private AdminService service;
    public List<Member> getAllMembers(){
        return memberRepo.findAll();
    }

    public Member getMemberById(int id){
        Optional<Member> member =  memberRepo.findById(id);
        if(member.isPresent()) {
            return member.get();
        }
        return null;
    }


    public Member saveMember(MemberDto memberDto){
       Member member = memberDto.getMember();
       int adminId = memberDto.getAdminId();
       Admin admin = service.getById(adminId);
       if(admin == null){return null;}

       logger.info("Member Adding:{}",memberDto);

       admin.getUsers().add(member);
       service.updateAdmin(admin);

       memberRepo.save(member);
       return member;
    }

    public Member updateMember(Member member) {
        return memberRepo.save(member);
    }
}
