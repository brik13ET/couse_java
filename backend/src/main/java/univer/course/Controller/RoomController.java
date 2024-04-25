package univer.course.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import univer.course.Dto.RoomDto;
import univer.course.Dto.SensorDto;
import univer.course.Service.RoomService;

import java.util.List;
import java.util.Optional;

@RequestMapping("/room")
@RestController
@AllArgsConstructor
public class RoomController {

    RoomService service;

    @PostMapping()
    Optional<?> create(@RequestBody RoomDto buildingDto)
    {
        return Optional.of(service.create(buildingDto));
    }
    @GetMapping     ("/{id}")
    Optional<?> getById(@PathVariable(name = "id") Long id)
    {
        return Optional.of(service.getById(id));
    }

    @GetMapping     ("/{id}/sensors")
    List<SensorDto> getByRoomId(@PathVariable(name = "id") Long id)
    {
        return service.getByRoomId(id);
    }

    @GetMapping()
    Optional<?> getAll()
    {
        return Optional.of(service.getAll());
    }

    @PutMapping     ("/{id}")
    Optional<?> update(@RequestBody RoomDto buildingDto)
    {
        return service.update(buildingDto);
    }

    @DeleteMapping  ("/{id}")
    Optional<?> deleteById(@PathVariable Long id)
    {
        return Optional.empty();
    }

}
