package com.example.assignmentjava5.SonVDPH23054.repository;

import com.example.assignmentjava5.SonVDPH23054.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    MauSac findMauSacById(UUID id);
}
