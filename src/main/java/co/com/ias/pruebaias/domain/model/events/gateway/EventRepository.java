package co.com.ias.pruebaias.domain.model.events.gateway;

import co.com.ias.pruebaias.domain.model.events.Event;
import reactor.core.publisher.Mono;

public interface EventRepository {

    Mono<Event> saveEvent(Event event);

    Mono<Event> findById(Integer id);

}
