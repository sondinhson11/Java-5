package com.example.assignmentjava5.SonVDPH23054.repository;

import com.example.assignmentjava5.SonVDPH23054.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    CuaHang findCuaHangById(UUID id);
}
