package com.example.ty.repository;

import com.example.ty.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaSpecificationExecutor<UserEntity>,JpaRepository<UserEntity,Long> {

    @Query(value = "from UserEntity a where a.id=:id")
    Optional<UserEntity> findUserEntitiesById(@Param("id") Long id);

    @Query(value = "from UserEntity a where a.age=:age")
    List<UserEntity> findAllByAge(@Param("age") Integer age);
}

