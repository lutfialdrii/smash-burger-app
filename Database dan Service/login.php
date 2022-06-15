<?php

include 'connection.php';

if($_POST){
    //data
    $username = $_POST['username'] ?? '';
    $password = $_POST['password'] ?? '';

    $response = []; //Data Response

    //Cek Username dalam database
    $userQuery = $connection->prepare("SELECT * FROM user where username = ?");
    $userQuery->execute(array($username));
    $query = $userQuery->fetch();

    if($userQuery->rowCount() == 0){
        $response['status'] = false;
        $response['message'] = "Username tidak ditemukan";
    } else {
        // Ambil password di database

        $passwordDB = $query['password'];

        if(strcmp(md5($password), $passwordDB) === 0){
            $response['status'] = true;
            $response['message'] = "Login Berhasil";
            $response['data'] = [
                'id_user' => $query['id_user'],
                'username' => $query['username'],
                'nama_lengkap' => $query['nama_lengkap'],
                'no_hp' => $query['no_hp'],
                'email' => $query['email']
            ];
        } else {
            $response['status'] = false;
            $response['message'] = "Password salah";
        }
    }

    //jadikan data JSON
    $json = json_encode($response, JSON_PRETTY_PRINT);

    //Print JSON
    echo $json;
}
