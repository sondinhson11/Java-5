package com.example.assignmentjava5.SonVDPH23054.service;

import com.example.assignmentjava5.SonVDPH23054.entity.ChiTietSanPham;
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
