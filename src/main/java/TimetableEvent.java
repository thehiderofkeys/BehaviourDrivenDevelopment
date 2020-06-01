import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

public class TimetableEvent {

    private LocalDateTime startTime;
    private int duration;
    private EventType eventType;

    public TimetableEvent(LocalDateTime startTime, int duration, EventType eventType){
        this.startTime = startTime;
        this.duration = duration;
        this.eventType = eventType;
    }

    @JsonFormat(shape=JsonFormat.Shape.OBJECT)
    enum EventType {
        Lecture ("Lecture"),
        Lab ("Lab"),
        Tutorial ("Tutorial");

        private String value;

        EventType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDuration(){
        return duration;
    }
    public EventType getEventType() {
        return eventType;
    }
}
