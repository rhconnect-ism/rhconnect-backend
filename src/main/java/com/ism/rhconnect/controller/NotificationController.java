package com.ism.rhconnect.controller;

import com.ism.rhconnect.entity.Notification;
import com.ism.rhconnect.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "http://localhost:3000")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // GET /api/notifications/{utilisateurId}
    // Récupérer toutes les notifications d'un utilisateur
    @GetMapping("/{utilisateurId}")
    public ResponseEntity<List<Notification>> getNotifications(
            @PathVariable Long utilisateurId) {
        return ResponseEntity.ok(
            notificationService.getNotifications(utilisateurId)
        );
    }

    // GET /api/notifications/{utilisateurId}/non-lues
    // Récupérer les notifications non lues
    @GetMapping("/{utilisateurId}/non-lues")
    public ResponseEntity<List<Notification>> getNotificationsNonLues(
            @PathVariable Long utilisateurId) {
        return ResponseEntity.ok(
            notificationService.getNotificationsNonLues(utilisateurId)
        );
    }

    // GET /api/notifications/{utilisateurId}/compteur
    // Compter les non lues (badge)
    @GetMapping("/{utilisateurId}/compteur")
    public ResponseEntity<Long> compterNonLues(
            @PathVariable Long utilisateurId) {
        return ResponseEntity.ok(
            notificationService.compterNonLues(utilisateurId)
        );
    }

    // PUT /api/notifications/{id}/lue
    // Marquer une notification comme lue
    @PutMapping("/{id}/lue")
    public ResponseEntity<Notification> marquerCommeLue(
            @PathVariable Long id) {
        return ResponseEntity.ok(
            notificationService.marquerCommeLue(id)
        );
    }

    // PUT /api/notifications/{utilisateurId}/toutes-lues
    // Marquer toutes les notifications comme lues
    @PutMapping("/{utilisateurId}/toutes-lues")
    public ResponseEntity<Void> marquerToutesCommeLues(
            @PathVariable Long utilisateurId) {
        notificationService.marquerToutesCommeLues(utilisateurId);
        return ResponseEntity.ok().build();
    }
}