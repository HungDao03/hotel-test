package com.hoteltest.service.room;


import com.hoteltest.model.Room;
import com.hoteltest.model.RoomStatus;
import com.hoteltest.repo.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }
    @Override
    public Room findById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }
    @Override
    public void delete(Room room) {
        roomRepository.delete(room);
    }
    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }


    @Override
    public List<Room> findAllWithRoomType() {
        return roomRepository.findAllWithRoomType();
    }
    @Override
    public long getTotalRooms() {
        return roomRepository.count();
    }

    @Override
    public long getEmptyRooms() {
        return roomRepository.countByStatus(RoomStatus.EMPTY);
    }

    @Override
    public long getOccupiedRooms() {
        return roomRepository.countByStatus(RoomStatus.OCCUPIED);
    }
    public int getBookedRooms() {
        return (int) roomRepository.findAll().stream()
                .filter(r -> r.getStatus() == RoomStatus.BOOKED)
                .count();
    }
}
