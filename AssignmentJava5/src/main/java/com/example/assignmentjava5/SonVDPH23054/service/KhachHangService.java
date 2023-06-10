package com.example.assignmentjava5.SonVDPH23054.service;

import com.example.assignmentjava5.SonVDPH23054.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {
    List<KhachHang>getAll();

    void add(KhachHang khachHang);

    Page<KhachHang> phanTrang(Pageable pageable);

    void delete(UUID id);

    KhachHang detail(UUID id);

    void update(KhachHang khachHang);
}
