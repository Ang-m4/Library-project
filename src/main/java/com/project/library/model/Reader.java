package com.project.library.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "readers")
public class Reader{

    @Id
    @GeneratedValue
    @NotBlank
    @Column(name = "reader_id")
    private Long id;
    @NotBlank
    @Column(name = "reader_name")
    private String name;
    @NotBlank
    @Column(name = "reader_lastname")
    private String lastname;
    @NotBlank
    @Column(name = "reader_password")
    private String password;

    @Column(name = "reader_blocked")
    private boolean blocked;

    @JsonIgnore
    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL)
    private List<Order> orders;
    
    @JsonIgnore
    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    public Reader() {
        this.orders = new ArrayList<>();
        this.subscriptions = new ArrayList<>();
        
    }

    public Reader(long id, String name, String lastname, String password, boolean state, List<Order> orders, List<Subscription> subscriptions) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.blocked = state;
        this.orders = orders;
        this.subscriptions = subscriptions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    
    

}
