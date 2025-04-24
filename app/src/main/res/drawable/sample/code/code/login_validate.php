<?php
require_once("sql/createDB.php");
session_start();

if ($_SERVER['REQUEST_METHOD'] == "POST") {
    $email = $_POST['email'];
    $password = $_POST['password'];
        
    if (!empty($email) && !empty($password)) {
        $query = "select * from users where email = '$email' limit 1";
        $result = mysqli_query($conn, $query);
        
        if ($result && mysqli_num_rows($result) > 0) {
            $userData = mysqli_fetch_assoc($result); 
            // userdata kay kuhaon niya isa ka row sa data na nagarepresent sa post email if existing

            // if existing si email then icompare niya ang password sa email na nakuha
            // if tama then isulod niya sa session variables ang tanan data ana na email
            if ($userData['password'] == $password) {
                $_SESSION['idLogin'] = $userData['userId']; // kani si session idLogin mao na imo tawagon or ipasa2 ba
                $_SESSION['firstNameLogin'] = $userData['firstName'];
                $_SESSION['lastNameLogin'] = $userData['lastName'];
                $_SESSION['emailLogin'] = $userData['email'];
                $_SESSION['cNumber'] = $userData['cNumber'];
                $_SESSION['password'] = $userData['password'];
                $_SESSION['profilePic'] = $userData['profilePicture'];
                $_SESSION['fullName'] =   $_SESSION['firstNameLogin'] . ' ' . $_SESSION['lastNameLogin'];

                // matik proceed na siya sa page pero save na ni si session variables
                header("Location: pet_list.php"); // ilisdi ra ni para malink
                die;
            } else {
                header("Location: login.php?invalid");
            }
        } else {
            header("Location: login.php?invalid");
        }
    } else {
        header("Location: login.php?invalid");
    }
}

?>