package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    SanPham findSanPhamById(UUID id);
}
