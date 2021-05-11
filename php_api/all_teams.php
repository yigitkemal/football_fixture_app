<?php
// array for JSON response
$response = array();

//DB_SERVER,DB_USER,DB_PASSWORD,DB_DATABASE değişkenleri alınır.
require_once __DIR__ . '/db_config.php';

// Bağlantı oluşturuluyor.
$baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);
    
// Bağlanti kontrolü yapılır.
if (!$baglanti) {
    die("Hatalı bağlantı : " . mysqli_connect_error());
}
    
$sqlsorgu = "SELECT * FROM premiere_league";
$result = mysqli_query($baglanti, $sqlsorgu);

// result kontrolü yap
if (mysqli_num_rows($result) > 0) {
    
    $response["premiere_league"] = array();
    
    while ($row = mysqli_fetch_assoc($result)) {
        // temp user array
        $premiere_league = array();
        
        $premiere_league["id"] = $row["id"];
        $premiere_league["name"] = $row["name"];
        $premiere_league["logo"] = $row["logo"];
        
        // push single product into final response array
        array_push($response["premiere_league"], $premiere_league);
    }
    // success
    $response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
    
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No data found";

    // echo no users JSON
    echo json_encode($response);
}
//bağlantı koparılır.
mysqli_close($baglanti);
?>
