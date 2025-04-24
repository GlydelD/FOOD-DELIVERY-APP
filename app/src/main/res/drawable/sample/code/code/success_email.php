<?php
    include_once 'sql/createDB.php';
    session_start();

    if($conn->connect_error) {
        die('Fatal error, unable to connect to database : '. $conn->connect_error);
    }else {
        if(isset($_POST["signupBtn"])){
            
            $firstName = $_POST['firstName'];
            $lastName = $_POST['lastName'];
            $password = $_POST['password'];
            $email = $_POST['email'];
            $cNumber = $_POST['cNumber'];
            $otp = randomOTP();

            $_SESSION['firstName'] = $firstName;
            $_SESSION['lastName'] = $lastName;
            $_SESSION['password'] = $password;
            $_SESSION['email'] = $email;
            $_SESSION['cNumber'] = $cNumber;
            $_SESSION['otp'] = $otp;
            
            header("Location: send_email.php");
        }
    }

    function randomOTP() {
        $otpCode = rand(100000, 999999);

        return $otpCode;
    }

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign in</title>
    <link rel="stylesheet" href="./output.css">
</head>
<body>
    <div class="absolute top-0 left-0 mt-10 ml-10 font-bold text-white text-xl">
        VETSYSTEM
    </div>
    <div class="bg-gradient-to-tl from-secondary-100 to-primary-100 flex flex-col items-center justify-center box-border w-screen h-screen">
        <div class="sm:w-[35vw] sm:h-[40vh] bg-white flex flex-col items-center justify-center shadow-md rounded-md">
            <img src="./media/circle-check-regular.svg" alt="Check" class="w-20 h-20 filter-primary-100"><br>
            <h1 class="font-semibold text-2xl text-primary-100">Successful</h1><br>
            <p class="text-txtgray-100">A verification link has been sent to your email.</p>
            <button class="bg-gradient-to-tl from-secondary-100 to-primary-100 text-white font-semibold mt-2 rounded-sm sm:w-[8vw] p-2 w-[30vw]"><a href="homepage.php">OK</a></button>
        </div>
    </div>
</body>
</html>