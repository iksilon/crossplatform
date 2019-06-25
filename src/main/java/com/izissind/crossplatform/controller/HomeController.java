package com.izissind.crossplatform.controller;

import com.izissind.crossplatform.dto.LoginDto;
import com.izissind.crossplatform.dto.UserDto;
import com.izissind.crossplatform.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class HomeController {

    private final DataService dataService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> loginController(@RequestBody LoginDto loginDto) {

        if(loginDto == null || loginDto.getUsername().isBlank() || loginDto.getPassword().isBlank()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username and password are required");
        }

        // Fake auth
        if(!loginDto.getPassword().equals("pass")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }

        try {
            UserDto userEntity = dataService.getUser(loginDto);
            return ResponseEntity.ok(userEntity);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Unknown user");
        }
    }
}
