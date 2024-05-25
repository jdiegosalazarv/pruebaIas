package co.com.ias.pruebaias.infrastructure.driven_adapters;

import co.com.ias.pruebaias.domain.model.events.Event;
import co.com.ias.pruebaias.infrastructure.driven_adapters.model.EventDbo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class EventsDboRepositoryAdapterTest {

    EventsDboRepositoryAdapter eventsDboRepositoryAdapter;
    @Mock
    EventDboRepository repository;
    Event event;
    EventDbo eventDbo;

    @BeforeEach
    void setUp() {
        openMocks(this);
        eventsDboRepositoryAdapter = new EventsDboRepositoryAdapter(repository);
        event = new Event(1, "Concierto", "25052024", "Medellin", 2);
        eventDbo = new EventDbo(1, "Concierto", "25052024", "Medellin", 2);
    }

    @Test
    void saveEvent() {
        when(repository.save(any(EventDbo.class))).thenReturn(Mono.just(eventDbo));

        eventsDboRepositoryAdapter.saveEvent(event).as(StepVerifier::create).assertNext(response -> {
            assertEquals("Concierto", response.getName());
            assertEquals("Medellin", response.getLocation());
        }).verifyComplete();
    }

    @Test
    void findById() {

        when(repository.findById(any(Integer.class))).thenReturn(Mono.just(eventDbo));

        eventsDboRepositoryAdapter.findById(1).as(StepVerifier::create).assertNext(response -> {
            assertEquals("25052024", response.getDate());
            assertEquals("Medellin", response.getLocation());
        }).verifyComplete();
    }
}