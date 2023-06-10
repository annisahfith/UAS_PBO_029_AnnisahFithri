-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 10 Jun 2023 pada 11.24
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pos_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `harga` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode`, `nama`, `harga`) VALUES
(1111, 'Chitato BBQ Normal', 10000),
(1112, 'Oreo', 15000),
(1113, 'Chiki', 12000),
(1114, 'Potabee', 8000),
(1115, 'Twister', 6000),
(1116, 'Tango', 8000),
(1117, 'Monde', 14000),
(1118, 'Kacang Garuda', 4000),
(1119, 'Vitamin c', 10000),
(1120, 'Aqua', 5000),
(1121, 'Pocky', 8000),
(1122, 'Yupi', 6000),
(1123, 'Sari Roti', 6000),
(1124, 'Popcorn', 8000),
(1125, 'Goodtime', 12000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kartu_debit`
--

CREATE TABLE `kartu_debit` (
  `id` int(11) NOT NULL,
  `bank` varchar(11) NOT NULL,
  `nomor_kartu` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kas`
--

CREATE TABLE `kas` (
  `id` int(11) NOT NULL,
  `dibayar` float NOT NULL,
  `kembalian` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kas`
--

INSERT INTO `kas` (`id`, `dibayar`, `kembalian`) VALUES
(27, 10000, 0),
(28, 5000, -5000),
(29, 20000, 10000),
(30, 20000, 5000),
(31, 10000, 0),
(32, 1000, -9000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pln`
--

CREATE TABLE `pln` (
  `kode` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `nominal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pln`
--

INSERT INTO `pln` (`kode`, `nama`, `nominal`) VALUES
(2221, 'Listrik Prabayar20', 20000),
(2222, 'Listrik Prabayar50', 50000),
(2223, 'Listrik Prabayar100', 100000),
(2224, 'Listrik Prabayar250', 250000),
(2225, 'Listrik Prabayar500', 500000),
(2226, 'Listrik Prabayar1000', 1000000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pulsa`
--

CREATE TABLE `pulsa` (
  `kode` int(11) NOT NULL,
  `operator` varchar(50) NOT NULL,
  `nominal` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pulsa`
--

INSERT INTO `pulsa` (`kode`, `operator`, `nominal`) VALUES
(3310, 'IM3', 15000),
(3311, 'IM3', 20000),
(3312, 'IM3', 25000),
(3313, 'IM3', 50000),
(3314, 'IM3', 100000),
(3315, 'XL', 5000),
(3316, 'XL', 10000),
(3317, 'XL', 15000),
(3318, 'XL', 20000),
(3319, 'XL', 25000),
(3320, 'XL', 50000),
(3321, 'XL', 100000),
(3331, 'Telkomsel', 5000),
(3332, 'Telkomsel', 10000),
(3333, 'Telkomsel', 15000),
(3334, 'Telkomsel', 20000),
(3335, 'Telkomsel', 25000),
(3336, 'Telkomsel', 50000),
(3337, 'Telkomsel', 100000),
(3338, 'IM3', 5000),
(3339, 'IM3', 10000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `qris`
--

CREATE TABLE `qris` (
  `id` int(11) NOT NULL,
  `konten` varchar(100) NOT NULL,
  `request_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `waktu_pembayaran` datetime NOT NULL,
  `total_harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id`, `waktu_pembayaran`, `total_harga`) VALUES
(2, '2023-06-08 00:19:46', 10000),
(3, '2023-06-08 00:36:02', 10000),
(4, '2023-06-08 00:42:12', 10000),
(5, '2023-06-08 00:42:56', 10000),
(6, '2023-06-08 00:43:39', 10000),
(7, '2023-06-08 00:44:13', 10000),
(8, '2023-06-08 00:45:00', 15000),
(9, '2023-06-08 12:01:42', 59000),
(10, '2023-06-08 12:03:38', 59000),
(11, '2023-06-08 12:04:15', 27000),
(12, '2023-06-08 12:04:38', 22000),
(13, '2023-06-08 12:32:53', 59000),
(14, '2023-06-08 12:35:34', 59000),
(15, '2023-06-08 12:37:26', 59000),
(16, '2023-06-08 12:38:34', 59000),
(17, '2023-06-09 15:06:52', 121000),
(18, '2023-06-09 15:07:19', 121000),
(19, '2023-06-09 15:07:54', 121000),
(20, '2023-06-09 15:19:31', 121000),
(21, '2023-06-09 17:48:05', 37000),
(22, '2023-06-09 19:46:15', 65000),
(23, '2023-06-09 21:35:45', 89000),
(24, '2023-06-09 21:35:55', 89000),
(25, '2023-06-09 21:36:05', 89000),
(26, '2023-06-10 11:02:38', 103000),
(27, '2023-06-10 11:37:34', 10000),
(28, '2023-06-10 11:51:39', 10000),
(29, '2023-06-10 11:54:52', 10000),
(30, '2023-06-10 11:55:40', 15000),
(31, '2023-06-10 12:12:12', 10000),
(32, '2023-06-10 12:13:37', 10000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `kartu_debit`
--
ALTER TABLE `kartu_debit`
  ADD KEY `kd_fk` (`id`);

--
-- Indeks untuk tabel `kas`
--
ALTER TABLE `kas`
  ADD KEY `kas_fk` (`id`) USING BTREE;

--
-- Indeks untuk tabel `pln`
--
ALTER TABLE `pln`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `pulsa`
--
ALTER TABLE `pulsa`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `qris`
--
ALTER TABLE `qris`
  ADD KEY `qris_fk` (`id`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `barang`
--
ALTER TABLE `barang`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1126;

--
-- AUTO_INCREMENT untuk tabel `pln`
--
ALTER TABLE `pln`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3010;

--
-- AUTO_INCREMENT untuk tabel `pulsa`
--
ALTER TABLE `pulsa`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20046;

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `kartu_debit`
--
ALTER TABLE `kartu_debit`
  ADD CONSTRAINT `kd_fk` FOREIGN KEY (`id`) REFERENCES `transaksi` (`id`);

--
-- Ketidakleluasaan untuk tabel `kas`
--
ALTER TABLE `kas`
  ADD CONSTRAINT `kas_fk` FOREIGN KEY (`id`) REFERENCES `transaksi` (`id`);

--
-- Ketidakleluasaan untuk tabel `qris`
--
ALTER TABLE `qris`
  ADD CONSTRAINT `qris_fk` FOREIGN KEY (`id`) REFERENCES `transaksi` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
