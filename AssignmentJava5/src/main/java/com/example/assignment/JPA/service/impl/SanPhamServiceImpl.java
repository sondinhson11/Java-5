package com.example.assignment.JPA.service.impl;

import com.example.assignment.JPA.entity.SanPham;
import com.example.assignment.JPA.repository.SanPhamRepository;
import com.example.assignment.JPA.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;
    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public void add(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public Page<SanPham> phanTrang(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPham detail(UUID id) {
        return sanPhamRepository.findSanPhamById(id);
    }

    @Override
    public void update(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }
}
