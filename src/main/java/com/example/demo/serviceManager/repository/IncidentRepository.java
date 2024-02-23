package com.example.demo.serviceManager.repository;

import org.springframework.stereotype.Repository;

/**
 * Интерфейс прямого обращения к
 * Service Manager
 */
@Repository
public interface IncidentRepository {
    String createIncident();

    String deleteIncident();
}
