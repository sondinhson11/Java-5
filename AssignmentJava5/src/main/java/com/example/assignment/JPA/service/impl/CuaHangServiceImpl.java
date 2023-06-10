package com.example.assignment.JPA.service.impl;

import com.example.assignment.JPA.entity.CuaHang;
import com.example.assignment.JPA.repository.CuaHangRepository;
import com.example.assignment.JPA.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository cuaHangRepository;
    @Override
    public List<CuaHang> getAll() {
        return cuaHangRepository.findAll();
    }

    @Override
    public void addCH(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public Page<CuaHang> phanTrang(Pageable pageable) {
        return cuaHangRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public CuaHang detail(UUID id) {
        return cuaHangRepository.findCuaHangById(id);
    }

    @Override
    public void update(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }
}
