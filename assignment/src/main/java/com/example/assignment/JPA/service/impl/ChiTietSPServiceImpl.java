package com.example.assignment.JPA.service.impl;

import com.example.assignment.JPA.entity.ChiTietsP;
import com.example.assignment.JPA.repository.ChiTietSPRepository;
import com.example.assignment.JPA.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    private ChiTietSPRepository chiTietSPRepository;
    @Override
    public List<ChiTietsP> getAll() {
        return chiTietSPRepository.findAll();
    }

    @Override
    public void add(ChiTietsP chiTietsP) {
        chiTietSPRepository.save(chiTietsP);
    }

    @Override
    public Page<ChiTietsP> phanTrang(Pageable pageable) {
        return chiTietSPRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        chiTietSPRepository.deleteById(id);
    }

    @Override
    public ChiTietsP detail(UUID id) {
        return chiTietSPRepository.findChiTietsPById(id);
    }

    @Override
    public void update(ChiTietsP chiTietsP) {
        chiTietSPRepository.save(chiTietsP);
    }
}
