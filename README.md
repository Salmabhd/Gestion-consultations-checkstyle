# Gestion-consultations-checkstyle
# GestionConsultations – Analyse Statique & Qualité de Code avec Checkstyle  
Atelier QL 04 – Qualité Logicielle

## Description du Projet
Ce projet consiste à analyser et améliorer la qualité du code d’une application médicale **GestionConsultations**, à l’aide de l’outil d’analyse statique **Checkstyle** intégré dans un projet **Maven**.

L’objectif est d’identifier, comprendre et corriger différentes violations de style, de structure, de complexité et de conventions de nommage dans le code.

---

##  Structure du Projet
gestion-consultations/
├── src/
│ └── main/
│ └── java/
│ └── com/hopital/
│ ├── controller/
│ ├── service/
│ ├── repository/
│ ├── entity/
│ └── config/
├── resources/
├── checkstyle.xml
└── pom.xml


---

## Configuration Maven – Checkstyle

Le fichier `pom.xml` inclut le plugin Maven Checkstyle permettant :

- l’analyse automatique lors de la phase **validate**
- l'arrêt du build en cas d’erreurs (`failsOnError=true`)
- la génération d’un rapport HTML

---

## Configuration Checkstyle Personnalisée

Le fichier `checkstyle.xml` contient des règles liées à :

### Conventions de nommage  
- Variables locales  
- Constantes  
- Méthodes  

### Structure du code  
- Accolades  
- Espacement  
- Longueur des lignes  
- Longueur des fichiers  

### Importations  
- Imports non utilisés  
- Imports redondants  
- Interdiction des `*`  

### Complexité  
- Méthodes > 50 lignes  
- Complexité cyclomatique < 10  
- Nombre max de paramètres (5)  

### Javadoc  
- Documentation obligatoire des méthodes publiques  

---

##  Étape 3 : Code à Analyser

Le projet inclut volontairement des classes Java comportant des violations Checkstyle afin d’effectuer :

- l’analyse initiale
- la correction du code
- la comparaison avant / après

Exemples de violations :
- mauvaise convention de nommage (`MAX_SIZE`)
- trop de paramètres dans un endpoint
- méthode longue et complexe
- magic numbers
- complexité cyclomatique trop élevée
- absence de javadoc

---


