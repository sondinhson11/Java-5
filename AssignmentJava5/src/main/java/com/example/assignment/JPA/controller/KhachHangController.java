package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.KhachHang;
import com.example.assignment.JPA.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @GetMapping("/khach-hang/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        model.addAttribute("khachHang",new KhachHang());
        Pageable pageable = PageRequest.of(integer,3);
        Page<KhachHang> khachHangPage = khachHangService.phanTrang(pageable);
        model.addAttribute("listKH",khachHangPage);
        return "/khachhang/hien-thi-khach-hang";
    }
    @PostMapping("/khach-hang/add")
    public String add(@Valid @ModelAttribute("khachHang")KhachHang khachHang, BindingResult result, Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        if (result.hasErrors()){
            Pageable pageable = PageRequest.of(integer,3);
            Page<KhachHang> khachHangPage = khachHangService.phanTrang(pageable);
            model.addAttribute("listKH",khachHangPage);
            return "/khachhang/hien-thi-khach-hang";
        }
        model.addAttribute("khachHang",khachHang);
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("/khach-hang/remove/{id}")
    public String remove(@PathVariable("id")UUID id){
        khachHangService.delete(id);
        return "redirect:/khach-hang/hien-thi";
    }
    @GetMapping("/khach-hang/detail/{id}")
    public String detail(@PathVariable("id")UUID id,Model model){
        model.addAttribute("khachHang",khachHangService.detail(id));
        return "/khachhang/update-khach-hang";
    }
    @PostMapping("/khach-hang/update/{id}")
    public String update(@Valid @ModelAttribute("khachHang")KhachHang khachHang,Model model){
        model.addAttribute("khachHang",khachHang);
        khachHangService.update(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
}
