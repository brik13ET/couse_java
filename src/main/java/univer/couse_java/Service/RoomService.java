package univer.couse_java.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import univer.couse_java.Repository.RoomRepository;

@Service
@RequiredArgsConstructor
public class RoomService {
    final RoomRepository repository;
}
