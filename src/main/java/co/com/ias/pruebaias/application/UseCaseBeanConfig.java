package co.com.ias.pruebaias.application;

import co.com.ias.pruebaias.domain.model.events.gateway.EventRepository;
import co.com.ias.pruebaias.domain.usecase.EventUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public EventUseCase eventUseCase(EventRepository eventRepository) {
        return new EventUseCase(eventRepository);
    }
}
