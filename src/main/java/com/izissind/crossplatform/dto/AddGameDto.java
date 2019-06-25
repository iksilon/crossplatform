package com.izissind.crossplatform.dto;

import lombok.Data;

@Data
public class AddGameDto {
    private int idPlatform;
    private int idUser;
    private String gameName;
}
