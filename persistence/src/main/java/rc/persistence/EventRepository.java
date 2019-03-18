package rc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rc.domain.Event;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findByeventId(int evenId);
    long countBydata(String data);
    long countByeventType(String eventType);
}
