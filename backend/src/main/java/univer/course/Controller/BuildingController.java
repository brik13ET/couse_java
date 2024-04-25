package univer.course.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import univer.course.Dto.BuildingDto;
import univer.course.Dto.RoomDto;
import univer.course.Service.BuildingService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/building")
@RestController
@AllArgsConstructor
public class BuildingController {

    BuildingService service;

    @PostMapping    ()
    Optional<?> create(@RequestBody BuildingDto buildingDto)
    {
        return Optional.of(service.create(buildingDto));
    }
    @GetMapping     ("/{id}")
    Optional<?> getById(@PathVariable(name = "id") Long id)
    {
        return Optional.of(service.getById(id));
    }

    @GetMapping( "/room_count")
    public Map<Long, Long> getRoomCount()
    {
        return service.getRoomCount();
    }
    @GetMapping     ("/{id}/rooms")
    List<RoomDto> getByBuildingId(@PathVariable(name = "id") Long id)
    {
        return service.getByBuildingId(id);
    }

    @GetMapping     ()
    List<?> getAll()
    {
        return service.getAll();
    }

    @PutMapping     ("/{id}")
    Optional<?> update(@RequestBody BuildingDto buildingDto)
    {
        return service.update(buildingDto);
    }

    @DeleteMapping  ("/{id}")
    ResponseEntity deleteById(@PathVariable Long id)
    {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
