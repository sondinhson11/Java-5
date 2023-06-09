package com.example.assignment.JPA.service;

import com.example.assignment.JPA.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {
    List<MauSac> getAll();

    void add(MauSac mauSac);

    Page<MauSac> phanTrang(Pageable pageable);

    void remove(UUID id);

    MauSac detail(UUID id);

    void update(MauSac mauSac);
}
