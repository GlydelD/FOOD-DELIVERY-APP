<?php

    $databasecreate = new mysqli('localhost', 'root', '');
    if($databasecreate->connect_error){
        die("Error Executing: ". $databasecreate->connect_error);
    }

    $database = "CREATE DATABASE IF NOT EXISTS vetdatabase";
    if(!$databasecreate->query($database) === TRUE) {
        echo "ERROR CREATING DATABASE ". $databasecreate->error;
    }

    $conn = new mysqli('localhost', 'root', '', 'vetdatabase');
    if($conn->connect_error){
        die("Error Executing: ". $conn->connect_error);
    }

    $users = file_get_contents('sql/users.sql');
    if(!$conn->query($users) === TRUE) {
        echo "ERROR CREATING DATABASE ". $conn->error;
    }
    
    $admin = file_get_contents('sql/admin.sql');
    if(!$conn->query($admin) === TRUE) {
        echo "ERROR CREATING DATABASE ". $conn->error;
    }
    

?>


