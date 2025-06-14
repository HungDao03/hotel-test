package com.hoteltest.controller;

import com.hoteltest.model.RoomType;
import com.hoteltest.service.roomtype.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/room-types")
public class RoomTypeController {

    @Autowired
    private IRoomTypeService roomTypeService;

    // Danh sách loại phòng
    @GetMapping
    public String listRoomTypes(Model model) {
        model.addAttribute("roomTypes", roomTypeService.findAll());
        return "admin/roomtype/list";
    }

    // Hiển thị form tạo mới
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("roomType", new RoomType());
        return "admin/roomtype/create";
    }

    // Xử lý form tạo mới
    @PostMapping("/create")
    public String createRoomType(@ModelAttribute RoomType roomType) {
        roomTypeService.save(roomType);
        return "redirect:/admin/room-types";
    }

    // Hiển thị form sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        RoomType roomType = roomTypeService.findById(id);
        if (roomType == null) {
            return "redirect:/admin/room-types";
        }

        model.addAttribute("roomType", roomType);
        model.addAttribute("roomTypeList", roomTypeService.findAll()); // 👈 thêm dòng này

        return "admin/roomtype/edit";
    }

    // Xử lý cập nhật
    @PostMapping("/edit/{id}")
    public String updateRoomType(@PathVariable Long id, @ModelAttribute RoomType roomType) {
        roomType.setId(id); // Gán lại ID vì form có thể không có
        roomTypeService.save(roomType);
        return "redirect:/admin/room-types";
    }

    // Xoá loại phòng
    @GetMapping("/delete/{id}")
    public String deleteRoomType(@PathVariable Long id) {
        roomTypeService.deleteById(id);
        return "redirect:/admin/room-types";
    }
}