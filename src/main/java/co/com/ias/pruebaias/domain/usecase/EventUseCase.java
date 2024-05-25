package co.com.ias.pruebaias.domain.usecase;

import co.com.ias.pruebaias.domain.model.events.Event;
import co.com.ias.pruebaias.domain.model.events.gateway.EventRepository;
import reactor.core.publisher.Mono;

public class EventUseCase {
    private final EventRepository eventRepository;

    public EventUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Mono<Event> saveEvent(Event event) {
        return eventRepository.saveEvent(event);
    }

    public Mono<Event> findEventById(Integer id) {
        return eventRepository.findById(id);
    }
}
