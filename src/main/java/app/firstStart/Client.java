package app.firstStart;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class Client {

    private int id;
    private String name;
    @Value("#{'${my.list.of.strings}'.split(',')}")
    private List<String> friends;

    public Client(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
