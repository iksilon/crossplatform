package com.izissind.crossplatform.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "game", schema = "db_crossplatform", catalog = "")
public class GameEntity {
    private int idGame;
    private String gameName;
    private UserEntity userByIdUser;
    private PlatformEntity platformByIdPlatform;

    @Id
    @Column(name = "idGame")
    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    @Basic
    @Column(name = "gameName")
    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEntity that = (GameEntity) o;
        return idGame == that.idGame &&
                Objects.equals(gameName, that.gameName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGame, gameName);
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    public UserEntity getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(UserEntity userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "idPlatform", referencedColumnName = "idPlatform")
    public PlatformEntity getPlatformByIdPlatform() {
        return platformByIdPlatform;
    }

    public void setPlatformByIdPlatform(PlatformEntity platformByIdPlatform) {
        this.platformByIdPlatform = platformByIdPlatform;
    }
}
