package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.NhanVien;
import com.example.assignment.JPA.service.ChucVuService;
import com.example.assignment.JPA.service.CuaHangService;
import com.example.assignment.JPA.service.NhanVienService;
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
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;
    @GetMapping("/nhan-vien/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        model.addAttribute("nhanVien",new NhanVien());
        Pageable pageable = PageRequest.of(integer,3);
        Page<NhanVien> nhanVienPage = nhanVienService.phanTrang(pageable);
        model.addAttribute("listNV",nhanVienPage);
        model.addAttribute("listCH",cuaHangService.getAll());
        model.addAttribute("listCV",chucVuService.getAll());
        return "nhanviens";
    }
    @PostMapping("/nhan-vien/add")
    public String add(@Valid @ModelAttribute("nhanVien")NhanVien nhanVien, BindingResult result,Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        if (result.hasErrors()){
            Pageable pageable = PageRequest.of(integer,3);
            Page<NhanVien> nhanVienPage = nhanVienService.phanTrang(pageable);
            model.addAttribute("listNV",nhanVienPage);
            model.addAttribute("listCH",cuaHangService.getAll());
            model.addAttribute("listCV",chucVuService.getAll());
            return "nhanviens";
        }
        model.addAttribute("nhanVien",nhanVien);
        model.addAttribute("listCH",cuaHangService.getAll());
        model.addAttribute("listCV",chucVuService.getAll());
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/nhan-vien/remove/{id}")
    public String remove(@PathVariable("id")UUID id){
        nhanVienService.remove(id);
        return "redirect:/nhan-vien/hien-thi";
    }
    @GetMapping("/nhan-vien/detail/{id}")
    public String remove(@PathVariable("id")UUID id,Model model){
        model.addAttribute("listCH",cuaHangService.getAll());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("nhanVien",nhanVienService.detail(id));
        return "viewupNV";
    }
    @PostMapping("/nhan-vien/update/{id}")
    public String update(@Valid @ModelAttribute("nhanVien")NhanVien nhanVien,Model model){
        model.addAttribute("listCH",cuaHangService.getAll());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("nhanVien",nhanVien);
        nhanVienService.update(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
}
