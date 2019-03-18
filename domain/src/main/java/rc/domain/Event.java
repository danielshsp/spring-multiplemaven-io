package rc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="events" , uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")})
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int eventId;
    @Column(name = "title", columnDefinition = "NVARCHAR(255)")
    @JsonProperty("event_type")
    private String eventType;
    @Column(name = "description", columnDefinition = "NVARCHAR(255)")
    private String data;
    @Column(name = "timestamp", columnDefinition = "NVARCHAR(255)")
    private String timestamp;

    public Event() {
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
