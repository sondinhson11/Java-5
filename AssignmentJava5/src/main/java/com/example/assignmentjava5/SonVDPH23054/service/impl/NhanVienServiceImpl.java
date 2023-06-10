package com.example.assignmentjava5.SonVDPH23054.service.impl;

import com.example.assignmentjava5.SonVDPH23054.entity.NhanVien;
import com.example.assignmentjava5.SonVDPH23054.repository.NhanVienRepository;
import com.example.assignmentjava5.SonVDPH23054.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Override
    public List<NhanVien> getAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public Page<NhanVien> phanTrang(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public void remove(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien detail(UUID id) {
        return nhanVienRepository.findNhanVienById(id);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }
}
