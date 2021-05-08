<?php

    $response = array();

    if (isset($_POST['name'])) {
        $name = $_POST['name'];
   
        //DB_SERVER,DB_USER,DB_PASSWORD,DB_DATABASE değişkenleri alınır.
        require_once __DIR__ . '/db_config.php';
        
        // Bağlantı oluşturuluyor.
        $baglanti = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);
        
        // Bağlanti kontrolü yapılır.
        if (!$baglanti) {
            die("Hatalı bağlantı : " . mysqli_connect_error());
        }
        
        $sqlsorgu = "SELECT * FROM premiere_league WHERE premiere_league.name like '%$name%'";
        $result = mysqli_query($baglanti, $sqlsorgu);
        
        if (mysqli_num_rows($result) > 0) {

            $response["premiere_league"] = array();
            
            while ($row = mysqli_fetch_assoc($result)) {
       
                $premiere_league = array();
                
                $premiere_league["name"] = $row["name"];
                $premiere_league["name"] = $row["name"];
                $premiere_league["logo"] = $row["logo"];

                array_push($response["premiere_league"], $premiere_league);
            }
      
            $response["success"] = 1;
            
            echo json_encode($response);
            
        }
        //bağlantı koparılır.
        mysqli_close($baglanti);
        
        
    } else {

        $response["success"] = 0;
        $response["message"] = "Required field(s) is missing";

        echo json_encode($response);
}
?>




