package univer.couse_java.Dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Building {
    private Long id;

    private String name;

    private List<Long> rooms_id;
}
