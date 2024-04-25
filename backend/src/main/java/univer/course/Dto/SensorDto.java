package univer.course.Dto;

import lombok.*;
import univer.course.Model.Sensor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class SensorDto {
    private Long id;

    private String name;

    private String value;

    private Long room_id;

    public static SensorDto toDto(Sensor sensor)
    {
        return SensorDto.builder()
                .id(sensor.getId())
                .name(sensor.getName())
                .value(sensor.getValue())
                .room_id(sensor.getRoom().getId())
                .build();
    }

    public static Sensor toEntity(SensorDto sensor)
    {
        return Sensor.builder()
                .id(sensor.getId())
                .name(sensor.getName())
                .value(sensor.getValue())
                .build();
    }


}
