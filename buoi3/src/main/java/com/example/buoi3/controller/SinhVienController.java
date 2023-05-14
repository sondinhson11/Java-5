package com.example.buoi3.controller;

import com.example.buoi3.entity.SinhVien;
import com.example.buoi3.service.SinhVienService;
import com.example.buoi3.service.impl.SinhVienServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SinhVienController {
    SinhVienService sinhVienService = new SinhVienServiceImpl();

    private List<SinhVien> sinhVienList = new ArrayList<>();

    @GetMapping("/sinh-vien/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("dssv", sinhVienService.getAll());
        return "sinhviens";
    }
    @PostMapping("/sinh-vien/hien-thi/tim-kiem")
    public String hienThiTimKiem(Model model,@RequestParam("ten")String name){
        model.addAttribute("dssv", sinhVienService.getByTen(name));
        return "sinhviens";
    }
}
