package co.com.ias.pruebaias.infrastructure.driven_adapters;

import co.com.ias.pruebaias.domain.model.events.Event;
import co.com.ias.pruebaias.domain.model.events.gateway.EventRepository;
import co.com.ias.pruebaias.infrastructure.driven_adapters.model.EventDbo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class EventsDboRepositoryAdapter implements EventRepository {

    private final EventDboRepository repository;

    @Override
    public Mono<Event> saveEvent(Event event) {
        return repository.save(EventDbo.fromDomain(event)).map(EventDbo::toDomain);
    }

    @Override
    public Mono<Event> findById(Integer id) {
        return repository.findById(id).map(EventDbo::toDomain);
    }
}
