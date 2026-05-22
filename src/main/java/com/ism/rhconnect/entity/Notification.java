package com.ism.rhconnect.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long utilisateurId;

    @Column(nullable = false, length = 500)
    private String message;

    @Column(nullable = false)
    private Boolean lue = false;

    @Column(nullable = false)
    private LocalDateTime dateEnvoi = LocalDateTime.now();

    // Constructeurs
    public Notification() {}

    public Notification(Long utilisateurId, String message) {
        this.utilisateurId = utilisateurId;
        this.message = message;
        this.lue = false;
        this.dateEnvoi = LocalDateTime.now();
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUtilisateurId() { return utilisateurId; }
    public void setUtilisateurId(Long utilisateurId) { this.utilisateurId = utilisateurId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Boolean getLue() { return lue; }
    public void setLue(Boolean lue) { this.lue = lue; }

    public LocalDateTime getDateEnvoi() { return dateEnvoi; }
    public void setDateEnvoi(LocalDateTime dateEnvoi) { this.dateEnvoi = dateEnvoi; }
}