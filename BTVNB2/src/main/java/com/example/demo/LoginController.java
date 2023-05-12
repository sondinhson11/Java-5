package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private String error;

    @GetMapping("/login")
    public String hienThiLogin(Model model) {
        model.addAttribute("error", error);
        return "Login";
    }

    @PostMapping("/home")
    public String hienThiKetQua(@RequestParam("uname") String name, @RequestParam("mk") String mk) {
        if (mk.trim().isEmpty() || name.trim().isEmpty()) {
            error = "Không được để trống tài khoản hoặc mật khẩu";
            return "redirect:/login";
        }
        if (name.trim().equals("HangNT169") && mk.trim().equals("123456")) {
            error = "";
            return "Home";
        } else {
            error = "Tài Khoản Mật Khẩu Sai";
            return "redirect:/login";
        }
    }
}
