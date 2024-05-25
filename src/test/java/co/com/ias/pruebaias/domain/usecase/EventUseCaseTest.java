package co.com.ias.pruebaias.domain.usecase;

import co.com.ias.pruebaias.domain.model.events.Event;
import co.com.ias.pruebaias.domain.model.events.gateway.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class EventUseCaseTest {

    EventUseCase eventUseCase;
    @Mock
    EventRepository eventRepository;
    Event event;

    @BeforeEach
    void setUp() {
        openMocks(this);
        eventUseCase = new EventUseCase(eventRepository);
        event = new Event(1, "Concierto", "25052024", "Medellin", 2);
    }

    @Test
    void saveEvent() {
        when(eventRepository.saveEvent(any(Event.class))).thenReturn(Mono.just(event));

        eventUseCase.saveEvent(event).as(StepVerifier::create).assertNext(response -> {
            assertEquals("Concierto", response.getName());
            assertEquals("Medellin", response.getLocation());
        }).verifyComplete();
    }

    @Test
    void findEventById() {

        when(eventRepository.findById(any(Integer.class))).thenReturn(Mono.just(event));

        eventUseCase.findEventById(1).as(StepVerifier::create).assertNext(response -> {
            assertEquals("25052024", response.getDate());
            assertEquals("Medellin", response.getLocation());
        }).verifyComplete();
    }
}