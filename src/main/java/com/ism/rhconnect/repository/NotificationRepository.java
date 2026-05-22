package com.ism.rhconnect.repository;

import com.ism.rhconnect.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Récupérer toutes les notifications d'un utilisateur
    List<Notification> findByUtilisateurIdOrderByDateEnvoiDesc(Long utilisateurId);

    // Récupérer les notifications non lues d'un utilisateur
    List<Notification> findByUtilisateurIdAndLueFalseOrderByDateEnvoiDesc(Long utilisateurId);

    // Compter les notifications non lues (pour le badge)
    Long countByUtilisateurIdAndLueFalse(Long utilisateurId);
}