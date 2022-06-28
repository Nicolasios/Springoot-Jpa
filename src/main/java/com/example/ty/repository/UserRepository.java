package com.example.ty.repository;

import com.example.ty.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaSpecificationExecutor<UserEntity>,JpaRepository<UserEntity,Long> {
}

