package com.example.demo.serviceManager.controller;

import com.example.demo.serviceManager.client.ClientServiceManager;
import com.example.demo.serviceManager.service.IncidentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Контроллер для обращения к
 * service manager
 */

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/incident")
public class IncidentController {
    private final IncidentService incidentService;
    private final ClientServiceManager clientServiceManager;

    //Создание инцидента
    @GetMapping("/create/{nameTeam}")
    @ResponseStatus(HttpStatus.CREATED)
    public String createIncident(@PathVariable String nameTeam) {
        log.info("Получен запрос POST /incident/create/{}", nameTeam);
        return incidentService.createIncident(nameTeam);
    }

    //Удаление инцидента
    @GetMapping("/delete/{incidentId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteIncident(@PathVariable String incidentId) {
        log.info("Получен запрос DELETE /incident/delete/{}", incidentId);
        return incidentService.deleteIncident(incidentId);
    }

    //тестовый метод
    @GetMapping("/create/test/{nameTeam}")
    @ResponseStatus(HttpStatus.OK)
    public String testIncident(@PathVariable String nameTeam) {
        log.info("Получен запрос GET /incident/create/test/{}", nameTeam);
        return clientServiceManager.responseServiceManager("/incident/create/" + nameTeam);
    }
}
