package com.example.buoi3.service;

import com.example.buoi3.entity.SinhVien;

import java.util.List;

public interface SinhVienService {

    List<SinhVien> getAll();
    List<SinhVien> getByTen(String ten);
}
