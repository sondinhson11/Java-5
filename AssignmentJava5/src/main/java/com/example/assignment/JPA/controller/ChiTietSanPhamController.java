package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.ChiTietSanPham;
import com.example.assignment.JPA.service.ChiTietSanPhamService;
import com.example.assignment.JPA.service.DongSPService;
import com.example.assignment.JPA.service.MauSacService;
import com.example.assignment.JPA.service.NSXService;
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
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private NSXService nsxService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSPService dongSPService;
    @GetMapping("/chi-tiet-san-pham/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        model.addAttribute("chiTietSP",new ChiTietSanPham());
        Pageable pageable = PageRequest.of(integer,3);
        Page<ChiTietSanPham> chiTietsPPage = chiTietSanPhamService.phanTrang(pageable);
        model.addAttribute("listCTSP",chiTietsPPage);
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("listNSX",nsxService.getAll());
        model.addAttribute("listMS",mauSacService.getAll());
        model.addAttribute("listDSP",dongSPService.getAll());
        return "/chitietsanpham/hien-thi-chi-tiet-san-pham";
    }
    @PostMapping("/chi-tiet-san-pham/add")
    public String add(@Valid @ModelAttribute("chiTietSP") ChiTietSanPham chiTietSanPham, BindingResult result, Model model){
        model.addAttribute("chiTietSP", chiTietSanPham);
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("listNSX",nsxService.getAll());
        model.addAttribute("listMS",mauSacService.getAll());
        model.addAttribute("listDSP",dongSPService.getAll());
        chiTietSanPhamService.add(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";

    }
    @GetMapping("/chi-tiet-san-pham/remove/{id}")
    public String remove(@PathVariable("id")UUID id){
        chiTietSanPhamService.remove(id);
        return "redirect:/chi-tietSP/hien-thi";
    }
    @GetMapping("/chi-tiet-san-pham/detail/{id}")
    public String deatil(@PathVariable("id")UUID id,Model model){
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("listNSX",nsxService.getAll());
        model.addAttribute("listMS",mauSacService.getAll());
        model.addAttribute("listDSP",dongSPService.getAll());
        model.addAttribute("chiTietSP", chiTietSanPhamService.detail(id));
        return "/chitietsanpham/update-chi-tiet-san-pham";
    }
    @PostMapping("/chi-tiet-san-pham/update/{id}")
    public String update(@Valid @ModelAttribute("chiTietSP") ChiTietSanPham chiTietSanPham, Model model){
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("listNSX",nsxService.getAll());
        model.addAttribute("listMS",mauSacService.getAll());
        model.addAttribute("listDSP",dongSPService.getAll());
        model.addAttribute("chiTietSP", chiTietSanPham);
        chiTietSanPhamService.update(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

}
