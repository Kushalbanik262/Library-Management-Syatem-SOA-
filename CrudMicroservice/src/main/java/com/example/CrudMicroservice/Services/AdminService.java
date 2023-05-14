package com.example.CrudMicroservice.Services;

import com.example.CrudMicroservice.Entities.Admin;
import com.example.CrudMicroservice.Repositories.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
    Logger logger = LoggerFactory.getLogger(AdminService.class);

    public List<Admin> getAllAdmins(){
        logger.info("Geting All the admins");
        return repository.findAll();
    }

    public Admin addNewAdmin(Admin admin){
        logger.info("Adding New Admin:{}",admin);
        return repository.save(admin);
    }

    public Admin updateAdmin(Admin admin){
        logger.info("Updating Admin: {}",admin);
        return repository.save(admin);
    }

    public Admin getById(int id){
        logger.info("Getting Admin By Id:{}",id);
        Optional<Admin> admin = repository.findById(id);
        if(admin.isPresent()){
            return admin.get();
        }
        return null;
    }

}
