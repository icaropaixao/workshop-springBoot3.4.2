package com.icaroreis.webserviceproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.icaroreis.webserviceproject.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone = "GMT") // formato da data
    private Instant moment; // classe que representa data e hora

    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client; // associação: 1 pedido tem -> 1 cliente

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    // associação entre Order e Payment
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL) // mapeando as duas entidades para ter o mesmo ID
    private Payment payment;

    // constructors
    public Order() {
    }
    public Order(Long id, Instant moment,OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus); // jeito de implementar no construtor sem modificar o tipo
        this.client = client;
    }

    // gets sets
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Instant getMoment() {
        return moment;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valorDoCodigo(orderStatus);
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }

    }

    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    public Payment getPayment() {
        return payment;
    }
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Set<OrderItem> getItems() {
        return items;
    }



    // hash and equals
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
