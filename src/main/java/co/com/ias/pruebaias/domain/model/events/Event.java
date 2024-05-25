package co.com.ias.pruebaias.domain.model.events;

public class Event {

    private Integer id;
    private String name;
    private String date;
    private String location;
    private Integer userId;

    public Event(Integer id, String name, String date, String location, Integer userId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
