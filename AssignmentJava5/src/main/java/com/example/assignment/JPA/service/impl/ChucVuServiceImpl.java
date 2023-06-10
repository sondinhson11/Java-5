package com.example.assignment.JPA.service.impl;

import com.example.assignment.JPA.entity.ChucVu;
import com.example.assignment.JPA.repository.ChucVuRepository;
import com.example.assignment.JPA.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;
    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public void addCV(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public Page<ChucVu> phanTrang(Pageable pageable) {
        return chucVuRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public void update(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public ChucVu detail(UUID id) {
        return chucVuRepository.findChucVuById(id);
    }
}
