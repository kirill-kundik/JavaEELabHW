package app;

public class Account {

    private Client client;

    public Account(Client client) {
        this.client = client;
    }

    public String getInfo() {
        return "This is account for " + client.getName();
    }

}
