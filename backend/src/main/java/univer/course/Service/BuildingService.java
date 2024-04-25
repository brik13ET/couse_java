package univer.course.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import univer.course.Dto.BuildingDto;
import univer.course.Dto.RoomDto;
import univer.course.Repository.BuildingRepository;
import univer.course.Repository.RoomRepository;

import java.util.*;

@Service
@AllArgsConstructor
public class BuildingService {
    BuildingRepository buildingRepository;

    public Optional<BuildingDto> getById(Long id) {
        return buildingRepository.findById(id).map(BuildingDto::toDto);
    }

    public List<BuildingDto> getAll() {
        return buildingRepository.findAll().stream().map(BuildingDto::toDto).toList();
    }

    public BuildingDto create(BuildingDto buildingDto) {
        return BuildingDto.toDto(
                buildingRepository.saveAndFlush(
                        BuildingDto.toEnt(
                                buildingDto
                        )
                )

        );
    }

    public Optional<BuildingService> update(BuildingDto buildingDto) {
        var dbo_opt = buildingRepository.findById(buildingDto.getId());
        if (dbo_opt.isPresent()) {
            var dbo = dbo_opt.get();
            dbo.setName(buildingDto.getName());
            buildingRepository.saveAndFlush(dbo);
        }
        return Optional.empty();
    }

    public Map<Long, Long> getRoomCount() {
        var dbo_build = buildingRepository.roomCount();
        var ret = new HashMap<Long, Long>();
        for (int i = 0; i < dbo_build.size(); i++) {
            var curr = dbo_build.get(i);
            ret.put((long) curr.get("id"), (long) curr.get("cnt"));
        }
        return ret;
    }

    public List<RoomDto> getByBuildingId(Long id) {
        var dboBuilding = buildingRepository.findById(id);
        if (dboBuilding.isEmpty())
            return Collections.emptyList();
        return dboBuilding.get().getRooms().stream().map(RoomDto::toDto).toList();
    }

    public void delete(Long id) {
        if (buildingRepository.existsById(id))
        {
            buildingRepository.deleteById(id);
        }
    }
}
