package com.hoteltest.controller;

import com.hoteltest.service.room.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IRoomService roomService;

    @GetMapping("/rooms")
    public String showUserRooms(Model model) {
        model.addAttribute("totalRooms", roomService.getTotalRooms());
        return "user/rooms";
    }
} 