package controller;

import database.Client;
import database.Database;
import gui.FormEvent;

public class Controller {

    private Database database;
    private Client client;

    public Controller() {
        database = new Database();
    }

    public void setClient(FormEvent event) {

        client = new Client(event.getName(), event.getLastName(),
                event.getPhone(), event.getPassword(), event.getProduct(),
                event.getPrice(), event.getAmount(), event.getTotal(),
                event.getPayment(), event.getDebt(), event.getNoDebt(),
                event.getYear(), event.getMonth(), event.getDay());

        database.loadFromFile(client);

    }
}
