package com.example.assignment.JPA.service;

import com.example.assignment.JPA.entity.CuaHang;
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
