package com.example.assignmentjava5.SonVDPH23054.service;

import com.example.assignmentjava5.SonVDPH23054.entity.NhanVien;
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
