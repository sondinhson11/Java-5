package com.example.assignment.JPA.service.impl;

import com.example.assignment.JPA.entity.DongSP;
import com.example.assignment.JPA.repository.DongSPRepository;
import com.example.assignment.JPA.service.DongSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSPServiceImpl implements DongSPService {
    @Autowired
    private DongSPRepository dongSPRepository;
    @Override
    public List<DongSP> getAll() {
        return dongSPRepository.findAll();
    }

    @Override
    public void add(DongSP dongSP) {
        dongSPRepository.save(dongSP);
    }

    @Override
    public Page<DongSP> phanTrang(Pageable pageable) {
        return dongSPRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        dongSPRepository.deleteById(id);
    }

    @Override
    public DongSP detail(UUID id) {
        return dongSPRepository.findDongSPById(id);
    }

    @Override
    public void update(DongSP dongSP) {
        dongSPRepository.save(dongSP);
    }
}
