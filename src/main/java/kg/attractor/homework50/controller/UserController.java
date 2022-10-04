package kg.attractor.homework50.controller;


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

    @GetMapping("/connect")
    public ResponseEntity<String> getConnection(){
        return new ResponseEntity<>(dbService.openConnection(), HttpStatus.OK);

    }

    @GetMapping("/create")
    public ResponseEntity<String> createTable(){
        return new ResponseEntity<>(service.shouldCreateTable(), HttpStatus.OK);
    }

    @GetMapping("/select")
    public  ResponseEntity<String> select(){
        return  new ResponseEntity<>(service.shouldSelectData(), HttpStatus.OK);

    }
    @GetMapping("/users")
    public  ResponseEntity<List<User>> users(){
        return  new ResponseEntity<>(service.getlUsers(), HttpStatus.OK);

    }

    @GetMapping("/go/{name}")
    public  ResponseEntity<User> go (@PathVariable String name) {             //поиск по имени
        return new ResponseEntity<>(service.getUsersByName(name), HttpStatus.OK);
    }


    @GetMapping("/get/{email}")
    public  ResponseEntity <User> getUserByEmail( @PathVariable String email) {
        return new ResponseEntity<>(service.getUserByEmail(email), HttpStatus.OK);
    }






}