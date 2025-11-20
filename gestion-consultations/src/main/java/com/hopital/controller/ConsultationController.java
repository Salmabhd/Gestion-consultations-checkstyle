package main.java.com.hopital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.hopital.dto.RendezVousRequestDto;
import main.java.com.hopital.model.RendezVous;
import main.java.com.hopital.service.ConsultationService;

@RestController
@RequestMapping("/api")
public class ConsultationController {

    private static final int MAX_SIZE = 100;

    @Autowired
    private ConsultationService consultationService;

    /**
     * Créer un rendez-vous médical.
     *
     * @param request DTO contenant les informations du rendez-vous
     * @return rendez-vous créé
     */
    @PostMapping("/rendezvous")
    public RendezVous creerRendezVous(@RequestBody RendezVousRequestDto request) {
        return consultationService.creerRendezVous(request);
    }

    /**
     * Retourne les rendez-vous d'un médecin.
     *
     * @param id identifiant du médecin
     * @return liste des rendez-vous
     */
    @GetMapping("/medecin/{id}/rendezvous")
    public List<RendezVous> getRendezVousByMedecin(@PathVariable Long id) {
        return consultationService.getRendezVousByMedecin(id);
    }
}
