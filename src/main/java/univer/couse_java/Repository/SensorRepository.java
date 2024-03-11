package univer.couse_java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import univer.couse_java.Model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor,Long> {
}
