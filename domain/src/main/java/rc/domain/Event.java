package rc.domain;

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
    private String event_type;
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

    public String getEvent_type() {
        return event_type;
    }

    public void setEvent_type(String event_type) {
        this.event_type = event_type;
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
