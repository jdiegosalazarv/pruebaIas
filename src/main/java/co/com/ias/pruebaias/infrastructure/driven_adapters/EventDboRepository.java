package co.com.ias.pruebaias.infrastructure.driven_adapters;

import co.com.ias.pruebaias.infrastructure.driven_adapters.model.EventDbo;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EventDboRepository extends ReactiveCrudRepository<EventDbo, Integer> {
}
