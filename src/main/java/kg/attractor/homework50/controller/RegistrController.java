package kg.attractor.homework50.controller;


import kg.attractor.homework50.dao.PostDao;
import kg.attractor.homework50.dto.UserDto;
import kg.attractor.homework50.service.Lesson51Service;
import kg.attractor.homework50.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/register")
//@RequiredArgsConstructor
//public class RegistrController {
//
//    private final Lesson51Service service;
//
//    private final PostDao postDao;
//
//    @PostMapping
//    /* Регистрация отправляется в таком виде
//        {
//            "name": "Kim",
//            "email": "kkk@mail.ru",
//            "password": "5236"
//        }
//     */
//    public ResponseEntity<String> createNewUser(@RequestBody UserDto userDto) {
//        return new ResponseEntity<>(service.createNewUser(userDto), HttpStatus.OK);
//    }
//}
