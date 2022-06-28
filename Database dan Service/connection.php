<?php
$dbserver = "localhost";
$dbname = "burger";
$dbuser = "root";
$dbpassword = "";
$dsn = "mysql:host = {$dbserver};dbname={$dbname}";

$connection = null;
try {
    $connection = new PDO($dsn, $dbuser, $dbpassword);
    $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

} catch (PDOException $e) {
    die("Koneksi Gagal: " . $e->getMessage());
}