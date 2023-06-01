package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getAll();

    Page<NhanVien> getPage(Pageable a);

    void add(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void remove(UUID id);

    NhanVien findById(UUID fromString);
}
