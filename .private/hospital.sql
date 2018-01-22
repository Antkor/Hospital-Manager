-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 22 Ιαν 2018 στις 19:17:05
-- Έκδοση διακομιστή: 10.1.26-MariaDB
-- Έκδοση PHP: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `hospital`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `appointment`
--

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `notes` text,
  `patient_amka` varchar(11) NOT NULL,
  `doctor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `appointment`
--

INSERT INTO `appointment` (`id`, `date`, `notes`, `patient_amka`, `doctor_id`) VALUES
(1, '2018-02-05 09:00:00', 'test 1', '11111111111', 111111),
(2, '2018-01-07 12:00:00', 'test', '11111111111', 111111),
(3, '2018-01-25 08:30:00', 'test 3', '55555555555', 222222),
(4, '2018-01-27 11:00:00', 'test 4', '90909090909', 333333),
(5, '2018-01-26 14:15:00', 'test 5', '78787878787', 444444);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(1, 'Αιματολογικό'),
(2, 'Δερματολογικό'),
(3, 'Καρδιολογικό'),
(4, 'Ορθοπεδικό'),
(5, 'Παθολογικό'),
(6, 'Παιδιατρικό'),
(7, 'Πνευματολογικό'),
(8, 'Χειρουργικό'),
(9, 'Ψυχιατρικό'),
(10, 'ΩΡΛ');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `name` varchar(40) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `speciality` varchar(30) NOT NULL,
  `department_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `doctor`
--

INSERT INTO `doctor` (`id`, `date_created`, `date_updated`, `name`, `surname`, `telephone`, `speciality`, `department_id`) VALUES
(111111, '2018-01-16 22:57:51', '2018-01-16 22:57:51', 'ΓΙΩΡΓΟΣ ', 'ΠΑΠΑΔΟΠΟΥΛΟΣ', '2310501501', 'ΚΑΡΔΙΟΛΟΓΟΣ', 3),
(222222, '2018-01-16 22:57:51', '2018-01-16 22:57:51', 'ΜΑΡΙΑ', 'ΕΥΑΓΓΕΛΟΠΟΥΛΟΥ', '2310270230', 'ΠΑΙΔΙΑΤΡΟΣ', 6),
(333333, '2018-01-16 22:57:51', '2018-01-16 22:57:51', 'ΧΡΗΣΤΟΣ', 'ΕΥΣΤΡΑΤΙΟΥ', '2310963852', 'ΟΡΘΟΠΕΔΙΚΟΣ', 4),
(444444, '2018-01-16 22:57:51', '2018-01-16 22:57:51', 'ΕΛΠΙΔΑ', 'ΑΘΑΝΑΣΙΟΥ', '2310159357', 'ΔΕΡΜΑΤΟΛΟΓΟΣ', 2),
(555555, '2018-01-16 22:57:51', '2018-01-16 22:57:51', 'ΧΑΡΙΣΙΟΣ', 'ΙΩΑΚΕΙΜΙΔΗΣ', '2310886622', 'ΧΕΙΡΟΥΡΓΟΣ', 8);

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `patient`
--

CREATE TABLE `patient` (
  `amka` varchar(11) NOT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  `firstname` varchar(40) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `bloodtype` varchar(40) DEFAULT NULL,
  `insurance` varchar(30) NOT NULL,
  `info` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Άδειασμα δεδομένων του πίνακα `patient`
--

INSERT INTO `patient` (`amka`, `date_created`, `date_updated`, `firstname`, `lastname`, `address`, `telephone`, `email`, `age`, `gender`, `bloodtype`, `insurance`, `info`) VALUES
('11111111111', '2018-01-07 19:34:00', '2018-01-07 19:34:00', 'Αντώνης', 'Κοροσίδης', 'Παπαναστασίου 40', '6931111111', 'antonis@uom.gr', 30, 'male', 'A+', 'ΙΚΑ', 'Δερματολογική ίωση'),
('22222222222', '2018-01-07 19:34:00', '2018-01-07 19:34:00', 'Πασχάλης', 'Φακριάδης', 'Εγνατίας 114', '6971111111', 'paschalis@uom.gr', 28, 'male', 'B+', 'ΙΚΑ', 'Άλγος κάτω άκρων'),
('33333333333', '2018-01-07 19:34:55', '2018-01-07 19:34:55', 'Σαράντης', 'Καλαφατίδης', '25ης Μαρτίου 89', '6941111111', 'sarantis@uom.gr', 26, 'male', '0', 'ΙΚΑ', 'Ημικρανία'),
('44444444444', '2018-01-16 22:42:56', '2018-01-16 22:42:56', 'Νίκος', 'Παπαγεωργόπουλος', 'Λασσάνη 2', '6931212121', 'nickp@gmail.com', 55, 'Α', '0+', 'ΙΚΑ', 'test info παπαγεωργόπουλος'),
('55555555555', '2018-01-16 22:42:56', '2018-01-16 22:42:56', 'Λουκάς', 'Γεωργούλας', 'Καρδίτσας 56', '6971212121', 'lgeorg@outlook.com', 68, 'Α', 'Β+', 'ΔΗΜΟΣΙΟΥ', 'test info Γεωργούλας'),
('78787878787', '2018-01-16 22:46:21', '2018-01-16 22:46:21', 'Νίκη', 'Αγγελοπούλου', 'Μπότσαρη 89', '6941212121', 'niki.agg@outlook.com', 88, 'Θ', '0+', 'ΙΚΑ', 'test info Αγγελοπούλου'),
('90909090909', '2018-01-16 22:46:21', '2018-01-16 22:46:21', 'Μαρία', 'Παναγιώτου', 'Βενιζέλου 29', '6973434343', 'maria.pan@live.com', 49, 'Θ', 'Α+', 'ΔΗΜΟΣΙΟΥ', 'Τέστ Παναγιώτου');

--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `patient_amka` (`patient_amka`),
  ADD KEY `doctor_id` (`doctor_id`);

--
-- Ευρετήρια για πίνακα `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Ευρετήρια για πίνακα `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `department_id` (`department_id`);

--
-- Ευρετήρια για πίνακα `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`amka`);

--
-- AUTO_INCREMENT για άχρηστους πίνακες
--

--
-- AUTO_INCREMENT για πίνακα `appointment`
--
ALTER TABLE `appointment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT για πίνακα `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT για πίνακα `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=555556;

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `doctor_id_fk_1` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `patient_amka_fk_1` FOREIGN KEY (`patient_amka`) REFERENCES `patient` (`amka`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Περιορισμοί για πίνακα `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `doctor_ibfk_1` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
