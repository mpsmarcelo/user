package com.marcelo.service;


import com.marcelo.entity.User;
import com.marcelo.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


    List<User> list(){
        return repository.findAll(Sort.by("nome").ascending());
    }

    List<User> create(User user){
        repository.save(user);
        return list();
    }

    List<User> delete(Long id){
        repository.deleteById(id);
        return list();
    }

    List<User> update(User user){
        repository.save(user);
        return list();
    }

}
