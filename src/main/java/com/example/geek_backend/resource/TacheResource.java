package com.example.geek_backend.resource;

import com.example.geek_backend.domain.HttpResponse;
import com.example.geek_backend.domain.Tache;
import com.example.geek_backend.service.TacheService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.time.LocalTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestController
@RequestMapping(path = "/tache")
@RequiredArgsConstructor
public class TacheResource {
    private final TacheService tacheService;

    @GetMapping("/list")
    public ResponseEntity<HttpResponse> getTaches(@RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("page", tacheService.getTaches(page.orElse(0), size.orElse(8))))
                        .message("Taches retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @PostMapping("/create")
    public ResponseEntity<HttpResponse> createTache(@RequestBody Tache tache) {
        Tache newTache = tacheService.createTache(tache);
        return ResponseEntity.created(URI.create(""))
                .body(
                        HttpResponse.builder()
                                .timeStamp(now().toString())
                                .data(of("tache", newTache))
                                .message("Tache '" + newTache.getNom() + "' created")
                                .status(CREATED)
                                .statusCode(CREATED.value())
                                .build());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<HttpResponse> getTache(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("tache", tacheService.getTache(id)))
                        .message("Tache retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @GetMapping("/search")
    public ResponseEntity<HttpResponse> searchTache(Optional<String> nom, @RequestParam Optional<Integer> page, @RequestParam Optional<Integer> size) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("page", tacheService.searchTaches(nom.orElse(""), page.orElse(0), size.orElse(8))))
                        .message("Taches retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @PutMapping("/update")
    public ResponseEntity<HttpResponse> updateTache(@RequestBody Tache tache) {
        return ResponseEntity.ok(
                HttpResponse.builder()
                        .timeStamp(now().toString())
                        .data(of("tache", tacheService.updateTache(tache)))
                        .message("Tache updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteTache(@PathVariable Long id) {
        try {
            tacheService.deleteTache(id);
            return ResponseEntity.ok(
                    HttpResponse.builder()
                            .timeStamp(now().toString())
                            .message("Tache supprimer avec succes.")
                            .status(OK)
                            .statusCode(OK.value())
                            .build());
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND)
                    .body(HttpResponse.builder()
                            .timeStamp(now().toString())
                            .message("Tache Introuvable")
                            .status(NOT_FOUND)
                            .statusCode(NOT_FOUND.value())
                            .build());
        }
    }

    @PostMapping("/sync")
    public ResponseEntity<HttpResponse> syncTaches(@RequestBody List<Tache> taches) {
        try {
            List<Tache> syncedTaches = tacheService.syncTaches(taches);
            return ResponseEntity.ok(HttpResponse.builder()
                    .timeStamp(LocalTime.now().toString())
                    .data(Map.of("taches", syncedTaches))
                    .message("Taches synchronized successfully")
                    .status(OK)
                    .statusCode(OK.value())
                    .build());
        } catch (Exception e) {
            log.error("Error syncing taches", e);
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(HttpResponse.builder()
                            .timeStamp(LocalTime.now().toString())
                            .message("Error syncing taches")
                            .status(INTERNAL_SERVER_ERROR)
                            .statusCode(INTERNAL_SERVER_ERROR.value())
                            .build());
        }
    }

    @GetMapping("/status")
    public String getStatus() {
        // Retourner une simple réponse pour indiquer que le serveur est en ligne
        return "Server is online";
    }

}
