-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 30 déc. 2021 à 21:36
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `election`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'sebastien', 'labo'),
(2, 'aa', 'aa'),
(3, 'kylian', 'alors');

-- --------------------------------------------------------

--
-- Structure de la table `candidats`
--

DROP TABLE IF EXISTS `candidats`;
CREATE TABLE IF NOT EXISTS `candidats` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `date` date NOT NULL,
  `sexe` varchar(20) NOT NULL,
  `nompartie` varchar(20) NOT NULL,
  `lienfb` varchar(60) NOT NULL,
  `lientwitter` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nbrdevotes` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `candidats`
--

INSERT INTO `candidats` (`id`, `nom`, `prenom`, `date`, `sexe`, `nompartie`, `lienfb`, `lientwitter`, `nbrdevotes`) VALUES
(4, 'monsieur', 'flen', '2021-09-08', 'Masculin', 'nimporte', 'http/facebook', 'http/twitter', 1),
(5, 'madame', 'eee', '2021-07-14', 'Feminin', 'lac', 'https/www.facebook.com', 'https/www.', 3);

-- --------------------------------------------------------

--
-- Structure de la table `electeur`
--

DROP TABLE IF EXISTS `electeur`;
CREATE TABLE IF NOT EXISTS `electeur` (
  `cin` int NOT NULL,
  `nom_electeur` varchar(20) NOT NULL,
  `prenom_electeur` varchar(20) NOT NULL,
  `password_electeur` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `sexe` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `electeur`
--

INSERT INTO `electeur` (`cin`, `nom_electeur`, `prenom_electeur`, `password_electeur`, `date`, `sexe`) VALUES
(12324546, 'HELA', 'khelifi', 'ldld', '2020-12-26', 'feminin');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `score`
-- (Voir ci-dessous la vue réelle)
--
DROP VIEW IF EXISTS `score`;
CREATE TABLE IF NOT EXISTS `score` (
`id` int
,`nbrdevotes` int
,`nom` varchar(20)
,`prenom` varchar(20)
);

-- --------------------------------------------------------

--
-- Structure de la vue `score`
--
DROP TABLE IF EXISTS `score`;

DROP VIEW IF EXISTS `score`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `score`  AS  select `candidats`.`id` AS `id`,`candidats`.`nom` AS `nom`,`candidats`.`prenom` AS `prenom`,`candidats`.`nbrdevotes` AS `nbrdevotes` from `candidats` group by `candidats`.`id` order by `candidats`.`nbrdevotes` desc ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
