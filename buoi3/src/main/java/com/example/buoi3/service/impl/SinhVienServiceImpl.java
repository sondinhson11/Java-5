package com.example.buoi3.service.impl;


import com.example.buoi3.entity.SinhVien;
import com.example.buoi3.service.SinhVienService;

import java.util.ArrayList;
import java.util.List;

public class SinhVienServiceImpl implements SinhVienService {

    private List<SinhVien> sinhViens = new ArrayList<>();

    public SinhVienServiceImpl() {
        sinhViens.add(new SinhVien("PH23054", "Văn", 20, "Sầm Sơn", true));
        sinhViens.add(new SinhVien("PH23054", "Văn Đình Sơn", 20, "Sầm Sơn", true));
        sinhViens.add(new SinhVien("PH23054", "Văn Đình Sơn", 20, "Sầm Sơn", true));
        sinhViens.add(new SinhVien("PH23054", "Văn Đình Sơn", 20, "Sầm Sơn", true));
        sinhViens.add(new SinhVien("PH23054", "Văn Đình Sơn", 20, "Sầm Sơn", true));
    }

    @Override
    public List<SinhVien> getAll() {
        return sinhViens;
    }

    @Override
    public List<SinhVien> getByTen(String ten) {
        List<SinhVien>list = new ArrayList<>();

        for (SinhVien sv:sinhViens) {
            if(sv.getTen().equalsIgnoreCase(ten)){
                list.add(sv);
                return list;
            }
        }
        return null;
    }

}
