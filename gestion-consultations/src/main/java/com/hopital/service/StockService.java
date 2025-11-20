package main.java.com.hopital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hopital.model.Medicament;
import com.hopital.repository.MedicamentRepository;

@Service
public class StockService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    /**
     * Vérifie si le stock du médicament est suffisant.
     * 
     * @param medicamentId L'identifiant du médicament
     * @param quantite Quantité demandée
     * @return true si le stock est suffisant, false sinon
     */
    public boolean verifierStock(Long medicamentId, int quantite)
    {
        if (medicamentId == null || quantite <= 0)
        {
            return false;
        }

        Medicament medicament = medicamentRepository.findById(medicamentId).orElse(null);
        if (medicament == null)
        {
            return false;
        }

        return medicament.getStockActuel() >= quantite;
    }
}
