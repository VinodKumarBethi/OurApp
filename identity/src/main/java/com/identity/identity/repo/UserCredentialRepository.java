package com.identity.identity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.identity.identity.model.UserCredential;

import java.util.Optional;

public interface UserCredentialRepository  extends JpaRepository<UserCredential,String> {
    Optional<UserCredential> findByName(String username);
}
