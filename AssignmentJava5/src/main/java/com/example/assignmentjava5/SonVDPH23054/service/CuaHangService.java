package com.example.assignmentjava5.SonVDPH23054.service;

import com.example.assignmentjava5.SonVDPH23054.entity.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();

    void addCH(CuaHang cuaHang);

    Page<CuaHang> phanTrang(Pageable pageable);

    void remove(UUID id);

    CuaHang detail(UUID id);

    void update(CuaHang cuaHang);
}
