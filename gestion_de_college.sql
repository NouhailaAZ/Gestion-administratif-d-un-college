-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 05 juin 2022 à 20:35
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion de college`
--

-- --------------------------------------------------------

--
-- Structure de la table `annéescolaire`
--

CREATE TABLE `annéescolaire` (
  `Année` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `annéescolaire`
--

INSERT INTO `annéescolaire` (`Année`) VALUES
('2021/2022'),
('2022/2023');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `Id_classe` int(11) NOT NULL,
  `niveau` varchar(20) NOT NULL,
  `classe` varchar(5) NOT NULL,
  `nombre_élève` int(11) NOT NULL,
  `Année` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Structure de la table `cour`
--

CREATE TABLE `cour` (
  `id_cour` int(11) NOT NULL,
  `nom_cour` varchar(20) NOT NULL,
  `jour` varchar(10) NOT NULL,
  `heureDébut` time NOT NULL,
  `heureFin` time NOT NULL,
  `id_classe` int(11) NOT NULL,
  `id_enseignant` int(11) NOT NULL,
  `NumSalle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `id_enseignant` int(11) NOT NULL,
  `CIN` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prénom` varchar(20) NOT NULL,
  `DateNaissance` date NOT NULL,
  `email` varchar(30) NOT NULL,
  `téléphone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Structure de la table `feuille_présence`
--

CREATE TABLE `feuille_présence` (
  `id_feuille` int(11) NOT NULL,
  `Année` varchar(11) NOT NULL,
  `numSemaine` int(11) NOT NULL,
  `jour` varchar(10) NOT NULL,
  `nmbAbsence` int(11) NOT NULL,
  `idclasse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Structure de la table `matériels`
--

CREATE TABLE `matériels` (
  `matricule` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `NumSalle` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `matériels`
--

INSERT INTO `matériels` (`matricule`, `nom`, `NumSalle`) VALUES
(1, 'rideaux noirs', 2),
(2, 'projecteurs vidéo', 2),
(3, 'rideaux noirs', 5),
(4, 'projecteurs vidéo', 5),
(5, 'rétro projecteurs', 4),
(6, 'écrans', 5),
(7, 'triples tableaux', 8),
(8, 'projecteurs vidéo', 6),
(9, 'ordinateurs', 16),
(10, 'ordinateurs', 17),
(11, 'pissette', 6),
(12, 'projecteurs vidéo', 6),
(13, 'projecteurs vidéo', 7),
(14, 'Balles', 3),
(15, 'Tapit de chute', 3),
(16, 'ordinateurs', 18),
(17, 'projecteurs vidéo', 18),
(18, 'agitateur magnétique', 6);

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `NumSalle` int(11) NOT NULL,
  `type` varchar(30) NOT NULL,
  `capacité` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`NumSalle`, `type`, `capacité`) VALUES
(1, 'cour', 40),
(2, 'cour', 40),
(3, 'sport', 150),
(4, 'cour', 40),
(5, 'cour', 45),
(6, 'laboratoire1', 45),
(7, 'laboratoire2', 35),
(8, 'cour', 35),
(9, 'cour', 45),
(10, 'cour', 35),
(11, 'cour', 45),
(12, 'cour', 35),
(13, 'cour', 45),
(14, 'cour', 35),
(15, 'cour', 35),
(16, 'Salle informatique1', 20),
(17, 'Salle informatique2', 20),
(18, 'Salle informatique3', 20),
(19, 'cour', 45),
(20, 'cour', 45);

-- --------------------------------------------------------

--
-- Structure de la table `viescolaire`
--

CREATE TABLE `viescolaire` (
  `id_feuille` int(11) NOT NULL,
  `id_cour` int(11) NOT NULL,
  `numéro_élève` int(11) NOT NULL,
  `justification` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Structure de la table `élève`
--

CREATE TABLE `élève` (
  `numéro_élève` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prénom` varchar(20) NOT NULL,
  `date_naissance` date NOT NULL,
  `id_classe` int(11) NOT NULL,
  `date_inscription` date NOT NULL,
  `téléphone_père` varchar(20) NOT NULL,
  `téléphone_mère` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annéescolaire`
--
ALTER TABLE `annéescolaire`
  ADD PRIMARY KEY (`Année`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`Id_classe`),
  ADD KEY `Année` (`Année`);

--
-- Index pour la table `cour`
--
ALTER TABLE `cour`
  ADD PRIMARY KEY (`id_cour`),
  ADD KEY `id_enseignant` (`id_enseignant`),
  ADD KEY `id_classe` (`id_classe`),
  ADD KEY `NumSalle` (`NumSalle`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`id_enseignant`);

--
-- Index pour la table `feuille_présence`
--
ALTER TABLE `feuille_présence`
  ADD PRIMARY KEY (`id_feuille`),
  ADD KEY `Année` (`Année`);

--
-- Index pour la table `matériels`
--
ALTER TABLE `matériels`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `NumSalle` (`NumSalle`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`NumSalle`);

--
-- Index pour la table `viescolaire`
--
ALTER TABLE `viescolaire`
  ADD PRIMARY KEY (`id_feuille`,`id_cour`,`numéro_élève`),
  ADD KEY `id_cour` (`id_cour`),
  ADD KEY `numéro_élève` (`numéro_élève`);

--
-- Index pour la table `élève`
--
ALTER TABLE `élève`
  ADD PRIMARY KEY (`numéro_élève`),
  ADD KEY `id_classe` (`id_classe`) USING BTREE;

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cour`
--
ALTER TABLE `cour`
  MODIFY `id_cour` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=170;

--
-- AUTO_INCREMENT pour la table `enseignant`
--
ALTER TABLE `enseignant`
  MODIFY `id_enseignant` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT pour la table `feuille_présence`
--
ALTER TABLE `feuille_présence`
  MODIFY `id_feuille` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `NumSalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT pour la table `élève`
--
ALTER TABLE `élève`
  MODIFY `numéro_élève` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=286;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `classe_ibfk_2` FOREIGN KEY (`Année`) REFERENCES `annéescolaire` (`Année`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `cour`
--
ALTER TABLE `cour`
  ADD CONSTRAINT `cour_ibfk_1` FOREIGN KEY (`id_enseignant`) REFERENCES `enseignant` (`id_enseignant`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cour_ibfk_2` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`Id_classe`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cour_ibfk_3` FOREIGN KEY (`NumSalle`) REFERENCES `salle` (`NumSalle`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `feuille_présence`
--
ALTER TABLE `feuille_présence`
  ADD CONSTRAINT `feuille_présence_ibfk_1` FOREIGN KEY (`Année`) REFERENCES `annéescolaire` (`Année`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `matériels`
--
ALTER TABLE `matériels`
  ADD CONSTRAINT `matériels_ibfk_1` FOREIGN KEY (`NumSalle`) REFERENCES `salle` (`NumSalle`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `viescolaire`
--
ALTER TABLE `viescolaire`
  ADD CONSTRAINT `viescolaire_ibfk_1` FOREIGN KEY (`id_cour`) REFERENCES `cour` (`id_cour`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `viescolaire_ibfk_2` FOREIGN KEY (`id_feuille`) REFERENCES `feuille_présence` (`id_feuille`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `viescolaire_ibfk_3` FOREIGN KEY (`numéro_élève`) REFERENCES `élève` (`numéro_élève`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `élève`
--
ALTER TABLE `élève`
  ADD CONSTRAINT `élève_ibfk_1` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`Id_classe`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
