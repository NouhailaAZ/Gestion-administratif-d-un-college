# Gestion Administrative d'un Collège 🏫

## 📋 Description du projet

Application Java desktop pour la **gestion administrative d'un collège**, permettant l'informatisation de l'affectation hebdomadaire des salles et la gestion des absences des élèves. Ce système offre une solution complète pour optimiser la gestion quotidienne d'un établissement scolaire.

### Objectifs principaux
- 📅 **Affectation hebdomadaire des salles** de cours
- 📊 **Gestion des absences** des élèves
- 👥 **Administration des utilisateurs** (élèves, enseignants, classes)
- 🏢 **Gestion des ressources** (salles, matériels)

## 🎯 Fonctionnalités

### 🔐 Authentification
- Système de login sécurisé
- Contrôle d'accès à l'application

### 🏫 Gestion des Salles
- ➕ Ajouter une nouvelle salle
- 🗑️ Supprimer une salle
- 📋 Afficher toutes les salles
- 🔍 Rechercher une salle disponible
- 📅 Consulter l'emploi du temps d'une salle
- 📊 Affectation hebdomadaire des salles

### 👨‍🎓 Gestion des Classes
- 📋 Afficher les élèves d'une classe
- 📅 Consulter l'emploi du temps d'une classe

### 👨‍🏫 Gestion des Enseignants
- ➕ Ajouter un nouvel enseignant
- 🗑️ Supprimer un enseignant
- 📋 Afficher tous les enseignants
- 📅 Consulter l'emploi du temps d'un enseignant

### 👨‍🎓 Gestion des Élèves
- ➕ Ajouter un nouvel élève
- ✏️ Modifier les informations d'un élève
- 🔍 Rechercher un élève par numéro
- 🗑️ Supprimer un élève

### 📊 Gestion des Absences
- ➕ Marquer un élève absent
- 📋 Afficher les élèves absents
- 📄 Créer une feuille de présence
- 📈 Suivi des absences par classe et par jour

## 🏗️ Architecture du système

### 🗄️ Base de données

#### Tables principales

| Table | Description |
|-------|-------------|
| `anneescolaire` | Gestion des années scolaires |
| `eleve` | Informations des élèves |
| `classe` | Données des classes |
| `enseignant` | Informations des enseignants |
| `materiels` | Équipements des salles |
| `salle` | Caractéristiques des salles |
| `cour` | Planification des cours |
| `viescolaire` | Gestion de la vie scolaire |
| `feuille_presence` | Suivi des présences |

## 🛠️ Technologies utilisées

- **Langage** : Java
- **Interface** : Java Swing
- **Base de données** : MySQL
- **IDE** : Eclipse
- **Modélisation** : UML

## 🚀 Installation et utilisation

### Prérequis
- Java JDK 8 ou supérieur
- Serveur de base de données (MySQL/SQL Server)
- IDE Java (optionnel pour le développement)

### Configuration

#### 1. Cloner le repository
```bash
git clone https://github.com/NouhailaAZ/Gestion-administratif-d-un-college.git
cd Gestion-administratif-d-un-college
```

#### 2. Configuration de la base de données
```sql
-- Créer la base de données
CREATE DATABASE college_management;

-- Importer le schéma depuis le fichier SQL fourni
SOURCE database/schema.sql;
```

#### 3. Configuration de la connexion
Modifier le fichier de configuration de connexion à la base de données :
```java
// ConnexionSql.java
conn = DriverManager.getConnection("jdbc:mysql://localhost/college_management","your_username","your_password");

```

#### 4. Compilation et exécution


## 📱 Interface utilisateur

### Fenêtres principales

1. **🔐 Authentification**
2. **🏠 Accueil**
3. **🏫 Gestion des Salles**
4. **👨‍🎓 Gestion des Classes**
5. **👨‍🎓 Gestion des Elèves**
6. **👨‍🏫 Gestion des Enseignants**
7. **📊 Suivi des Absences**


## 👥 Équipe de développement

- **FAKHAM Chaimaa** - Développeuse
- **LAHRECH Ilham** - Développeuse
- **AZLAG Nouhaila** - Développeuse  

*Université Hassan 1er - Faculté des Sciences et Techniques de Settat*

## 🚀 Fonctionnalités futures

- 📧 **Notifications** automatiques aux parents
- 🌐 **Interface web** complémentaire
- 📱 **Application mobile** pour les parents
- 📊 **Rapports PDF** automatisés


*Projet réalisé dans le cadre des études en Génie Informatique - Université Hassan 1er*
