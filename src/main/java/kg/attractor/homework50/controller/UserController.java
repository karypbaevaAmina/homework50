package kg.attractor.homework50.controller;


import kg.attractor.homework50.dto.UserDto;
import kg.attractor.homework50.models.User;
import kg.attractor.homework50.service.DBService;
import kg.attractor.homework50.service.Lesson51Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/database")
@RequiredArgsConstructor
public class UserController {
    private final DBService dbService;
    private final Lesson51Service service;


    @PostMapping
    /* Регистрация отправляется в таком виде
        {
            "name": "Kim",
            "email": "kkk@mail.ru",
            "password": "5236"
        }
    */
    public ResponseEntity<String> createNewUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(service.createNewUser(userDto), HttpStatus.OK);
    }


    @GetMapping
    public  ResponseEntity<User> user ( @RequestPart String name,  @RequestPart String password) {             //поиск по имени
        return new ResponseEntity<>(service.getUsersByName(name, password), HttpStatus.OK);
    }

//    @GetMapping("/connect")
//    public ResponseEntity<String> getConnection(){
//        return new ResponseEntity<>(dbService.openConnection(), HttpStatus.OK);
//
//    }
//
//    @GetMapping("/create")
//    public ResponseEntity<String> createTable(){
//        return new ResponseEntity<>(service.shouldCreateTable(), HttpStatus.OK);
//    }
//
//    @GetMapping("/select")
//    public  ResponseEntity<String> select(){
//        return  new ResponseEntity<>(service.shouldSelectData(), HttpStatus.OK);
//
//    }
//    @GetMapping("/users")
//    public  ResponseEntity<List<User>> users(){
//        return  new ResponseEntity<>(service.getlUsers(), HttpStatus.OK);
//
//    }
//
//
//
//    @GetMapping("/get/{email}")
//    public  ResponseEntity <User> getUserByEmail( @PathVariable String email) {
//        return new ResponseEntity<>(service.getUserByEmail(email), HttpStatus.OK);
//    }






}
