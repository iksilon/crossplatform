package com.izissind.crossplatform.controller;

import com.izissind.crossplatform.dto.GreetingsDto;
import com.izissind.crossplatform.model.UserEntity;
import com.izissind.crossplatform.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class GreetingsController {

    private final UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/greetings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GreetingsDto> homeController() {

        UserEntity userEntity = userRepository.findByUsernameLike("Mario");

        return ResponseEntity.ok(new GreetingsDto(userEntity.getUsername()));
    }
}
