package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.ChucVu;
import com.example.assignment.JPA.service.ChucVuService;
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
public class ChucVuController {
    @Autowired
    ChucVuService chucVuService;
    @GetMapping("/chuc-vu/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0",name = "page")Integer number){
        model.addAttribute("chucVu",new ChucVu());
        Pageable pageable = PageRequest.of(number,3);
        Page<ChucVu> chucVuPage = chucVuService.phanTrang(pageable);
        model.addAttribute("listCV",chucVuPage);
        return "chucvus";
    }
    @PostMapping("/chuc-vu/add")
    public String add(@Valid @ModelAttribute("chucVu")ChucVu chucVu, BindingResult result,Model model,@RequestParam(defaultValue = "0",name = "page")Integer number){
        if(result.hasErrors()){
            Pageable pageable = PageRequest.of(number,3);
            Page<ChucVu> chucVuPage = chucVuService.phanTrang(pageable);
            model.addAttribute("listCV",chucVuPage);
            return "chucvus";
        }
        model.addAttribute("chucVu",chucVu);
        chucVuService.addCV(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
    @GetMapping("/chuc-vu/delete/{id}")
    public String delete(@PathVariable("id")UUID id){
        chucVuService.remove(id);
        return "redirect:/chuc-vu/hien-thi";
    }
    @GetMapping("/chuc-vu/detail/{id}")
    public String detail(@PathVariable("id")UUID id,Model model){
        model.addAttribute("chucVu",chucVuService.detail(id));
        return "viewupCV";
    }
    @PostMapping("/chuc-vu/update/{id}")
    public String update(@Valid @ModelAttribute("chucVu")ChucVu chucVu, Model model){
        model.addAttribute("chucVu",chucVu);
        chucVuService.update(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
}
