package co.com.ias.pruebaias.infrastructure.driven_adapters.model;

import co.com.ias.pruebaias.domain.model.events.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "events", schema = "public")
public class EventDbo {

    @Id
    private Integer id;
    private String name;
    private String date;
    private String location;
    @Column("user_id")
    private Integer userId;


    public static Event toDomain(EventDbo eventDbo) {
        return new Event(
                eventDbo.getId(),
                eventDbo.getName(),
                eventDbo.getDate(),
                eventDbo.getLocation(),
                eventDbo.getUserId()
        );
    }

    public static EventDbo fromDomain(Event event) {
        return EventDbo.builder()
                .id(event.getId())
                .name(event.getName())
                .date(event.getDate())
                .location(event.getLocation())
                .userId(event.getUserId())
                .build();
    }
}