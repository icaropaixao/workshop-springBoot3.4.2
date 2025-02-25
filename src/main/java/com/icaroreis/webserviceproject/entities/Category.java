package com.icaroreis.webserviceproject.entities;

// jakarta imports
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category  implements Serializable {
    private static final long serialVersionUID = 1L;

    // basic attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // associação entre produto e categoria
    @JsonIgnore
    @ManyToMany(mappedBy = "categories") // nome da variavel mapeada da classe Produtc
    private Set<Product> products = new HashSet<>();

    // Constructors
    public Category() {}
    public Category(Long id,String name) {
        this.name = name;
        this.id = id;
    }

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    // hashCode & equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }



}
