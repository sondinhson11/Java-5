package com.example.demo.btvnbuoi3.controller;

import com.example.demo.btvnbuoi3.service.GiangVienService;
import com.example.demo.btvnbuoi3.service.impl.GiangVienServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GiangVienController {
    private GiangVienService giangVienService = new GiangVienServiceImpl();

    @GetMapping("/giang-vien/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("dsgv", giangVienService.getAll());
        return "giang-vien";
    }

    @GetMapping("/giang-vien/giang-vien-nu")
    public String hienThiGiangVienNu(Model model) {
        model.addAttribute("dsgv", giangVienService.getByGioiTinh());
        return "giang-vien";
    }

    @PostMapping("/giang-vien/search")
    public String timKiemTheoTen(Model model, @RequestParam("ten") String name) {
        model.addAttribute("dsgv", giangVienService.getByName(name));
        return "giang-vien";
    }
}
