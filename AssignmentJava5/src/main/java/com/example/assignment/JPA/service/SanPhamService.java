package com.example.assignment.JPA.service;

import com.example.assignment.JPA.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> getAll();

    void add(SanPham sanPham);

    Page<SanPham> phanTrang(Pageable pageable);

    void remove(UUID id);

    SanPham detail(UUID id);

    void update(SanPham sanPham);
}
