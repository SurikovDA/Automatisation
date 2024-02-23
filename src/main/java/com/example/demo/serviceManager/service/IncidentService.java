package com.example.demo.serviceManager.service;

/**
 * Интерфейс бизнес-логики для обращения к
 * Service Manager
 */

public interface IncidentService {
    //Метод создания инцидента
    String createIncident(String nameTeam);

    //Метод удаления инцидента
    String deleteIncident(String numberIncident);
}
