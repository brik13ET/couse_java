package univer.couse_java.Dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {
    private Long id;

    private String name;

    private Building building;

    private List<Long> sensors_id;
}
