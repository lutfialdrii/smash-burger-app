-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 15 Jun 2022 pada 05.15
-- Versi server: 10.5.12-MariaDB
-- Versi PHP: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id19103123_burger`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `kuantitas` int(3) NOT NULL,
  `total_harga` int(9) NOT NULL,
  `waktu` timestamp NOT NULL DEFAULT current_timestamp(),
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `alamat`, `kuantitas`, `total_harga`, `waktu`, `id_user`) VALUES
(1, 'jl suka karya', 5, 2, '2022-06-11 15:48:58', 1),
(2, 'jalan mangga', 2, 90000, '2022-06-15 00:08:06', 5),
(3, 'meja 1', 2, 90000, '2022-06-15 00:09:57', 5),
(4, 'jl Nka', 2, 80000, '2022-06-15 01:20:15', 1),
(5, 'jl Nka', 2, 80000, '2022-06-15 01:20:15', 1),
(6, 'jl Nka', 2, 80000, '2022-06-15 01:20:15', 1),
(7, 'jl Nka', 2, 80000, '2022-06-15 01:20:15', 1),
(8, 'jl Nka', 2, 80000, '2022-06-15 01:20:15', 1),
(9, 'jl Nka', 2, 80000, '2022-06-15 01:20:16', 1),
(10, 'jl Nka', 2, 80000, '2022-06-15 01:20:16', 1),
(11, 'jl Nka', 2, 80000, '2022-06-15 01:20:16', 1),
(12, 'jl Nka', 2, 80000, '2022-06-15 01:20:16', 1),
(13, 'jl Nka', 2, 80000, '2022-06-15 01:20:16', 1),
(14, 'jl Nka', 2, 80000, '2022-06-15 01:20:17', 1),
(15, 'Jl. Asta Karya', 7, 320000, '2022-06-15 01:47:16', 6),
(16, 'siak', 2, 90000, '2022-06-15 02:10:46', 1),
(17, 'test', 0, 0, '2022-06-15 02:34:27', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama_lengkap` varchar(32) NOT NULL,
  `no_hp` int(15) NOT NULL,
  `email` varchar(70) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama_lengkap`, `no_hp`, `email`) VALUES
(1, 'lutfialdrii', '098f6bcd4621d373cade4e832627b4f6', 'lutfi', 88, 'yahah'),
(2, 'elpin', '6512bd43d9caa6e02c990b0a82652dca', 'tttt', 88, 'yyy'),
(3, 'panjul', 'c783816dc0eca7147db591703fd54f03', 'yahahah', 88, 'aja'),
(4, 'lutfialD', '098f6bcd4621d373cade4e832627b4f6', 'lutfi1', 183018238, 'lutfi@yahaha.com'),
(5, 'ceks', '098f6bcd4621d373cade4e832627b4f6', 'lutfi', 808, 'lalala@gmail.'),
(6, 'vino', '69bb23ca275704f46c65d8ed4ac3b5d7', 'Elvino', 8131334, 'elvino@gmail.com'),
(7, 'yahah', '098f6bcd4621d373cade4e832627b4f6', 'coba', 8, 'hahah@gmail.com'),
(8, 'lutfialDr', '098f6bcd4621d373cade4e832627b4f6', 'lutfi1', 183018238, 'lutfi@yahaha.com');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_user`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT untuk tabel `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
