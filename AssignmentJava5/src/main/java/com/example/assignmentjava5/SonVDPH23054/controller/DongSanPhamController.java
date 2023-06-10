package com.example.assignmentjava5.SonVDPH23054.controller;

import com.example.assignmentjava5.SonVDPH23054.entity.DongSP;
import com.example.assignmentjava5.SonVDPH23054.service.DongSPService;
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
public class DongSanPhamController {
    @Autowired
    private DongSPService dongSPService;
    @GetMapping("/dongSP/hien-thi")
    public String hienthi(Model model,@RequestParam(defaultValue = "0",name = "page")Integer number){
        model.addAttribute("dongSP",new DongSP());
        Pageable pageable = PageRequest.of(number,3);
        Page<DongSP> dongSPS = dongSPService.phanTrang(pageable);
        model.addAttribute("listDSP",dongSPS);
        return "/dongsanpham/hien-thi-dong-sp";
    }
    @PostMapping("/dongSP/add")
    public String add(@Valid @ModelAttribute("dongSP")DongSP dongSP, BindingResult result, Model model,@RequestParam(defaultValue = "0",name = "page")Integer number){
        if(result.hasErrors()){
            Pageable pageable = PageRequest.of(number,3);
            Page<DongSP> dongSPS = dongSPService.phanTrang(pageable);
            model.addAttribute("listDSP",dongSPS);
            return "/dongsanpham/hien-thi-dong-sp";
        }
        model.addAttribute("dongSP",dongSP);
        dongSPService.add(dongSP);
        return "redirect:/dongSP/hien-thi";
    }
    @GetMapping("/dongSP/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        dongSPService.remove(id);
        return "redirect:/dongSP/hien-thi";
    }
    @GetMapping("/dongSP/detail/{id}")
    public String viewup(@PathVariable("id")UUID id,Model model){
        model.addAttribute("dongSP",dongSPService.detail(id));
        return "/dongsanpham/update-dong-sp";
    }
    @PostMapping("/dongSP/update/{id}")
    public String update(@Valid @ModelAttribute("dongSP")DongSP dongSP,Model model){
        dongSPService.update(dongSP);
        model.addAttribute("dongSP",dongSP);
        return "redirect:/dongSP/hien-thi";
    }
}
