package com.example.controller;

import com.example.dto.ResponseDTO;
import com.example.entity.User;
import com.example.dto.UserDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<ResponseDTO> getUsers(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "surame", required = false) String surname,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        List<User> users = userService.getAll(name, surname, age);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            userDTOS.add(new UserDTO(u));
        }
        return ResponseEntity.ok(ResponseDTO.of(userDTOS));
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id")int id){
        User user=userService.getById(id);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user)));
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<ResponseDTO> deleteUser(@PathVariable("id")int id){
        User user=userService.getById(id);
        userService.removeUser(id);
        return ResponseEntity.ok(ResponseDTO.of(new UserDTO(user),"Succesfuly deleted"));
    }
    @PostMapping("/users")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody UserDTO userDtO){
        User user = new User();
        user.setName(userDtO.getName());
        user.setSurname(userDtO.getSurname());
        user.setPassword(userDtO.getPassword());
        userService.addUser(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        return ResponseEntity.ok(ResponseDTO.of(userDTO, "Succesfuly added"));
    }
}
