package univer.course.Controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import univer.course.Dto.SensorDto;
import univer.course.Service.SensorService;

import java.util.Map;
import java.util.Optional;

@RequestMapping("/sensor")
@RestController
@AllArgsConstructor
public class SensorController {

    SensorService service;

    @PostMapping    ()
    Optional<?> create(@RequestBody SensorDto sernsorDto)
    {
        return Optional.of(service.create(sernsorDto));
    }
    @GetMapping     ("/{id}")
    Optional<?> getById(@PathVariable(name = "id") Long id)
    {
        return Optional.of(service.getById(id));
    }

    @GetMapping     ()
    Optional<?> getAll()
    {
        return Optional.of(service.getAll());
    }

    @PutMapping     ("/{id}")
    Optional<?> update(@RequestBody SensorDto sernsorDto)
    {
        return Optional.of(service.update(sernsorDto));
    }

    @DeleteMapping  ("/{id}")
    Optional<?> deleteById(@PathVariable Long id)
    {
        return Optional.empty();
    }

}
