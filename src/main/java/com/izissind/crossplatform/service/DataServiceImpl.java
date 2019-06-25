package com.izissind.crossplatform.service;

import com.izissind.crossplatform.dto.*;
import com.izissind.crossplatform.model.GameEntity;
import com.izissind.crossplatform.model.PlatformEntity;
import com.izissind.crossplatform.model.UserEntity;
import com.izissind.crossplatform.repo.GameRepository;
import com.izissind.crossplatform.repo.PlatformRepository;
import com.izissind.crossplatform.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {
    private final UserRepository userRepository;
    private final PlatformRepository platformRepository;
    private final GameRepository gameRepository;

    @Override
    public UserDto getUser(LoginDto loginDto) {
        UserEntity userEntity = userRepository.findByUsername(loginDto.getUsername());

        return new UserDto(userEntity.getIdUser(), userEntity.getUsername());
    }

    @Override
    public List<GameDto> getUserGames(int id) {
        UserEntity userEntity = userRepository.findByIdUser(id);

        return userEntity.getGamesByIdUser()
                .stream()
                .map(gameEntity -> {
                    PlatformDto platformDto = new PlatformDto(gameEntity.getPlatformByIdPlatform().getIdPlatform(), gameEntity.getPlatformByIdPlatform().getPlatformName());
                    return new GameDto(gameEntity.getIdGame(), gameEntity.getGameName(), platformDto);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<PlatformDto> getAllPlatforms() {
        List<PlatformEntity> platformEntities = platformRepository.findAll();

        return platformEntities.stream().map(platformEntity -> new PlatformDto(platformEntity.getIdPlatform(), platformEntity.getPlatformName())).collect(Collectors.toList());
    }

    @Override
    public void addGame(AddGameDto addGameDto) {
        GameEntity gameEntity = new GameEntity();

        gameEntity.setGameName(addGameDto.getGameName());
        gameEntity.setUserByIdUser(userRepository.findByIdUser(addGameDto.getIdUser()));
        gameEntity.setPlatformByIdPlatform(platformRepository.findByIdPlatform(addGameDto.getIdPlatform()));

        gameRepository.save(gameEntity);
    }
}
