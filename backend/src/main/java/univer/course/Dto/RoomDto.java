package univer.course.Dto;

import lombok.*;
import univer.course.Model.Room;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class RoomDto {
    private Long id;
    private String name;
    private Long building_id;
    private List<Long> sensor_ids;

    public static RoomDto toDto(Room room)
    {
        return RoomDto.builder()
                .id(room.getId())
                .name(room.getName())
                .building_id(room.getBuilding().getId())
                .sensor_ids(
                        room
                                .getSensors()
                                .stream()
                                .map( s -> s.getId())
                                .toList()
                )
                .build();
    }

    public static Room toEntity(RoomDto room)
    {
        return Room.builder()
                .id(room.getId())
                .name(room.getName())
                .build();
    }
}
