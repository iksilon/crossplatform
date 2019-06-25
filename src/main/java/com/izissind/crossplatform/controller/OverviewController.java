package com.izissind.crossplatform.controller;

import com.izissind.crossplatform.dto.AddGameDto;
import com.izissind.crossplatform.dto.PlatformDto;
import com.izissind.crossplatform.dto.UserGamesDto;
import com.izissind.crossplatform.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/overview")
@RequiredArgsConstructor
public class OverviewController {
    private final DataService dataService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/games", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserGamesDto> gamesController(@RequestBody UserGamesDto userGamesDto) {

        userGamesDto.setGames(dataService.getUserGames(userGamesDto.getUserId()));

        return ResponseEntity.ok(userGamesDto);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "/platforms", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlatformDto>> platformsController() {

        List<PlatformDto> platforms = dataService.getAllPlatforms();

        return ResponseEntity.ok(platforms);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addController(@RequestBody AddGameDto addGameDto) {

        dataService.addGame(addGameDto);

        return ResponseEntity.ok(true);
    }
}
