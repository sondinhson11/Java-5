package com.example.assignment.JPA.service.impl;

import com.example.assignment.JPA.entity.MauSac;
import com.example.assignment.JPA.repository.MauSacRepository;
import com.example.assignment.JPA.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;
    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public void add(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }

    @Override
    public Page<MauSac> phanTrang(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public MauSac detail(UUID id) {
        return mauSacRepository.findMauSacById(id);
    }

    @Override
    public void update(MauSac mauSac) {
        mauSacRepository.save(mauSac);
    }
}
