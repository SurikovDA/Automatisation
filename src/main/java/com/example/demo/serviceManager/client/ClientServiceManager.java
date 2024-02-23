package com.example.demo.serviceManager.client;

import com.example.demo.serviceManager.model.Incident;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Клиент для обращения к ServiceManager
 */
@Service
@Slf4j
public class ClientServiceManager {
    String absloluteUrl = "адрес, на который отправляем запрос";
    String baseUrl = "http://localhost:8080";

    private final RestTemplate restTemplate = new RestTemplate();
    private String absoluteUrl;
    //Создание и настройка клиента для обращения к ServiceManager
    private final WebClient clientServiceManager = WebClient.builder()
            .baseUrl(baseUrl)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    /*
    //Отправка запроса с получением инцидента, надо редачить
    public Incident responseServiceManager() {
        ResponseEntity<Incident> incidentResponseEntity = restTemplate.exchange(
                absloluteUrl + "/запрос",
                HttpMethod.POST,
                null,
                new ParameterizedTypeReference<>() {
                });
        return incidentResponseEntity.getBody();
    }

    //Отправка запроса с получением инцидента, надо редачить
    public Mono<Incident> responseServiceManager1() {
        Mono<Incident> incidentResponseEntity = clientServiceManager
                .get()
                .uri(absloluteUrl + "/запрос")
                .retrieve()
                .bodyToMono(Incident.class);
        return incidentResponseEntity;
    }*/


    //Отправка GET запроса на сервер
    public String responseServiceManager(String uri) {
        log.info("Получен запрос responseServiceManager");
        return restTemplate.getForObject(
                baseUrl + uri,
                String.class);
    }

    //Отправка PUT запроса на сервер
    public void putResponseServiceManager(String uri) {
        log.info("Получен запрос PUT responseServiceManager");
        restTemplate.put(
                baseUrl + uri,
                String.class);
    }
}
