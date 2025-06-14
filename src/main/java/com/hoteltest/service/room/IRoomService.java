package com.hoteltest.service.room;



import com.hoteltest.model.Room;
import com.hoteltest.service.IGenericService;

import java.util.List;

public interface IRoomService extends IGenericService<Room> {
    List<Room> findAllWithRoomType();

    long getTotalRooms();
    long getEmptyRooms();
    long getOccupiedRooms();
    int getBookedRooms();
}
