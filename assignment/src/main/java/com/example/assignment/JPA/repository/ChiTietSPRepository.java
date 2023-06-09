package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.ChiTietsP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietsP, UUID> {
    ChiTietsP findChiTietsPById(UUID id);
}
