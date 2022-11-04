package com.mymi.dao;

import com.mymi.model.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<TUser,Integer> {

    Optional<TUser> findByUserName(String userName);
}
