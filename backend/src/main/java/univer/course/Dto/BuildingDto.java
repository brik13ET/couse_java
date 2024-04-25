package univer.course.Dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class BuildingDto {
    private Long id;

    private String name;

    @Builder.Default
    private List<Long> rooms_id = new ArrayList<>();

    public static BuildingDto toDto(univer.course.Model.Building ent)
    {
        return BuildingDto.builder()
                .id(ent.getId())
                .name(ent.getName())
                .build();
    }

    public static univer.course.Model.Building toEnt(BuildingDto ent)
    {
        return univer.course.Model.Building.builder()
                .id(ent.getId())
                .name(ent.getName())
                .build();
    }
}
