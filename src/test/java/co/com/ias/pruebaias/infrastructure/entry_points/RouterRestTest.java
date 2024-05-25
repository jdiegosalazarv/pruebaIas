package co.com.ias.pruebaias.infrastructure.entry_points;

import co.com.ias.pruebaias.domain.model.events.Event;
import co.com.ias.pruebaias.domain.usecase.EventUseCase;
import co.com.ias.pruebaias.infrastructure.entry_points.model.EventDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@WebFluxTest({RouterRest.class, Handler.class})
class RouterRestTest {
    @Autowired
    WebTestClient testClient;
    @MockBean
    EventUseCase eventUseCase;
    Event event;
    EventDto eventDto;

    @BeforeEach
    void setUp() {
        openMocks(this);
        event = new Event(1, "Concierto", "25052024", "Medellin", 2);
        eventDto = new EventDto(1, "Concierto", "25052024", "Medellin", 2);

    }

    @Test
    void saveEvents() {
        when(eventUseCase.saveEvent(any(Event.class))).thenReturn(Mono.just(event));

        testClient.post()
                .uri("/iasapi/events")
                .bodyValue(eventDto)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isEqualTo(201)
                .expectBody()
                .jsonPath("$.name").isEqualTo("Concierto");
    }
}