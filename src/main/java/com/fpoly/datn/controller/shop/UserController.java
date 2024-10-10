package com.fpoly.datn.controller.shop;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
@GetMapping("/home")
    public String getHome() {
    return "shop/index";
}

}
