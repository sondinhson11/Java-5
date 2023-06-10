package com.example.assignmentjava5.SonVDPH23054.repository;

import com.example.assignmentjava5.SonVDPH23054.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    KhachHang findKhachHangById(UUID id);
}
