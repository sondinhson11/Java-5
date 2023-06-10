package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.CuaHang;
import com.example.assignment.JPA.service.CuaHangService;
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
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;
    @GetMapping("/cua-hang/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        model.addAttribute("cuaHang",new CuaHang());
        Pageable pageable = PageRequest.of(integer,3);
        Page<CuaHang> cuaHangPage = cuaHangService.phanTrang(pageable);
        model.addAttribute("listCH",cuaHangPage);
        return "/cuahang/hien-thi-cua-hang";
    }
    @PostMapping("/cua-hang/add")
    public String add(@Valid @ModelAttribute("cuaHang")CuaHang cuaHang, BindingResult result, Model model,@RequestParam(defaultValue = "0",name = "page")Integer integer){
        if (result.hasErrors()){
            Pageable pageable = PageRequest.of(integer,3);
            Page<CuaHang> cuaHangPage = cuaHangService.phanTrang(pageable);
            model.addAttribute("listCH",cuaHangPage);
            return "/cuahang/hien-thi-cua-hang";
        }
        model.addAttribute("cuaHang",cuaHang);
        cuaHangService.addCH(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
    @GetMapping("/cua-hang/remove/{id}")
    public String remove(@PathVariable("id")UUID id){
        cuaHangService.remove(id);
        return "redirect:/cua-hang/hien-thi";
    }
    @GetMapping("/cua-hang/detail/{id}")
    public String detail(@PathVariable("id")UUID id,Model model){
        model.addAttribute("cuaHang",cuaHangService.detail(id));
        return "/cuahang/update-cua-hang";
    }
    @PostMapping("/cua-hang/update/{id}")
    public String update(@Valid @ModelAttribute("cuaHang")CuaHang cuaHang,Model model){
        model.addAttribute("cuaHang",cuaHang);
        cuaHangService.update(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }
}
