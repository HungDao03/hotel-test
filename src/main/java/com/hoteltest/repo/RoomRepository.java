package com.hoteltest.repo;


import com.hoteltest.model.Room;
import com.hoteltest.model.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r JOIN FETCH r.roomType")
    List<Room> findAllWithRoomType();
    long count(); // Tổng số phòng

    long countByStatus(RoomStatus status); // Đếm theo trạng thái
}
