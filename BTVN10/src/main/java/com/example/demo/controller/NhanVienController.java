package com.example.demo.controller;

import com.example.demo.entity.ChucVu;
import com.example.demo.entity.CuaHang;
import com.example.demo.entity.NhanVien;
import com.example.demo.repository.ChucVuReposiory;
import com.example.demo.repository.CuaHangRepository;
import com.example.demo.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.UUID;

@Controller
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuReposiory chucVuReposiory;

    @Autowired
    private CuaHangRepository cuaHangRepository;

    @GetMapping("nhan-vien/hien-thi")
    public String hienThiNhanVien(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<NhanVien> nhanVienPage = nhanVienService.getPage(pageable);
        model.addAttribute("dsch", cuaHangRepository.findAll());
        model.addAttribute("dscv", chucVuReposiory.findAll());
        model.addAttribute("danhSach", nhanVienPage);
        return "index";
    }

    @PostMapping("/nhan-vien/add")
    public String add(Model model,
                      @RequestParam("ma") String ma,
                      @RequestParam("ho") String ho,
                      @RequestParam("tenDem") String tenDem,
                      @RequestParam("ten") String ten,
                      @RequestParam("gioiTinh") String gioiTinh,
                      @RequestParam("ngaySinh") Date ngaySinh,
                      @RequestParam("chucVu") String cv,
                      @RequestParam("cuaHang") String ch) {
        ChucVu chucVu = chucVuReposiory.findById(UUID.fromString(cv)).orElse(null);
        CuaHang cuaHang = cuaHangRepository.findById(UUID.fromString(ch)).orElse(null);
        NhanVien nhanVien = NhanVien.builder().ma(ma).ho(ho).tenDem(tenDem).ten(ten).gioiTinh(gioiTinh).ngaySinh(ngaySinh).chucVu(chucVu).cuaHang(cuaHang).build();
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/nhan-vien/view-update/{id}")
    public String viewupdate(@PathVariable("id") String id, Model model) {
        model.addAttribute("dsch", cuaHangRepository.findAll());
        model.addAttribute("dscv", chucVuReposiory.findAll());
        model.addAttribute("nv", nhanVienService.findById(UUID.fromString(id)));
        return "update";
    }

    @GetMapping("/nhan-vien/detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        model.addAttribute("nv", nhanVienService.findById(UUID.fromString(id)));
        return "detail";
    }

    @GetMapping("/nhan-vien/remove/{id}")
    public String remove(@PathVariable("id") String id) {
        nhanVienService.remove(UUID.fromString(id));
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/nhan-vien/update")
    public String update(@RequestParam("id") String id,
                         @RequestParam("ma") String ma,
                         @RequestParam("ho") String ho,
                         @RequestParam("tenDem") String tenDem,
                         @RequestParam("ten") String ten,
                         @RequestParam("gioiTinh") String gioiTinh,
                         @RequestParam("ngaySinh") Date ngaySinh,
                         @RequestParam("chucVu") String cv,
                         @RequestParam("cuaHang") String ch
    ) {
        NhanVien nv = nhanVienService.findById(UUID.fromString(id));
        CuaHang cuaHang = cuaHangRepository.findById(UUID.fromString(ch)).orElse(null);
        ChucVu chucVu = chucVuReposiory.findById(UUID.fromString(cv)).orElse(null);
        NhanVien nhanVien = NhanVien.builder().ma(ma).ho(ho).tenDem(tenDem).ten(ten).gioiTinh(gioiTinh).ngaySinh(ngaySinh).chucVu(chucVu).cuaHang(cuaHang).build();
        nhanVien.setId(UUID.fromString(id));

        BeanUtils.copyProperties(nhanVien, nv);
        nhanVienService.update(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

}
