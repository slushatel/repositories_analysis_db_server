package com.example.jpa.repository;

import com.example.jpa.model.CodeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CodeRepositoryRepository extends JpaRepository<CodeRepository, Long> {
    Optional<CodeRepository> findByName(String name);
}
