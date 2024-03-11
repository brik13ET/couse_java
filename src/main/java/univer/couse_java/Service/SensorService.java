package univer.couse_java.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import univer.couse_java.Repository.SensorRepository;

@Service
@RequiredArgsConstructor
public class SensorService {
    final SensorRepository repository;
}
