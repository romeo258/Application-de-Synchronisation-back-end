package com.example.geek_backend.service.implementation;

import com.example.geek_backend.domain.Tache;
import com.example.geek_backend.repository.TacheRepository;
import com.example.geek_backend.service.TacheService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.PageRequest.of;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TacheServiceImpl implements TacheService {
    private final TacheRepository tacheRepository;
    @Override
    public Tache createTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Tache updateTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Page<Tache> getTaches(int page, int size) {
        return tacheRepository.findAll(of(page, size));
    }

    @Override
    public Iterable<Tache> getTaches() {
        return tacheRepository.findAll();
    }

    @Override
    public Tache getTache(Long id) {
        return tacheRepository.findById(id).get();
    }

    @Override
    public void deleteTache(Long id) {
        // Vérifie d'abord si le fournisseur existe
        if (!tacheRepository.existsById(id)) {
            throw new EntityNotFoundException("la tache numero: " + id + "introuvable");
        }
        // Supprime le fournisseur
        tacheRepository.deleteById(id);
    }

    @Override
    public Page<Tache> searchTaches(String nom, int page, int size) {
        return tacheRepository.findByNomContaining(nom, of(page, size));
    }

    public List<Tache> syncTaches(List<Tache> taches) {
        return tacheRepository.saveAll(taches);
    }
}
