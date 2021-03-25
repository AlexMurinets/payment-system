package com.alex.payment.backend.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Double money;

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Transaction> sentTransactions;

    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Transaction> receivedTransactions;
}
