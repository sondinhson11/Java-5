package com.example.assignment.JPA.repository;

import com.example.assignment.JPA.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    MauSac findMauSacById(UUID id);
}
