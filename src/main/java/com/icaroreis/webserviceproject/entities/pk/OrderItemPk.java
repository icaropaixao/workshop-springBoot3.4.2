package com.icaroreis.webserviceproject.entities.pk;

import com.icaroreis.webserviceproject.entities.Order;
import com.icaroreis.webserviceproject.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

// CLASSE AUXILIAR entre pedido e produto

@Embeddable // anotação para classes desse tipo
public class OrderItemPk  implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // Gets sets
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPk that = (OrderItemPk) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }
    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
