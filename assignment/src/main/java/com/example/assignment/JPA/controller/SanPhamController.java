package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.SanPham;
import com.example.assignment.JPA.service.SanPhamService;
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
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;
    @GetMapping("/san-pham/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        model.addAttribute("sanPham",new SanPham());
        Pageable pageable = PageRequest.of(integer,3);
        Page<SanPham> sanPhamPage = sanPhamService.phanTrang(pageable);
        model.addAttribute("listSP",sanPhamPage);
        return "sanphams";
    }
    @PostMapping("/san-pham/add")
    public String add(@Valid @ModelAttribute("sanPham")SanPham sanPham, BindingResult result, Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        if(result.hasErrors()){
            Pageable pageable = PageRequest.of(integer,3);
            Page<SanPham> sanPhamPage = sanPhamService.phanTrang(pageable);
            model.addAttribute("listSP",sanPhamPage);
            return "sanphams";
        }
        model.addAttribute("sanPham",sanPham);
        sanPhamService.add(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("/san-pham/remove/{id}")
    public String remove(@PathVariable("id")UUID id){
        sanPhamService.remove(id);
        return "redirect:/san-pham/hien-thi";
    }
    @GetMapping("/san-pham/detail/{id}")
    public String detail(@PathVariable("id")UUID id,Model model){
        model.addAttribute("sanPham",sanPhamService.detail(id));
        return "viewupSP";
    }
    @PostMapping("/san-pham/update/{id}")
    public String update(@Valid @ModelAttribute("sanPham")SanPham sanPham,Model model){
        model.addAttribute("sanPham",sanPham);
        sanPhamService.update(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}
