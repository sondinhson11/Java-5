package com.example.assignmentjava5.SonVDPH23054.repository;

import com.example.assignmentjava5.SonVDPH23054.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DongSPRepository extends JpaRepository<DongSP, UUID> {
    DongSP findDongSPById(UUID id);
}
