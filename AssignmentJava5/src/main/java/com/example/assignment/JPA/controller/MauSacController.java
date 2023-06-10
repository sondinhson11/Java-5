package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.MauSac;
import com.example.assignment.JPA.service.MauSacService;
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
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;
    @GetMapping("/mau-sac/hien-thi")
    public String hienthi(Model model,@RequestParam(defaultValue = "0",name = "page")Integer number){
        model.addAttribute("mauSac",new MauSac());
        Pageable pageable = PageRequest.of(number,3);
        Page<MauSac> mauSacPage = mauSacService.phanTrang(pageable);
        model.addAttribute("listMS",mauSacPage);
        return "/mausac/hien-thi-mau-sac";
    }
    @PostMapping("/mau-sac/add")
    public String add(@Valid @ModelAttribute("mauSac")MauSac mauSac, BindingResult result, Model model,@RequestParam(defaultValue = "0",name = "page")Integer number){
        if (result.hasErrors()){
            Pageable pageable = PageRequest.of(number,3);
            Page<MauSac> mauSacPage = mauSacService.phanTrang(pageable);
            model.addAttribute("listMS",mauSacPage);
            return "/mausac/hien-thi-mau-sac";
        }
        model.addAttribute("mauSac",mauSac);
        mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/mau-sac/remove/{id}")
    public String delete(@PathVariable("id")UUID id){
        mauSacService.remove(id);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@PathVariable("id")UUID id,Model model){
        model.addAttribute("mauSac",mauSacService.detail(id));
        return "/mausac/update-mau-sac";
    }
    @PostMapping("/mau-sac/update/{id}")
    public String update(@Valid @ModelAttribute("mauSac")MauSac mauSac,Model model){
        mauSacService.update(mauSac);
        model.addAttribute("mauSac",mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
