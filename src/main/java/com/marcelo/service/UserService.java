package com.marcelo.service;


import com.marcelo.dto.UserDTO;
import com.marcelo.entity.Usuario;
import com.marcelo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> list(){
        ModelMapper modelMapper = new ModelMapper();
        return repository.findAll(Sort.by("nome").ascending())
                .stream()
                .map((user) -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public  List<UserDTO> create(Usuario user){
        repository.save(user);
        return list();
    }

    public  List<UserDTO> delete(Long id){
        repository.deleteById(id);
        return list();
    }

    public  List<UserDTO> update(Usuario user){
        repository.save(user);
        return list();
    }

}
