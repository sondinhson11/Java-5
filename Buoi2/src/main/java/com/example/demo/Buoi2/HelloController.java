package com.example.demo.Buoi2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//Tất cả các class trong com+> đều là bean được Spring quản lý
//khi đánh dấu là @Controller => Class này =>controller
//dùng để trao đổi giữa client và server
public class HelloController {
    //  client và server  Giao tiếp thông qua http
//    Có 4 loại HTTP cơ bản
//    GET <=> READ
//    POST<=> CREATE
//    PUT<=> UPDATE
//    DELETE<=> DELETE
//    Với java 4-5 dùng 2 loại get và post
//    GET : LẤY DỮ LIỆU/HIỂN THỊ/XÓA
//    Post: XỬ LÝ
//    Khi dùng @Controller => mô hình trong project MVC(MODEL _ VIEW _ CONTROLLER)
//    => Tất cả req trong controller luôn luôn trả về 1 View<=> Return String
//    C1: @GETMAPPING
//    @GetMapping("/demo")
//    C2:requestMapping
    @RequestMapping(value = "/demo",method = RequestMethod.GET)

    public String hienThiHelloWorld(Model model) {
//        truyền tham số từ controller sang view
//        J4: req.setAttribute("tên biến đẩy sang",giá trị)
//        j5: Model
        model.addAttribute("ten", "Văn Đình Sơn");
        model.addAttribute("sdt", "086252105");
        model.addAttribute("linkFB", "https://vi-vn.facebook.com/sondinhson11");
        return "buoi2";
    }
}
