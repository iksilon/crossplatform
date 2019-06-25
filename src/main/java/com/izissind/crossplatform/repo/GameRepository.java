package com.izissind.crossplatform.repo;

import com.izissind.crossplatform.model.GameEntity;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<GameEntity, Integer> {
}
