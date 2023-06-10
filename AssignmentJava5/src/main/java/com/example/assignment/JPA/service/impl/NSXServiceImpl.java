package com.example.assignment.JPA.service.impl;

import com.example.assignment.JPA.entity.NSX;
import com.example.assignment.JPA.repository.NSXRepository;
import com.example.assignment.JPA.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    private NSXRepository nsxRepository;
    @Override
    public List<NSX> getAll() {
        return nsxRepository.findAll();
    }

    @Override
    public void add(NSX nsx) {
        nsxRepository.save(nsx);
    }

    @Override
    public Page<NSX> phanTrang(Pageable pageable) {
        return nsxRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        nsxRepository.deleteById(id);
    }

    @Override
    public NSX detail(UUID id) {
        return nsxRepository.findNSXById(id);
    }

    @Override
    public void update(NSX nsx) {
        nsxRepository.save(nsx);
    }
}
