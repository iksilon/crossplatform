package com.izissind.crossplatform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameDto {
    private int idGame;
    private String gameName;
    private PlatformDto platform;
}
