package com.alex.payment.backend.model;

import javax.persistence.*;

@Entity
public class Transaction extends BaseEntity {
    private Double money;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reciever_id", nullable = false)
    private User receiver;
}
