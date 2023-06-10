package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {
    ChiTietSanPham findChiTietsPById(UUID id);
}
