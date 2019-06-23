package com.izissind.crossplatform.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "platform", schema = "db_crossplatform", catalog = "")
public class PlatformEntity {
    private int idPlatform;
    private String platformName;

    @Id
    @Column(name = "idPlatform", nullable = false)
    public int getIdPlatform() {
        return idPlatform;
    }

    public void setIdPlatform(int idPlatform) {
        this.idPlatform = idPlatform;
    }

    @Basic
    @Column(name = "platformName", nullable = false, length = 255)
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
}
