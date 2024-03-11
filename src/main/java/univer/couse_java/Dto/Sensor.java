package univer.couse_java.Dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sensor {
    private Long id;

    private String name;

    private Long value;

    private Long room_id;
}
