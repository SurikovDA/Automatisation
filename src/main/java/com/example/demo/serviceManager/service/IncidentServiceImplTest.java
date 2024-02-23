package com.example.demo.serviceManager.service;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Тестовая имплементация интерфейса бизнес-логики
 * , для обращения к service manager
 */

@Service
public class IncidentServiceImplTest implements IncidentService {

    //Сервис создание инцидента
    public String createIncident(String nameTeam) {
        Random random = new Random();
        Integer numberIncident = random.nextInt();
        return "инцидент IM02" + numberIncident + " на команду " + nameTeam + " создан";
    }

    //Сервис удаление инцидента
    public String deleteIncident(String incidentId) {
        return "инцидент " + incidentId + " удален";
    }
}
