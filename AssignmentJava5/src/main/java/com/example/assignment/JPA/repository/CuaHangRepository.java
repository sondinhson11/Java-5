package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    CuaHang findCuaHangById(UUID id);
}
