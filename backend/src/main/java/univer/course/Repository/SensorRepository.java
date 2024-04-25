package univer.course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import univer.course.Model.Room;
import univer.course.Model.Sensor;

import java.util.List;
import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<univer.course.Model.Sensor,Long> {
    Optional<Sensor> findByNameIgnoreCase(String name);
}
