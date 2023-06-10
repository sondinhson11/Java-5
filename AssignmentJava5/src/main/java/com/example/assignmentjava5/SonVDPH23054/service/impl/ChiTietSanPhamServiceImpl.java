package com.example.assignmentjava5.SonVDPH23054.service.impl;

import com.example.assignmentjava5.SonVDPH23054.entity.ChiTietSanPham;
import com.example.assignmentjava5.SonVDPH23054.repository.ChiTietSanPhamRepository;
import com.example.assignmentjava5.SonVDPH23054.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;
    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public void add(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public Page<ChiTietSanPham> phanTrang(Pageable pageable) {
        return chiTietSanPhamRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        chiTietSanPhamRepository.deleteById(id);
    }

    @Override
    public ChiTietSanPham detail(UUID id) {
        return chiTietSanPhamRepository.findChiTietsPById(id);
    }

    @Override
    public void update(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }
}
