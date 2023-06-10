package com.example.assignmentjava5.SonVDPH23054.repository;

import com.example.assignmentjava5.SonVDPH23054.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    ChucVu findChucVuById(UUID id);
}
