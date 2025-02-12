package com.icaroreis.webserviceproject.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Instant moment; // classe que representa data e hora

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client; // associação: 1 pedido tem -> 1 cliente

    public Order() {
    }
    public Order(long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Instant getMoment() {
        return moment;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
