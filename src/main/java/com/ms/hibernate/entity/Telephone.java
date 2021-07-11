package com.ms.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "telephone")
public class Telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int telephoneId;

    @Column(name = "telnumber")
    int telephoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Telephone() {
    }

    public Telephone(int telephoneId, int telephoneNumber) {
        this.telephoneId = telephoneId;
        this.telephoneNumber = telephoneNumber;
    }

    public int getTelephoneId() {
        return telephoneId;
    }

    public void setTelephoneId(int telephoneId) {
        this.telephoneId = telephoneId;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "telephoneId=" + telephoneId +
                ", telephoneNumber=" + telephoneNumber +
                '}';
    }
}
