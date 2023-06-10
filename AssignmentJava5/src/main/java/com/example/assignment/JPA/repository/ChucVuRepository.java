package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    ChucVu findChucVuById(UUID id);
}
