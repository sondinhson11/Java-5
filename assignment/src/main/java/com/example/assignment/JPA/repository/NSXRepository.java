package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NSXRepository extends JpaRepository<NSX, UUID> {
    NSX findNSXById(UUID id);
}
