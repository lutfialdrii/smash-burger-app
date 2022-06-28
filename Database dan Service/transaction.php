<?php

include "connection.php";

if ($_POST) {

    //Data
    $id_user = filter_input(INPUT_POST, 'id_user', FILTER_SANITIZE_STRING);
    $alamat = filter_input(INPUT_POST, 'alamat', FILTER_SANITIZE_STRING);
    $kuantitas = filter_input(INPUT_POST, 'kuantitas',FILTER_SANITIZE_STRING);
    $total_harga = filter_input(INPUT_POST, 'total_harga', FILTER_SANITIZE_STRING);

    $response = [];

    $insertTransaksi = "INSERT INTO transaksi (id_user, alamat, kuantitas, total_harga) VALUES (:id_user, :alamat, :kuantitas, :total_harga)";
    $statement = $connection->prepare($insertTransaksi);

    try {
        //Ekseskusi statement DB
        $statement -> execute([
            ':id_user' => $id_user,
            ':alamat' => $alamat,
            ':kuantitas' => $kuantitas,
            ':total_harga' => $total_harga
        ]);

        //Beri Response
        $response['status'] = true;
        $response['message'] = "Register Berhasil";
        $response['data'] = [
            'id_user' => $id_user,
            'alamat' => $alamat,
            'kuantitas' => $kuantitas,
            'total_harga' => $total_harga
        ];

    } catch (Exception $ex) {
        die($ex->getMessage());
    }

    //Jadikan JSON
    $json = json_encode($response, JSON_PRETTY_PRINT);

    //print json
    echo $json;
}

