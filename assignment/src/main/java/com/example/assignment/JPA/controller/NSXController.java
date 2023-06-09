package com.example.assignment.JPA.controller;

import com.example.assignment.JPA.entity.NSX;
import com.example.assignment.JPA.service.NSXService;
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
public class NSXController {
    @Autowired
    private NSXService nsxService;
    @GetMapping("/nsx/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        model.addAttribute("nsx",new NSX());
        Pageable pageable = PageRequest.of(integer,3);
        Page<NSX> nsxPage = nsxService.phanTrang(pageable);
        model.addAttribute("listNSX",nsxPage);
        return "nsxs";
    }
    @PostMapping("/nsx/add")
    public String add(@Valid @ModelAttribute("nsx")NSX nsx, BindingResult result, Model model, @RequestParam(defaultValue = "0",name = "page")Integer integer){
        if(result.hasErrors()){
            Pageable pageable = PageRequest.of(integer,3);
            Page<NSX> nsxPage = nsxService.phanTrang(pageable);
            model.addAttribute("listNSX",nsxPage);
            return "nsxs";
        }
        model.addAttribute("nsx",nsx);
        nsxService.add(nsx);
        return "redirect:/nsx/hien-thi";
    }
    @GetMapping("/nsx/remove/{id}")
    public String delete(@PathVariable("id")UUID id){
        nsxService.remove(id);
        return "redirect:/nsx/hien-thi";
    }
    @GetMapping("/nsx/detail/{id}")
    public String detail(@PathVariable("id")UUID id,Model model){
        model.addAttribute("nsx",nsxService.detail(id));
        return "viewupNSX";
    }
    @PostMapping("/nsx/update/{id}")
    public String update(@Valid @ModelAttribute("nsx")NSX nsx,Model model){
        model.addAttribute("nsx",nsx);
        nsxService.update(nsx);
        return "redirect:/nsx/hien-thi";
    }
}
