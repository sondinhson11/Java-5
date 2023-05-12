package com.example.demo.Buoi2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String hienThiLogin(){

        return "login";
    }
    @PostMapping("/ketqua")
    public String hienThiKetQua(Model model ,@RequestParam("uname")String name,@RequestParam("mk")String mk){
//        J4: req.getParameter("Ten cuar o")
//        J5: @RequestParam
        model.addAttribute("ten",name);
        model.addAttribute("mk",mk);
        return "ketqua";
    }
}
