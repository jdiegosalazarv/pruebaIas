package co.com.ias.pruebaias.infrastructure.entry_points;

import co.com.ias.pruebaias.domain.usecase.EventUseCase;
import co.com.ias.pruebaias.infrastructure.entry_points.model.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {

    private final EventUseCase eventUseCase;

    public Mono<ServerResponse> saveEvents(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(EventDto.class)
                .map(EventDto::toDomain)
                .flatMap(eventUseCase::saveEvent)
                .map(EventDto::fromDomain)
                .flatMap(response -> ServerResponse.status(201).bodyValue(response));
    }

    public Mono<ServerResponse> getEvent(ServerRequest serverRequest) {
        var eventId = serverRequest.pathVariable("id");
        return eventUseCase.findEventById(Integer.valueOf(eventId)).map(EventDto::fromDomain)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));

    }

}
