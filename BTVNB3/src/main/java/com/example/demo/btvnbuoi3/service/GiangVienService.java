package com.example.demo.btvnbuoi3.service;

import com.example.demo.btvnbuoi3.entity.GiangVien;

import java.util.List;

public interface GiangVienService {
    List<GiangVien>getAll();
    List<GiangVien>getByName(String name);
    List<GiangVien>getByGioiTinh();
}
