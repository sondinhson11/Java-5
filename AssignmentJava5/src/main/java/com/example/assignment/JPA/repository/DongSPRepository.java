package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DongSPRepository extends JpaRepository<DongSP, UUID> {
    DongSP findDongSPById(UUID id);
}
