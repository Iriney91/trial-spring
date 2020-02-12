package ru.itfb.trial.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String login;

    @Column
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Client_Product",
            joinColumns = @JoinColumn(name = "Clint_Id", referencedColumnName = "Id"),
            inverseJoinColumns = @JoinColumn(name = "Product_Id", referencedColumnName = "Id")
    )
    private Set<Product> products = new HashSet<>();
}
