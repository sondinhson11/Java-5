package com.example.assignmentjava5.SonVDPH23054.service;

import com.example.assignmentjava5.SonVDPH23054.entity.SanPham;
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
