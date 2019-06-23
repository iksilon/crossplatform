package com.izissind.crossplatform.repo;

import com.izissind.crossplatform.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    public UserEntity findByUsernameLike(String username);

}
