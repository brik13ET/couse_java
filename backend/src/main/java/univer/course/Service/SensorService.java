package univer.course.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import univer.course.Dto.SensorDto;
import univer.course.Repository.RoomRepository;
import univer.course.Repository.SensorRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorService {
    final SensorRepository sensorRepository;
    final RoomRepository roomRepository;

    public Optional<SensorDto> create(SensorDto dto)
    {
        var roomDbo = roomRepository.findById(dto.getRoom_id());
        if (!roomDbo.isEmpty())
            return Optional.empty();

        var room = roomDbo.get();
        var ent = SensorDto.toEntity(dto);

        ent.setRoom(room);
        room.getSensors().add(ent);

        ent  = sensorRepository.save(ent);
        roomRepository.save(room);

        return Optional.of(SensorDto.toDto(ent));
    }

    public Optional<SensorDto> getById(Long id)
    {
        return sensorRepository.findById(id).map(SensorDto::toDto);
    }

    public Optional<SensorDto> getByName(String name)
    {
        return sensorRepository.findByNameIgnoreCase(name).map(SensorDto::toDto);
    }


    public void updateValue(String name, String data)
    {
        var dbo = sensorRepository.findByNameIgnoreCase(name);
        if (dbo.isEmpty())
            return;
        var sensor = dbo.get();
        sensor.setValue(data);
        sensorRepository.save(sensor);
    }

    public Optional<SensorDto> update(SensorDto sernsorDto) {
        if (sernsorDto.getId() == null)
            return Optional.empty();
        var dbo = sensorRepository.findById(sernsorDto.getId());
        if (dbo.isEmpty())
            return Optional.empty();
        var ent = dbo.get();
        if (sernsorDto.getName() != null)
            ent.setName(sernsorDto.getName());
        if (sernsorDto.getRoom_id() != null && roomRepository.existsById(sernsorDto.getRoom_id()))
            ent.setRoom(roomRepository.findById(sernsorDto.getRoom_id()).get());
        ent = sensorRepository.save(ent);
        return Optional.of(SensorDto.toDto(ent));
    }

    public List<SensorDto> getAll() {
        return sensorRepository.findAll().stream().map(SensorDto::toDto).toList();
    }
}
