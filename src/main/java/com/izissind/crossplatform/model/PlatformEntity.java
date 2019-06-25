package com.izissind.crossplatform.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "platform", schema = "db_crossplatform", catalog = "")
public class PlatformEntity {
    private int idPlatform;
    private String platformName;
    private Collection<GameEntity> gamesByIdPlatform;

    @Id
    @Column(name = "idPlatform")
    public int getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(int idPlatform) {
        this.idPlatform = idPlatform;
    }

    @Basic
    @Column(name = "platformName")
    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatformEntity that = (PlatformEntity) o;
        return idPlatform == that.idPlatform &&
                Objects.equals(platformName, that.platformName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlatform, platformName);
    }

    @OneToMany(mappedBy = "platformByIdPlatform")
    public Collection<GameEntity> getGamesByIdPlatform() {
        return gamesByIdPlatform;
    }

    public void setGamesByIdPlatform(Collection<GameEntity> gamesByIdPlatform) {
        this.gamesByIdPlatform = gamesByIdPlatform;
    }
}
