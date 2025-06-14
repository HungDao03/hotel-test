package com.hoteltest.controller;

import com.hoteltest.service.room.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AuthController {
    @Autowired
    private IRoomService roomService;

    // Trang dashboard
    @GetMapping({"/admin", })
    public String showAdminDashboard(Model model) {
        model.addAttribute("totalRooms", roomService.getTotalRooms());
        model.addAttribute("emptyRooms", roomService.getEmptyRooms());
        model.addAttribute("occupiedRooms", roomService.getOccupiedRooms());
        model.addAttribute("bookedRooms", roomService.getBookedRooms());
        return "admin/dashboard/admin-dashboard";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
