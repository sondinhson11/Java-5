package com.example.assignment.JPA.service;

import com.example.assignment.JPA.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {
    List<ChiTietSanPham>getAll();

    void add(ChiTietSanPham chiTietSanPham);

    Page<ChiTietSanPham> phanTrang(Pageable pageable);

    void remove(UUID id);

    ChiTietSanPham detail(UUID id);

    void update(ChiTietSanPham chiTietSanPham);
}
