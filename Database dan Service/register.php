<?php
include 'connection.php';

if($_POST) {

    //POST DATA
    $username = filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING);
    $password = filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING);
    $nama_lengkap = filter_input(INPUT_POST, 'nama_lengkap', FILTER_SANITIZE_STRING);
    $no_hp = filter_input(INPUT_POST, 'no_hp');
    $email = filter_input(INPUT_POST, 'email');
    $response = []; //Data Response

    //Cek Username dalam database
    $userQuery = $connection->prepare("SELECT * FROM user where username = ?");
    $userQuery->execute(array($username));


    //cek Username apakah ada atau tidak
    if($userQuery->rowCount() != 0) {
        //Response
        $response['status'] = false;
        $response['message'] = "Username sudah ada";
    } else {
        $insertAccount = 'INSERT INTO user (username, password, nama_lengkap, no_hp, email ) VALUES (:username, :password, :nama_lengkap, :no_hp, :email)';
        $statement = $connection->prepare($insertAccount);

        try {
            //Eksekusi statement DB
            $statement->execute([
                ':username' => $username,
                ':password' => md5($password),
                ':nama_lengkap' => $nama_lengkap,
                ':no_hp' => $no_hp,
                ':email' => $email
            ]);

            //Beri Response
            $response['status'] = true;
            $response['message'] = 'Register Berhasil';
            $response['data'] = [
                'username' => $username,
                'nama_lengkap' => $nama_lengkap,
                'no_hp' => $no_hp,
                'email' => $email
            ];
        } catch (Exception $e) {
            die($e->getMessage());
        }
    }

    //Jadikan data JSON
    $json = json_encode($response, JSON_PRETTY_PRINT);

    //print json
    echo $json;
}
