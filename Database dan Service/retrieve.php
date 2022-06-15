<?php

//$id_user = filter_input(INPUT_POST, 'id_user', FILTER_SANITIZE_STRING);
//
//$userQuery = $connection->prepare("SELECT * FROM transaksi WHERE id_user = ?");
//$userQuery->execute(array($id_user));
//$userQuery->setFetchMode(PDO::FETCH_ASSOC);
//
//$result = $userQuery->fetchAll();
////query
//header('Content-Type: application/json');
//echo json_encode($result);


$host = "localhost";
$user = "root";
$pass = "";
$db = "burger";
$id_user = $_POST['id_user'];

$konek = mysqli_connect($host, $user, $pass, $db) or die("Database MYSQL Tidak Terhubung");

$perintah = "SELECT * FROM transaksi WHERE id_user = '$id_user'";
$eksekusi = mysqli_query($konek, $perintah);
$cek = mysqli_affected_rows($konek);

if ($cek > 0) {
    $response["kode"] = 1;
    $response["pesan"] = "Data Tersedia";
    $response["data"] = array();

    while ($ambil = mysqli_fetch_object($eksekusi)) {
        $F["alamat"] = $ambil->alamat;
        $F["kuantitas"] = $ambil->kuantitas;
        $F["total_harga"] = $ambil->total_harga;
        $F["waktu"] = $ambil->waktu;

        array_push($response["data"], $F);
    }

} else {
    $response["kode"] = 0;
    $response["pesan"] = "Data Tidak Tersedia";
}

echo json_encode($response);
mysqli_close($konek);

////cek Username apakah ada atau tidak
//if($userQuery->rowCount() == 0) {
//    //Response
//    $response['status'] = false;
//    $response['message'] = "Anda Belum Memesan!";
//} else {
//    $result = $statement->fetchAll();
//    //query
//    header('Content-Type: application/json');
//    echo json_encode($result);
//}

//$eksekusi = mysqli_query($konek, $perintah);
//$cek = mysqli_affected_rows($konek);
//
//if($cek > 0){
//    $response["kode"] = 1;
//    $response["pesan"] = "Data Tersedia";
//    $response["data"] = array();
//
//    while($ambil = mysqli_fetch_object($eksekusi)){
//        $F["id"] = $ambil->id;
//        $F["nama"] = $ambil->nama;
//        $F["alamat"] = $ambil->alamat;
//        $F["telepon"] = $ambil->telepon;
//
//        array_push($response["data"], $F);
//    }
//
//}
//else{
//    $response["kode"] = 0;
//    $response["pesan"] = "Data Tidak Tersedia";
//}
//
//echo json_encode($response);
//mysqli_close($konek);