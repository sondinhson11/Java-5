package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.ChiTietsP;
import com.example.assignment.JPA.service.ChiTietSPService;
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
public class ChiTietSPController {
    @Autowired
    private ChiTietSPService chiTietSPService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private NSXService nsxService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSPService dongSPService;
    @GetMapping("/chi-tietSP/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        model.addAttribute("chiTietSP",new ChiTietsP());
        Pageable pageable = PageRequest.of(integer,3);
        Page<ChiTietsP> chiTietsPPage = chiTietSPService.phanTrang(pageable);
        model.addAttribute("listCTSP",chiTietsPPage);
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("listNSX",nsxService.getAll());
        model.addAttribute("listMS",mauSacService.getAll());
        model.addAttribute("listDSP",dongSPService.getAll());
        return "chitietsps";
    }
    @PostMapping("/chi-tietSP/add")
    public String add(@Valid @ModelAttribute("chiTietSP")ChiTietsP chiTietsP, BindingResult result,Model model){
        model.addAttribute("chiTietSP",chiTietsP);
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("listNSX",nsxService.getAll());
        model.addAttribute("listMS",mauSacService.getAll());
        model.addAttribute("listDSP",dongSPService.getAll());
        chiTietSPService.add(chiTietsP);
        return "redirect:/chi-tietSP/hien-thi";

    }
    @GetMapping("/chi-tietSP/remove/{id}")
    public String remove(@PathVariable("id")UUID id){
        chiTietSPService.remove(id);
        return "redirect:/chi-tietSP/hien-thi";
    }
    @GetMapping("/chi-tietSP/detail/{id}")
    public String deatil(@PathVariable("id")UUID id,Model model){
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("listNSX",nsxService.getAll());
        model.addAttribute("listMS",mauSacService.getAll());
        model.addAttribute("listDSP",dongSPService.getAll());
        model.addAttribute("chiTietSP",chiTietSPService.detail(id));
        return "viewupCTSP";
    }
    @PostMapping("/chi-tietSP/update/{id}")
    public String update(@Valid @ModelAttribute("chiTietSP")ChiTietsP chiTietsP,Model model){
        model.addAttribute("listSP",sanPhamService.getAll());
        model.addAttribute("listNSX",nsxService.getAll());
        model.addAttribute("listMS",mauSacService.getAll());
        model.addAttribute("listDSP",dongSPService.getAll());
        model.addAttribute("chiTietSP",chiTietsP);
        chiTietSPService.update(chiTietsP);
        return "redirect:/chi-tietSP/hien-thi";
    }

}
