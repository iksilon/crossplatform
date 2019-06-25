package com.izissind.crossplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserGamesDto {
    private int userId;
    private List<GameDto> games;
}
