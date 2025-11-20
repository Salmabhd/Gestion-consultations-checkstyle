package main.java.com.hopital.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.hopital.dto.RendezVousRequestDto;
import com.hopital.model.Medecin;
import com.hopital.model.Patient;
import com.hopital.model.Salle;
import com.hopital.model.RendezVous;
import com.hopital.repository.PatientRepository;
import com.hopital.repository.MedecinRepository;
import com.hopital.repository.SalleRepository;
import com.hopital.repository.RendezVousRepository;

@Service
public class ConsultationService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    public RendezVous creerRendezVous(RendezVousRequestDto request) {

        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Patient non trouvé"));

        Medecin medecin = medecinRepository.findById(request.getMedecinId())
                .orElseThrow(() -> new IllegalArgumentException("Médecin non trouvé"));

        Salle salle = salleRepository.findById(request.getSalleId())
                .orElseThrow(() -> new IllegalArgumentException("Salle non trouvée"));

        RendezVous rdv = new RendezVous();
        rdv.setPatient(patient);
        rdv.setMedecin(medecin);
        rdv.setSalle(salle);
        rdv.setDateRdv(request.getDate());
        rdv.setHeureDebut(request.getHeureDebut());
        rdv.setHeureFin(request.getHeureFin());
        rdv.setMotifConsultation(request.getMotif());

        return rendezVousRepository.save(rdv);
    }

    public List<RendezVous> getRendezVousByMedecin(Long id) {
        return rendezVousRepository.findByMedecinIdAndStatut(id, "PLANIFIE");
    }
}
