package com.izissind.crossplatform.service;

import com.izissind.crossplatform.dto.*;

import java.util.List;

public interface DataService {
    UserDto getUser(LoginDto loginDto);

    List<GameDto> getUserGames(int id);

    List<PlatformDto> getAllPlatforms();

    void addGame(AddGameDto addGameDto);
}
