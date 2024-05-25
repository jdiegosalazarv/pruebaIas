package co.com.ias.pruebaias.infrastructure.entry_points.model;

import co.com.ias.pruebaias.domain.model.events.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {

    private Integer id;
    private String name;
    private String date;
    private String location;
    private Integer userId;

    public static Event toDomain(EventDto eventDto) {
        return new Event(
                eventDto.getId(),
                eventDto.getName(),
                eventDto.getDate(),
                eventDto.getLocation(),
                eventDto.getUserId()
        );
    }

    public static EventDto fromDomain(Event event) {
        return EventDto.builder()
                .id(event.getId())
                .name(event.getName())
                .date(event.getDate())
                .location(event.getLocation())
                .userId(event.getUserId())
                .build();
    }
}
