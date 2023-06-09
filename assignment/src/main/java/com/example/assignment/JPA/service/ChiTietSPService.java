package com.example.assignment.JPA.service;

import com.example.assignment.JPA.entity.ChiTietsP;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietsP>getAll();

    void add(ChiTietsP chiTietsP);

    Page<ChiTietsP> phanTrang(Pageable pageable);

    void remove(UUID id);

    ChiTietsP detail(UUID id);

    void update(ChiTietsP chiTietsP);
}
