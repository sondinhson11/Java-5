package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    KhachHang findKhachHangById(UUID id);
}
