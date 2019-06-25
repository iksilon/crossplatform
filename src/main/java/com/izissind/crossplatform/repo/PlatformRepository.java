package com.izissind.crossplatform.repo;

import com.izissind.crossplatform.model.PlatformEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlatformRepository extends CrudRepository<PlatformEntity, Integer> {
    PlatformEntity findByIdPlatform(int id);

    List<PlatformEntity> findAll();
}
