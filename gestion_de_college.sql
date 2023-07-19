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
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`Id_classe`, `niveau`, `classe`, `nombre_élève`, `Année`) VALUES
(1, '3', '3/1', 30, '2021/2022'),
(2, '3', '3/2', 35, '2021/2022'),
(3, '3', '3/3', 40, '2021/2022'),
(4, '3', '3/4', 40, '2021/2022'),
(5, '4', '4/1', 35, '2021/2022'),
(6, '4', '4/2', 40, '2021/2022'),
(7, '4', '4/3', 40, '2021/2022'),
(8, '4', '4/4', 30, '2021/2022'),
(9, '5', '5/1', 36, '2021/2022'),
(10, '5', '5/2', 39, '2021/2022'),
(11, '5', '5/3', 40, '2021/2022'),
(12, '5', '5/4', 35, '2021/2022'),
(13, '6', '6/1', 39, '2021/2022'),
(14, '6', '6/2', 40, '2021/2022'),
(15, '6', '6/3', 31, '2021/2022'),
(16, '6', '6/4', 44, '2021/2022'),
(17, '6', '6/5', 44, '2021/2022'),
(18, '3', '3/1', 33, '2022/2023'),
(19, '3', '3/2', 40, '2022/2023'),
(20, '3', '3/3', 36, '2022/2023'),
(21, '3', '3/4', 44, '2022/2023'),
(22, '4', '4/1', 30, '2022/2023'),
(23, '4', '4/2', 37, '2022/2023'),
(24, '4', '4/3', 33, '2022/2023'),
(25, '4', '4/4', 39, '2022/2023');

-- --------------------------------------------------------

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
-- Déchargement des données de la table `cour`
--

INSERT INTO `cour` (`id_cour`, `nom_cour`, `jour`, `heureDébut`, `heureFin`, `id_classe`, `id_enseignant`, `NumSalle`) VALUES
(1, 'math1', 'lundi', '08:00:00', '09:50:00', 1, 19, 7),
(2, 'pc1', 'lundi', '10:00:00', '11:55:00', 1, 17, 15),
(3, 'Ar1', 'lundi', '16:00:00', '17:55:00', 1, 18, 12),
(4, 'svt1', 'mardi', '16:00:00', '17:55:00', 1, 18, 1),
(5, 'Fr1', 'mardi', '10:00:00', '11:55:00', 1, 11, 1),
(6, 'sport', 'mercredi', '10:00:00', '11:55:00', 1, 20, 3),
(7, 'ch1', 'jeudi', '10:00:00', '11:55:00', 1, 17, 15),
(8, 'EI1', 'jeudi', '14:00:00', '15:55:00', 1, 19, 15),
(9, 'GH1', 'vendredi', '08:00:00', '09:55:00', 1, 7, 15),
(10, 'info1', 'vendredi', '10:00:00', '11:55:00', 1, 13, 17),
(11, 'info', 'samedi', '10:00:00', '11:55:00', 2, 13, 17),
(12, 'CH1', 'lundi', '14:00:00', '15:55:00', 2, 7, 15),
(14, 'sport', 'mercredi', '10:00:00', '11:55:00', 2, 20, 3),
(15, 'Svt1', 'mercredi', '14:00:00', '15:55:00', 2, 18, 1),
(16, 'Ch1', 'jeudi', '14:00:00', '15:55:00', 2, 17, 1),
(17, 'Math1', 'jeudi', '10:00:00', '11:55:00', 2, 1, 1),
(18, 'Fr1', 'vendredi', '10:00:00', '11:55:00', 2, 11, 15),
(20, 'ang1', 'vendredi', '14:00:00', '15:00:00', 2, 2, 11),
(21, 'Ar1', 'samedi', '14:00:00', '15:00:00', 2, 18, 2),
(23, 'ang1', 'lundi', '14:00:00', '15:55:00', 3, 12, 12),
(24, 'Math1', 'mardi', '10:00:00', '11:55:00', 3, 9, 15),
(25, 'Fr1', 'mardi', '14:00:00', '15:55:00', 3, 11, 15),
(26, 'svt1', 'mardi', '16:00:00', '17:55:00', 3, 10, 12),
(27, 'pc1', 'samedi', '16:00:00', '17:55:00', 3, 17, 12),
(28, 'Ch1', 'jeudi', '08:00:00', '09:55:00', 3, 17, 15),
(29, 'sport', 'mercredi', '10:00:00', '11:55:00', 3, 20, 3),
(31, 'GH', 'vendredi', '10:00:00', '11:55:00', 3, 19, 12),
(33, 'EI1', 'lundi', '14:00:00', '15:55:00', 4, 19, 1),
(34, 'info1', 'lundi', '16:00:00', '17:55:00', 4, 17, 18),
(35, 'Ar1', 'mardi', '08:00:00', '09:55:00', 4, 18, 12),
(36, 'pc1', 'mardi', '14:00:00', '15:55:00', 4, 17, 12),
(37, 'Fr1', 'mercredi', '08:00:00', '09:55:00', 4, 11, 15),
(38, 'sport', 'mercredi', '10:00:00', '11:55:00', 4, 20, 3),
(40, 'Math1', 'jeudi', '16:00:00', '17:55:00', 4, 19, 15),
(41, 'Fr1', 'vendredi', '08:00:00', '09:55:00', 4, 13, 12),
(42, 'ang1', 'vendredi', '10:00:00', '11:55:00', 4, 2, 1),
(43, 'GH1', 'samedi', '08:00:00', '09:55:00', 4, 7, 1),
(44, 'Svt', 'samedi', '10:00:00', '11:55:00', 4, 18, 1),
(45, 'Svt2', 'lundi', '10:00:00', '11:55:00', 5, 18, 2),
(46, 'sport', 'lundi', '16:00:00', '17:55:00', 5, 25, 3),
(47, 'EI', 'mardi', '08:00:00', '09:55:00', 5, 19, 9),
(48, 'GH', 'mardi', '10:00:00', '11:55:00', 5, 3, 9),
(49, 'info', 'mardi', '14:00:00', '15:55:00', 5, 13, 16),
(50, 'filos1', 'mercredi', '14:00:00', '15:55:00', 5, 16, 20),
(51, 'ch2', 'mercredi', '16:00:00', '17:55:00', 5, 17, 2),
(52, 'pc2', 'jeudi', '08:00:00', '09:55:00', 5, 14, 20),
(53, 'Math2', 'jeudi', '10:00:00', '11:55:00', 5, 19, 20),
(54, 'Fr2', 'jeudi', '16:00:00', '17:55:00', 5, 13, 2),
(55, 'ang2', 'vendredi', '10:00:00', '15:55:00', 5, 5, 2),
(56, 'Ar2', 'vendredi', '14:00:00', '15:55:00', 5, 10, 20),
(57, 'Ar2', 'lundi', '14:00:00', '15:55:00', 6, 10, 20),
(58, 'ang2', 'mardi', '08:00:00', '09:55:00', 6, 2, 2),
(59, 'Fr2', 'mardi', '10:00:00', '11:55:00', 6, 13, 20),
(60, 'Math2', 'mardi', '16:00:00', '17:55:00', 6, 19, 20),
(61, 'pc2', 'mercredi', '10:00:00', '15:55:00', 6, 14, 9),
(62, 'ch2', 'mercredi', '14:00:00', '15:55:00', 6, 27, 6),
(63, 'svt2', 'jeudi', '08:00:00', '09:55:00', 6, 10, 6),
(64, 'sport', 'lundi', '16:00:00', '17:55:00', 6, 25, 3),
(65, 'EI', 'jeudi', '10:00:00', '11:55:00', 6, 19, 2),
(66, 'GH', 'jeudi', '14:00:00', '15:55:00', 6, 3, 2),
(68, 'filos2', 'vendredi', '16:00:00', '17:55:00', 6, 16, 20),
(69, 'filos2', 'lundi', '08:00:00', '09:55:00', 7, 16, 20),
(70, 'info2', 'lundi', '10:00:00', '11:55:00', 7, 13, 16),
(71, 'GH2', 'mardi', '10:00:00', '11:55:00', 7, 3, 2),
(72, 'sport', 'lundi', '16:00:00', '17:55:00', 7, 25, 3),
(73, 'EI2', 'mardi', '16:00:00', '17:55:00', 7, 19, 2),
(75, 'svt2', 'mercredi', '08:00:00', '09:55:00', 7, 10, 20),
(76, 'ch2', 'samedi', '14:00:00', '17:55:00', 7, 22, 20),
(77, 'pc2', 'mercredi', '16:00:00', '17:55:00', 7, 14, 20),
(78, 'Math2', 'jeudi', '08:00:00', '09:55:00', 7, 19, 9),
(79, 'Fr2', 'jeudi', '10:00:00', '11:55:00', 7, 8, 9),
(80, 'ang2', 'samedi', '08:00:00', '09:55:00', 7, 2, 9),
(81, 'Ar2', 'samedi', '10:00:00', '11:55:00', 7, 11, 9),
(85, 'Ch2', 'lundi', '08:00:00', '09:55:00', 8, 17, 9),
(86, 'pc2', 'lundi', '10:00:00', '11:55:00', 8, 14, 20),
(87, 'sport', 'lundi', '16:00:00', '17:55:00', 8, 25, 3),
(88, 'Math2', 'mardi', '14:00:00', '15:55:00', 8, 19, 2),
(89, 'Fr2', 'mercredi', '14:00:00', '15:55:00', 8, 13, 2),
(90, 'ang2', 'mercredi', '16:00:00', '17:55:00', 8, 13, 9),
(91, 'Ar2', 'jeudi', '08:00:00', '09:55:00', 8, 10, 2),
(92, 'svt2', 'jeudi', '10:00:00', '11:55:00', 8, 10, 6),
(94, 'EI2', 'vendredi', '08:00:00', '09:55:00', 8, 19, 2),
(95, 'GH2', 'vendredi', '10:00:00', '11:55:00', 8, 3, 20),
(96, 'info2', 'vendredi', '14:00:00', '17:55:00', 8, 13, 16),
(97, 'filos2', 'samedi', '10:00:00', '11:55:00', 8, 16, 2),
(98, 'Ch3', 'lundi', '08:00:00', '09:55:00', 9, 27, 19),
(99, 'pc3', 'lundi', '10:00:00', '11:55:00', 9, 27, 4),
(100, 'Ar3', 'samedi', '14:00:00', '15:55:00', 9, 26, 13),
(101, 'Math3', 'mardi', '14:00:00', '15:55:00', 9, 24, 10),
(102, 'Fr3', 'mercredi', '14:00:00', '15:55:00', 9, 23, 10),
(103, 'ang3', 'mercredi', '16:00:00', '17:55:00', 9, 23, 19),
(104, 'Ar3', 'jeudi', '08:00:00', '09:55:00', 8, 26, 10),
(105, 'svt3', 'jeudi', '10:00:00', '11:55:00', 9, 21, 7),
(106, 'EI3', 'vendredi', '08:00:00', '09:55:00', 9, 26, 10),
(107, 'GH3', 'vendredi', '10:00:00', '11:55:00', 9, 22, 4),
(108, 'info3', 'vendredi', '14:00:00', '17:55:00', 9, 15, 18),
(109, 'filos3', 'samedi', '10:00:00', '11:55:00', 9, 28, 10),
(110, 'filos3', 'lundi', '10:00:00', '11:55:00', 10, 28, 10),
(111, 'EI3', 'mardi', '08:00:00', '09:55:00', 10, 26, 10),
(112, 'GH3', 'mardi', '10:00:00', '11:55:00', 10, 22, 4),
(113, 'info3', 'mardi', '14:00:00', '17:55:00', 10, 15, 18),
(114, 'Ar3', 'mercredi', '08:00:00', '09:55:00', 10, 26, 10),
(115, 'svt3', 'mercredi', '10:00:00', '11:55:00', 10, 21, 7),
(117, 'ang3', 'jeudi', '16:00:00', '17:55:00', 10, 23, 19),
(118, 'Math3', 'vendredi', '14:00:00', '15:55:00', 10, 24, 10),
(119, 'Ch3', 'samedi', '08:00:00', '09:55:00', 10, 27, 19),
(120, 'pc3', 'samedi', '10:00:00', '11:55:00', 10, 27, 4),
(121, 'Ar3', 'samedi', '16:00:00', '17:55:00', 10, 26, 13),
(122, 'Fr3', 'lundi', '14:00:00', '15:55:00', 11, 23, 10),
(123, 'ang3', 'lundi', '16:00:00', '17:55:00', 11, 23, 19),
(125, 'svt3', 'mardi', '10:00:00', '11:55:00', 11, 21, 7),
(127, 'GH3', 'mercredi', '10:00:00', '11:55:00', 11, 22, 4),
(128, 'info3', 'mercredi', '14:00:00', '17:55:00', 11, 15, 18),
(129, 'Ch3', 'jeudi', '08:00:00', '09:55:00', 11, 27, 19),
(130, 'pc3', 'jeudi', '10:00:00', '11:55:00', 11, 27, 4),
(131, 'Ar3', 'jeudi', '16:00:00', '17:55:00', 11, 26, 13),
(132, 'filos3', 'vendredi', '10:00:00', '11:55:00', 11, 28, 10),
(133, 'Math3', 'samedi', '14:00:00', '15:55:00', 11, 24, 10),
(134, 'Ar3', 'lundi', '08:00:00', '09:55:00', 12, 26, 10),
(135, 'svt3', 'lundi', '10:00:00', '11:55:00', 12, 21, 7),
(136, 'Ch3', 'mardi', '08:00:00', '09:55:00', 12, 27, 19),
(137, 'pc3', 'samedi', '14:00:00', '15:55:00', 12, 27, 4),
(138, 'Ar3', 'mardi', '16:00:00', '17:55:00', 12, 26, 13),
(139, 'filos3', 'mercredi', '10:00:00', '11:55:00', 12, 28, 10),
(140, 'Math3', 'jeudi', '14:00:00', '15:55:00', 12, 24, 10),
(142, 'ang3', 'vendredi', '16:00:00', '17:55:00', 12, 23, 19),
(143, 'EI3', 'samedi', '08:00:00', '09:55:00', 12, 26, 10),
(144, 'GH3', 'samedi', '16:00:00', '17:55:00', 12, 22, 4),
(145, 'info3', 'samedi', '14:00:00', '17:55:00', 12, 15, 18),
(146, 'Math4', 'lundi', '08:00:00', '09:55:00', 13, 1, 5),
(147, 'pc4', 'lundi', '10:00:00', '11:55:00', 13, 1, 5),
(148, 'ch4', 'mardi', '14:00:00', '15:55:00', 13, 8, 5),
(149, 'ch4', 'mardi', '16:00:00', '17:55:00', 13, 8, 5),
(150, 'Ei4', 'mercredi', '08:00:00', '09:55:00', 13, 11, 5),
(151, 'Ar4', 'mercredi', '14:00:00', '15:55:00', 13, 14, 5),
(152, 'ang4', 'jeudi', '08:00:00', '09:55:00', 13, 14, 5),
(153, 'fr4', 'jeudi', '14:00:00', '15:55:00', 13, 14, 5),
(154, 'filos4', 'vendredi', '14:00:00', '15:55:00', 13, 14, 13),
(155, 'sport', 'samedi', '08:00:00', '09:55:00', 13, 20, 3),
(156, 'info4', 'samedi', '10:00:00', '11:55:00', 13, 12, 16),
(157, 'info4', 'lundi', '10:00:00', '11:55:00', 14, 12, 17),
(158, 'Mah4', 'lundi', '14:00:00', '16:55:00', 14, 6, 13),
(159, 'pc4', 'mardi', '08:00:00', '09:55:00', 14, 6, 13),
(160, 'ch4', 'mardi', '10:00:00', '11:55:00', 14, 11, 8),
(161, 'GH4', 'mercredi', '10:00:00', '11:55:00', 14, 5, 8),
(162, 'ang4', 'jeudi', '10:00:00', '11:55:00', 14, 3, 8),
(163, 'fr4', 'jeudi', '14:00:00', '17:55:00', 14, 7, 9),
(164, 'ch4', 'vendredi', '14:00:00', '17:55:00', 14, 12, 7);

-- --------------------------------------------------------

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
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`id_enseignant`, `CIN`, `nom`, `prénom`, `DateNaissance`, `email`, `téléphone`) VALUES
(1, 'bh1342', 'gassos', 'tarik', '1963-03-07', 'gassos@gmail.com', '0614789520'),
(2, 'ba9524', 'bendib', 'fatima', '2001-09-06', 'bendib@gmail.com', '0714789515'),
(3, 'rt2587', 'idrissi', 'anouar', '1997-01-08', 'idrissi@gmai.com', '0789456200'),
(4, 'po1578', 'fakham', 'elmehdi', '1995-02-07', 'fakham@gmail.com', '0787954444'),
(5, 'bt1587', 'azlag', 'said', '1970-02-15', 'azlag@gmail.com', '0600878485'),
(6, 'tr2587', 'lehrach', 'abedaziz', '1970-01-01', 'lehrach@gmail.com', '06145874109'),
(7, 'bh1478', 'mofid', 'mohammed', '1978-08-10', 'mofid@gmail.com', '0654877802'),
(8, 'bh8795', 'karom', 'ali', '1989-04-28', 'karom@gmail.com', '0615478235'),
(9, 'bh1587', 'chaabi', 'latifa', '1978-05-30', 'chaabi@gmail.com', '0610952111'),
(10, 'bg5478', 'bouhlal', 'bouchaab', '2000-01-22', 'bouhlal@gmail..com', '0678941500'),
(11, 'bh1478', 'achbar', 'ahlam', '1983-12-02', 'achbar@gmail.com', '0784598965'),
(12, 'bh1489', 'jahabli', 'fatima', '1983-12-02', 'jahabli@gmail.com', '0789564179'),
(13, 'by1452', 'mostaid', 'mohmmed', '1985-12-30', 'mostaid@gmail.com', '0687924943'),
(14, 'bo1245', 'belyamani', 'mostapha', '1999-10-02', 'belyamani', '0647156308'),
(15, 'bh1235', 'haibi', 'karim', '1980-08-01', 'haibi@gmail.com', '0784596379'),
(16, 'bh1547', 'aniba', 'souhail', '2000-05-20', 'aniba@gmail.com', '0787954179'),
(17, 'ba1478', 'sadik', 'khadija', '1999-10-02', 'sadik@gmail.com', '0645789187'),
(18, 'ba1547', 'rachih', 'halima', '1995-10-05', 'rachih@gmail.com', '0784521313'),
(19, 'ba1578', 'boualal', 'kamal', '1978-08-10', 'boualal@gmail.com', '0678954275'),
(20, 'bh7854', 'rakhimi', 'rachida', '2000-03-31', 'rakhimi@gmail.com', '0647859060'),
(21, 'bh1547', 'boucheme', 'jala', '1987-02-15', 'boucheme@gmail.com', '0647892120'),
(22, 'ba9587', 'naanin', 'abedalah', '1995-10-05', 'naanin@gmail.com', '068794347'),
(23, 'bh1478', 'charaf', 'ahmed', '1986-05-13', 'charaf@gmail.com', '0714895670'),
(24, 'bt1436', 'chhaib', 'anouar', '1978-07-13', 'chhaib@gmail.com', '0614870055'),
(25, 'bh7895', 'kamil', 'soukaina', '1988-12-10', 'kamil@gmail.com', '0658745602'),
(26, 'bu4785', 'rahine', 'khouloud', '1778-08-19', 'rahine@gmail.com', '0654789591'),
(27, 'br1423', 'mostarit', 'samira', '1995-10-05', 'mostarit@gmail.com', '0654789615'),
(28, 'gh001', 'gabass', 'said', '1987-10-02', 'gabass@gmail.com', '0698563215');

-- --------------------------------------------------------

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
-- Déchargement des données de la table `feuille_présence`
--

INSERT INTO `feuille_présence` (`id_feuille`, `Année`, `numSemaine`, `jour`, `nmbAbsence`, `idclasse`) VALUES
(1, '2021/2022', 1, 'lundi', 0, 0),
(2, '2021/2022', 1, 'lundi', 0, 0),
(3, '2021/2022', 1, 'lundi', 0, 0),
(4, '2021/2022', 1, 'lundi', 0, 0),
(5, '2021/2022', 1, 'lundi', 0, 0),
(6, '2021/2022', 1, 'lundi', 0, 0),
(7, '2021/2022', 1, 'lundi', 0, 0),
(8, '2021/2022', 1, 'lundi', 0, 0),
(9, '2021/2022', 1, 'lundi', 0, 0),
(10, '2021/2022', 1, 'lundi', 0, 0),
(11, '2021/2022', 1, 'lundi', 0, 0),
(12, '2021/2022', 1, 'lundi', 0, 0),
(13, '2021/2022', 1, 'lundi', 0, 0),
(14, '2021/2022', 1, 'lundi', 0, 0),
(15, '2021/2022', 1, 'lundi', 0, 0),
(16, '2021/2022', 1, 'mardi', 0, 0),
(17, '2021/2022', 1, 'mardi', 0, 0),
(18, '2021/2022', 1, 'mardi', 0, 0),
(19, '2021/2022', 1, 'mardi', 0, 0),
(20, '2021/2022', 1, 'mardi', 0, 0),
(21, '2021/2022', 1, 'mardi', 0, 0),
(22, '2021/2022', 1, 'mardi', 0, 0),
(23, '2021/2022', 1, 'mardi', 0, 0),
(24, '2021/2022', 1, 'mardi', 0, 0),
(25, '2021/2022', 1, 'mardi', 0, 0),
(26, '2021/2022', 1, 'mardi', 0, 0),
(27, '2021/2022', 1, 'mardi', 0, 0),
(28, '2021/2022', 1, 'mardi', 0, 0),
(29, '2021/2022', 1, 'mardi', 0, 0),
(30, '2021/2022', 1, 'mardi', 0, 0);

-- --------------------------------------------------------

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
-- Déchargement des données de la table `viescolaire`
--

INSERT INTO `viescolaire` (`id_feuille`, `id_cour`, `numéro_élève`, `justification`) VALUES
(1, 1, 171, 'malade'),
(1, 3, 172, 'malade'),
(2, 11, 179, 'malade'),
(2, 14, 180, 'malade'),
(18, 21, 182, 'malade');

-- --------------------------------------------------------

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
-- Déchargement des données de la table `élève`
--

INSERT INTO `élève` (`numéro_élève`, `nom`, `prénom`, `date_naissance`, `id_classe`, `date_inscription`, `téléphone_père`, `téléphone_mère`) VALUES
(169, 'azlag', 'Nouhaila', '2000-12-13', 1, '2021-09-10', '0610952133', '0714589652'),
(170, 'fakham', 'chaimaa', '2001-11-03', 1, '2021-09-15', '0610952155', '0541256887'),
(171, 'lehrach', 'ilham', '2000-02-06', 1, '0000-00-00', '0645789612', '0614253632'),
(172, 'chaabi', 'latifa', '2000-05-08', 1, '2021-09-22', '0641789612', '0745896325'),
(173, 'atfi', 'saadia', '2001-02-09', 1, '2021-10-01', '0714253632', '0755478945'),
(174, 'fakham', 'elmehdi', '2001-07-05', 1, '2021-09-06', '0610952789', '0748521614'),
(175, 'aniba', 'souhail', '2000-02-08', 2, '2021-09-13', '0645789587', '0610258741'),
(176, 'rahine', 'khouloud', '2001-08-07', 2, '2021-10-03', '0645789612', '0714253611'),
(177, 'fakihi', 'ibtisam', '2000-05-05', 2, '2021-09-11', '0714258925', '0645789654'),
(178, 'harekachi', 'Nouhaila', '2000-03-06', 2, '2021-09-18', '0647894874', '0714253625'),
(179, 'fakham', 'zouhair', '2001-02-15', 2, '2021-10-08', '0714253612', '0645127812'),
(180, 'boualal', 'kamal', '2000-02-07', 2, '2021-04-05', '0641789614', '0714253632'),
(181, 'rakhimi', 'rachida', '2000-08-07', 3, '2021-09-06', '0714258933', '0714589628'),
(182, 'boucheme', 'jala', '2000-11-09', 3, '2021-09-21', '0641789693', '0714253687'),
(183, 'bou', 'najia', '2001-07-07', 3, '2021-09-18', '0645789654', '0714589688'),
(184, 'bounchrit', 'fatima', '2001-09-08', 3, '2021-09-07', '064578924', '0714253687'),
(185, 'fakham', 'anouar', '2000-08-08', 3, '2021-09-05', '0741582879', '9596164836'),
(186, 'idrissi', 'mohammed', '2000-05-05', 3, '2021-09-02', '0714258925', '0714589614'),
(187, 'chaabi', 'anas', '2001-02-08', 3, '2021-09-01', '0678954736', '0714253687'),
(188, 'ajir', 'kaoutar', '2001-11-02', 4, '2021-09-05', '074158747', '0541256787'),
(189, 'boucheme', 'hassan', '2001-02-04', 4, '2021-09-15', '0641789658', '0714253674'),
(190, 'majdoubi', 'mouad', '2000-08-14', 4, '2021-09-14', '0552236687', '0714253614'),
(191, 'mikharbach', 'kamal', '2002-10-07', 5, '2021-09-01', '0645789612', '0714253618'),
(192, 'omari', 'meryam', '2003-02-04', 5, '2021-09-01', '0714258913', '0755478977'),
(193, 'bouanana', 'meryam', '2002-05-06', 5, '2021-09-02', '0714258933', '0541256898'),
(194, 'chaanon', 'nora', '2002-12-07', 6, '2021-09-02', '064789458', '0714253647'),
(195, 'barraka', 'zineb', '2002-11-05', 6, '2021-09-03', '0610952177', '0541256854'),
(196, 'chhiab', 'fatima', '2002-11-08', 6, '2021-09-04', '06547825', '07142536'),
(197, 'zarouli', 'youssef', '2002-03-03', 6, '2021-09-06', '0654788', '07142536'),
(198, 'sousaid', 'abedllah', '2002-11-13', 6, '2021-09-06', '06457888', '07142587'),
(199, 'ElNachati', 'yassmine', '2002-08-04', 7, '2021-09-07', '06417844', '07145879'),
(200, 'mozawir', 'imane', '2002-12-06', 7, '2021-09-06', '06457898', '07485219'),
(201, 'razouini', 'ikram', '2002-05-05', 7, '2021-09-07', '07142538', '07485255'),
(202, 'attar', 'Moncef', '2002-11-06', 7, '2021-09-07', '0645732', '07554879'),
(203, 'hadbi', 'adil', '2003-11-06', 7, '2021-10-02', '06417897', '06485216'),
(204, 'dahmane', 'ibrahime', '2002-12-05', 7, '2021-09-06', '06457896', '07142589'),
(205, 'elkantour', 'youness', '2002-11-03', 7, '2021-09-08', '06109521', '07145896'),
(206, 'atko', 'driss', '2003-09-02', 7, '2021-09-21', '06417898', '07142537'),
(207, 'sabir', 'badr_eddine', '2001-02-07', 8, '2021-09-21', '06457895', '07485213'),
(208, 'haibbi', 'ilyass', '2003-04-05', 8, '2021-10-02', '07415823', '061425366'),
(209, 'Bouhlali', 'yasser', '2003-02-15', 8, '2021-09-05', '06478945', '075547896'),
(210, 'souki', 'salma', '2003-05-12', 8, '2021-09-21', '064178963', '074852165'),
(211, 'sinkjinto', 'prince', '2003-06-03', 8, '2021-09-02', '064578963', '075547893'),
(212, 'eloudhyri', 'zazia', '2003-03-11', 8, '2021-09-10', '071425365', '054125685'),
(213, 'fakir', 'hiba', '2002-02-05', 8, '2021-09-03', '064578963', '075547898'),
(214, 'mostarit', 'nihad', '2003-02-08', 9, '2021-09-09', '064178962', '074852168'),
(215, 'bendib', 'fatima', '2004-11-14', 9, '2021-09-05', '064578963', '075547893'),
(216, 'baha', 'najat', '2003-08-09', 9, '0000-00-00', '065478252', '054125683'),
(217, 'aynin', 'samira', '0000-00-00', 9, '0000-00-00', '06547883', '071423653'),
(218, 'diouane', 'souhail', '2003-01-19', 11, '2021-09-15', '0641789625', '0748521614'),
(219, 'rachidi', 'samira', '2003-05-08', 10, '2021-09-08', '0610587496', '0748521625'),
(220, 'samod', 'hassna', '2002-12-08', 10, '2021-10-03', '0645789625', '0714258715'),
(221, 'bermili', 'hind', '2002-02-03', 10, '2021-09-12', '0552236625', '0614789563'),
(222, 'bari', 'mehdi', '0000-00-00', 10, '0000-00-00', '0641789625', '0748521614'),
(223, 'idrissi', 'chouaib', '2003-10-08', 10, '2021-10-03', '0645789618', '0714258725'),
(224, 'ezzaydi', 'chaymae', '2003-10-03', 11, '2021-09-21', '0641789620', '0541256831'),
(225, 'marah', 'houssame', '2002-11-03', 11, '2021-10-02', '0647894258', '0755478914'),
(226, 'dahbi', 'khalid', '2002-12-07', 11, '2021-09-03', '0654782525', '0714589687'),
(227, 'mofid', 'mohamed', '2002-11-02', 11, '0000-00-00', '0714253625', '0714589614'),
(228, 'asir', 'naima', '2003-05-02', 11, '2021-10-05', '0678954725', '0714253614'),
(229, 'elboujdi', 'ikram', '2003-06-02', 11, '2021-09-12', '0714253625', '0714253615'),
(230, 'harmochi', 'said', '2003-05-02', 11, '2021-10-01', '0641789625', '0714589615'),
(231, 'labadal', 'imane', '2002-12-03', 11, '2021-09-12', '0645789625', '0714253636'),
(232, 'karom', 'abedalah', '0000-00-00', 11, '0000-00-00', '0641789614', '0748521625'),
(233, 'chaabi', 'abedlfattah', '2003-05-07', 12, '2021-10-02', '0641789614', '0614253636'),
(234, 'belfkih', 'nada', '2002-12-03', 12, '2021-05-12', '0647894257', '07554789'),
(235, 'madkori', 'ayman', '2002-03-17', 12, '2021-09-05', '0714258925', '0614789563'),
(236, 'charafi', 'hind', '2003-07-05', 12, '2021-09-21', '0647896525', '0714253614'),
(237, 'msadak', 'ossama', '2002-11-09', 12, '2021-10-07', '0641258799', '0714258963'),
(238, 'aryoss', 'ahmed', '2003-05-03', 12, '2021-09-05', '0641789612', '0541256725'),
(239, 'babouji', 'majda', '2003-02-03', 12, '2021-09-22', '0647894587', '0755478915'),
(240, 'farkil', 'omar', '2002-03-05', 13, '2021-09-12', '0714253612', '0614253615'),
(241, 'harras', 'salma', '2003-02-05', 13, '2021-09-05', '0647894789', '0714258714'),
(242, 'fadli', 'youness', '2002-10-02', 13, '2021-09-07', '0625478925', '0714589614'),
(243, 'rahine', 'mehdi', '0000-00-00', 13, '0000-00-00', '0647896525', '0714253614'),
(244, 'achaabi', 'zakaria', '2002-12-03', 13, '2021-10-05', '0641789625', '0614253614'),
(245, 'hadidi', 'khaoula', '2003-09-08', 13, '2021-09-10', '064789415', '0745896325'),
(246, 'egarni', 'meryam', '2002-11-07', 13, '2021-09-21', '0654782525', '0541256814'),
(247, 'jamai', 'rabiaa', '2003-12-06', 13, '2021-10-05', '0714253615', '0748521625'),
(248, 'haqiq', 'mouad', '2003-10-07', 14, '2021-09-09', '0714253625', '0748521614'),
(249, 'chahar', 'haytam', '2004-03-17', 14, '2021-10-03', '0678954725', '0745896314'),
(250, 'mojahib', 'hossine', '2004-05-08', 14, '2021-10-09', '0552236614', '0714253615'),
(251, 'talha', 'souad', '2004-07-08', 14, '2021-09-06', '0714253615', '0748521617'),
(252, 'elouadi', 'nouhaila', '2005-02-07', 14, '2021-09-08', '0678954715', '0714258725'),
(253, 'harakat', 'mostapha', '2004-11-07', 14, '2021-09-16', '0552236625', '0714893215'),
(254, 'saih', 'najib', '2004-12-07', 14, '2021-09-19', '0714253625', '0748521614'),
(255, 'abid', 'jalal', '2004-09-05', 14, '2021-09-27', '0678954725', '0745896315'),
(256, 'zaytoni', 'rachid', '2004-11-07', 15, '2021-09-15', '0641789858', '07485216253'),
(257, 'benani', 'mohssine', '0000-00-00', 15, '0000-00-00', '0678954725', '0714258725'),
(258, 'kachbar', 'ahlam', '2004-09-21', 15, '2021-09-06', '0552236614', '0714589687'),
(259, 'solayman', 'omar', '2004-09-15', 15, '2021-09-25', '0714253615', '0614253636'),
(260, 'halat', 'nadia', '2004-08-15', 15, '2021-09-12', '0714258996', '0687945126'),
(261, 'mostawi', 'houda', '2004-03-07', 15, '2021-09-26', '0714253615', '0614253636'),
(262, 'israjan', 'kanza', '2005-02-15', 15, '2021-09-28', '0525874136', '0610951212'),
(263, 'hanchi', 'sofia', '2006-05-07', 16, '2021-09-21', '0741587245', '0614253614'),
(264, 'ahjam', 'monir', '2006-08-22', 16, '2021-09-21', '0645789625', '0714258725'),
(265, 'motogre', 'islam', '2007-02-05', 16, '2021-09-21', '0654782525', '0714589687'),
(266, 'safdi', 'khadija', '0000-00-00', 16, '0000-00-00', '0647896525', '0714253614'),
(267, 'elouafa', 'amal', '2007-07-28', 16, '2021-09-23', '0641789618', '0748521619'),
(268, 'sargaoui', 'imane', '2007-12-06', 16, '2021-09-12', '0678954725', '0714253614'),
(269, 'momen', 'wafaa', '2007-12-22', 16, '2021-09-18', '0654782525', '0714589687'),
(270, 'mabrouk', 'abedelmourit', '2007-09-25', 16, '2021-09-12', '0641789614', '0748521614'),
(271, 'makhlouf', 'soufiane', '2007-11-21', 16, '2021-09-30', '0645789625', '0714253636'),
(272, 'sabir', 'nourddine', '2007-03-21', 12, '2021-09-25', '0654782525', '0714589687'),
(273, 'boukhari', 'safaa', '2021-09-21', 17, '2021-09-21', '0647896525', '0714253614'),
(274, 'amhri', 'dounia', '2008-10-07', 17, '2021-09-02', '0610547825', '0714258733'),
(275, 'mantari', 'zakia', '2008-08-22', 17, '2021-09-29', '0758123697', '0678965412'),
(276, 'omari', 'khalid', '2008-06-05', 17, '2021-09-13', '0714253615', '0614253614'),
(277, 'lkhdar', 'jamila', '2008-05-08', 17, '2021-09-15', '0678954729', '0714253637'),
(278, 'kachkachi', 'ayoub', '2008-08-21', 17, '2021-09-11', '0654782525', '0714589687'),
(279, 'satiri', 'youness', '2008-09-27', 17, '2021-09-13', '0687954123', '0714253615'),
(280, 'saadaoui', 'abedalah', '2008-08-25', 17, '2021-09-05', '0641789625', '0748521614'),
(281, 'hafidi', 'karim', '2008-03-25', 17, '2021-09-28', '0678954725', '0714258725'),
(282, 'banon', 'badr', '2008-07-22', 15, '2021-09-19', '0641789614', '0748521614'),
(283, 'touzani', 'ghita', '2008-05-21', 6, '2021-09-21', '0641789625', '0748521625'),
(284, 'olami', 'soufiane', '2008-08-21', 8, '2021-09-21', '0714258996', '0687945126'),
(285, 'titaoui', 'ayoub', '2004-09-22', 9, '2021-09-10', '0641789614', '0748521625');

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
