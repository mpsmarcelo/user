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
@CrossOrigin(origins = "http://localhost:4200")
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
    ResponseEntity<UserDTO> create(@RequestBody UserRequest request) {
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = userService.create(modelMapper.map(request,Usuario.class));
        return  ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<List<UserDTO>> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.delete(id));
    }

    @PutMapping
    ResponseEntity<UserDTO> update(@RequestBody UserRequest request){
        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = userService.update(modelMapper.map(request,Usuario.class));
        return  ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @GetMapping("{id}")
    ResponseEntity<UserDTO> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }
}
