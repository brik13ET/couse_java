package univer.couse_java.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import univer.couse_java.Repository.BuildingRepository;

@Service
@RequiredArgsConstructor
public class BuildingService {
    final BuildingRepository repository;
}
