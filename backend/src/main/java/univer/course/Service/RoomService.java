package univer.course.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import univer.course.Dto.RoomDto;
import univer.course.Dto.SensorDto;
import univer.course.Repository.BuildingRepository;
import univer.course.Repository.RoomRepository;
import univer.course.Repository.SensorRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {
    final RoomRepository roomRepository;
    final BuildingRepository buildingRepository;
    final SensorRepository sensorRepository;
    public Optional<RoomDto> getById(Long id)
    {
        return roomRepository.findById(id)
                .stream()
                .map(RoomDto::toDto)
                .findFirst();
    }
    public Optional<RoomDto> getByName(String name)
    {
        return roomRepository.findByNameIgnoreCase(name)
                .stream()
                .map(RoomDto::toDto)
                .findFirst();
    }



    public Optional<RoomDto> create(RoomDto dto)
    {
        var ent = RoomDto.toEntity(dto);
        var dboBuilding = buildingRepository.findById(dto.getBuilding_id());
        if (dboBuilding.isEmpty())
            return Optional.empty();
        var building = dboBuilding.get();
        ent.setBuilding(building);
        ent.setSensors(Collections.emptyList());
        ent = roomRepository.save(ent);
        return Optional.of(RoomDto.toDto(ent));
    }
    public Optional<RoomDto> update(RoomDto dto)
    {
        var roomDbo = roomRepository.findById(dto.getId());
        if (roomDbo.isEmpty())
            return Optional.empty();
        var room = roomDbo.get();

        if (dto.getId() != null)
            room.setId(dto.getId());
        if (dto.getName() != null)
            room.setName(dto.getName());
        if (dto.getBuilding_id() != null)
        {
            var dbo = buildingRepository.findById(dto.getBuilding_id());
            if (dbo.isEmpty())
                return Optional.empty();
            var building = dbo.get();
            room.setBuilding(building);
        }
        if (dto.getSensor_ids() != null)
        {
            var dbo = sensorRepository.findAllById(dto.getSensor_ids());
            if (dbo.isEmpty())
                return Optional.empty();
            room.setSensors(dbo);
        }
        room = roomRepository.save(room);
        return Optional.of(RoomDto.toDto(room));
    }

    public List<RoomDto> getAll() {
        return roomRepository.findAll().stream().map(RoomDto::toDto).toList();
    }

    public List<SensorDto> getByRoomId(Long id) {
        var dbo_room = roomRepository.findById(id);
        if (dbo_room.isEmpty())
            return Collections.emptyList();
        var room = dbo_room.get();
        return room.getSensors().stream().map(SensorDto::toDto).toList();
    }
}
