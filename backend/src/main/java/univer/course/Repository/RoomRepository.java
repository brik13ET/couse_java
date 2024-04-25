package univer.course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import univer.course.Model.Room;

import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<univer.course.Model.Room, Long> {
    Optional<Room> findByNameIgnoreCase(String name);
}
