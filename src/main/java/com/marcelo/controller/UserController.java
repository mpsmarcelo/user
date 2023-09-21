package com.marcelo.controller;
import com.marcelo.dto.UserDTO;
import com.marcelo.entity.Usuario;
import com.marcelo.request.UserRequest;
import com.marcelo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    UserService userService;

    public UserController(UserService service) {
        this.userService =  service;
    }

    @GetMapping
    ResponseEntity<List<UserDTO>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.list());
    }

    @PostMapping
    ResponseEntity<List<UserDTO>> create(@RequestBody UserRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        List<UserDTO> userDTOS = userService.create(modelMapper.map(request,Usuario.class));
        return  ResponseEntity.status(HttpStatus.CREATED).body(userDTOS);
    }

    @DeleteMapping("{id}")
    ResponseEntity<List<UserDTO>> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.delete(id));
    }

    @PutMapping
    ResponseEntity<List<UserDTO>> update(@RequestBody UserRequest request){
        ModelMapper modelMapper = new ModelMapper();
        List<UserDTO> userDTOS = userService.update(modelMapper.map(request,Usuario.class));
        return  ResponseEntity.status(HttpStatus.CREATED).body(userDTOS);
    }
}
