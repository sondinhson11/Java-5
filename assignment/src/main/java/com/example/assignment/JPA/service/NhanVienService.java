package com.example.assignment.JPA.service;

import com.example.assignment.JPA.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien>getAll();

    void add(NhanVien nhanVien);

    Page<NhanVien> phanTrang(Pageable pageable);

    void remove(UUID id);

    NhanVien detail(UUID id);

    void update(NhanVien nhanVien);
}
