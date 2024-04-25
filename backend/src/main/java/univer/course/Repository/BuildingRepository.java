package univer.course.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BuildingRepository extends JpaRepository<univer.course.Model.Building, Long> {
    @Query("select b.id as id, (select count(r.id) from Room r where r.building.id = b.id) as cnt from Building b")
    List<Map<String, Object>> roomCount();
}
