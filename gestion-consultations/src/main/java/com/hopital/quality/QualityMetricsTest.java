package main.java.com.hopital.quality;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class QualityMetricsTest {

    // Déclaration des constantes pour remplacer les magic numbers
    private static final int MAX_CYCLOMATIC_COMPLEXITY = 10;
    private static final int MAINTAINABILITY_THRESHOLD = 60;
    private static final int SIMULATED_COMPLEXITY = 7;
    private static final double SIMULATED_MAINTAINABILITY = 72.5;

    @Test
    public void testComplexiteCyclomatique()
    {
        int complexite = simulateCyclomaticComplexity("ConsultationController");
        assertTrue(complexite < MAX_CYCLOMATIC_COMPLEXITY,
                   "La complexité doit être < " + MAX_CYCLOMATIC_COMPLEXITY);
    }

    @Test
    public void testMaintenabilite()
    {
        double maintainability = simulateMaintainabilityIndex();
        assertTrue(maintainability > MAINTAINABILITY_THRESHOLD,
                   "Le score de maintenabilité doit être > " + MAINTAINABILITY_THRESHOLD);
    }

    // Méthode simulée pour l'exercice
    private int simulateCyclomaticComplexity(String className)
    {
        return SIMULATED_COMPLEXITY;
    }

    // Méthode simulée pour l'exercice
    private double simulateMaintainabilityIndex()
    {
        return SIMULATED_MAINTAINABILITY;
    }
}
