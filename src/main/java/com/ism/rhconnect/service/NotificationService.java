package com.ism.rhconnect.service;

import com.ism.rhconnect.entity.Notification;
import com.ism.rhconnect.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    // Créer une nouvelle notification
    public Notification creerNotification(Long utilisateurId, String message) {
        Notification notification = new Notification(utilisateurId, message);
        return notificationRepository.save(notification);
    }

    // Récupérer toutes les notifications d'un utilisateur
    public List<Notification> getNotifications(Long utilisateurId) {
        return notificationRepository
            .findByUtilisateurIdOrderByDateEnvoiDesc(utilisateurId);
    }

    // Récupérer les notifications non lues
    public List<Notification> getNotificationsNonLues(Long utilisateurId) {
        return notificationRepository
            .findByUtilisateurIdAndLueFalseOrderByDateEnvoiDesc(utilisateurId);
    }

    // Compter les non lues (pour le badge)
    public Long compterNonLues(Long utilisateurId) {
        return notificationRepository
            .countByUtilisateurIdAndLueFalse(utilisateurId);
    }

    // Marquer une notification comme lue
    public Notification marquerCommeLue(Long id) {
        Notification notification = notificationRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Notification non trouvée"));
        notification.setLue(true);
        return notificationRepository.save(notification);
    }

    // Marquer toutes les notifications d'un utilisateur comme lues
    public void marquerToutesCommeLues(Long utilisateurId) {
        List<Notification> notifications = notificationRepository
            .findByUtilisateurIdAndLueFalseOrderByDateEnvoiDesc(utilisateurId);
        notifications.forEach(n -> n.setLue(true));
        notificationRepository.saveAll(notifications);
    }
}