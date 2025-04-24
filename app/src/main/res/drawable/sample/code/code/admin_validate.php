<?php
require_once("sql/createDB.php");
session_start();

if ($_SERVER['REQUEST_METHOD'] == "POST") {
    $username = $_POST['username'];
    $password = $_POST['password'];
        
    if (!empty($username) && !empty($password)) {
        $query = "select * from admin where username = '$username' limit 1";
        $result = mysqli_query($conn, $query);
        
        if ($result && mysqli_num_rows($result) > 0) {
            $adminData = mysqli_fetch_assoc($result); 
            if ($adminData['password'] == $password) {
                $_SESSION['username'] = $adminData['username'];
                $_SESSION['adminpassword'] = $adminData['password'];

                header("Location: admin_panel.php");
                die;
            } else {
                header("Location: admin_login.php?invalid");
            }
        } else {
            header("Location: admin_login.php?invalid");
        }
    } else {
        header("Location: admin_login.php?invalid");
    }
}

?>