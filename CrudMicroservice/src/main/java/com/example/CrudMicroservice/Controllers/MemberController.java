package com.example.CrudMicroservice.Controllers;

import com.example.CrudMicroservice.Entities.Member;
import com.example.CrudMicroservice.Entities.MemberDto;
import com.example.CrudMicroservice.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService service;

    @GetMapping("/getall")
    public ResponseEntity<List<Member>> getAllMembers(){
        return new ResponseEntity<>(service.getAllMembers(), HttpStatus.FOUND);
    }


    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Member> getmemberById(@PathVariable("id") int id){
        if(service.getMemberById(id) == null){
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(service.getMemberById(id),HttpStatus.FOUND);
    }


    @PostMapping("/save")
    public ResponseEntity<Member> saveMember(@RequestParam MemberDto memberDto){
        return new ResponseEntity<>(service.saveMember(memberDto),HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Member> updateMember(@RequestParam Member member){
        return new ResponseEntity<>(service.updateMember(member),HttpStatus.FOUND);
    }

}
