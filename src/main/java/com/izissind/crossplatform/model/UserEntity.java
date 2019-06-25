package com.izissind.crossplatform.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "db_crossplatform", catalog = "")
public class UserEntity {
    private int idUser;
    private String username;
    private Collection<GameEntity> gamesByIdUser;

    @Id
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, username);
    }

    @OneToMany(mappedBy = "userByIdUser")
    public Collection<GameEntity> getGamesByIdUser() {
        return gamesByIdUser;
    }

    public void setGamesByIdUser(Collection<GameEntity> gamesByIdUser) {
        this.gamesByIdUser = gamesByIdUser;
    }
}
