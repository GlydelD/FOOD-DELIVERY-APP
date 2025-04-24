<?php
  session_start();
  include_once 'sql/createDB.php';
  
  $token = $_SESSION['otp'];
  $fName = $_SESSION['firstName'];
  $lName = $_SESSION['lastName'];
  $pWord = $_SESSION['password'];
  $ema = $_SESSION['email'];
  $cNum = $_SESSION['cNumber'];
  
  if(isset($_GET["tokencode"])){
    $emailtoken = (int)$_GET['tokencode'];
    if($token == $emailtoken) {
      $query = "INSERT INTO users (firstName, lastName, password, email, cNumber)
      VALUES ('$fName', '$lName', '$pWord', '$ema', '$cNum')";
      header("Location: verify_email.php?success");
      $query_run = mysqli_query($conn, $query);
    }else {
      header("Location: verify_email.php?unsuccessful");
    }
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
            <?php
            if(isset($_GET['success'])){ ?>
            <img src="./media/circle-check-regular.svg" alt="Check" class="w-20 h-20 filter-secondary-100"><br>
            <h1 class="font-semibold text-2xl text-secondary-100">Successful</h1><br>
                <p class="text-txtgray-100">Email verified succesfully! You can now log in your account!</p>
                <button class="bg-gradient-to-tl from-secondary-100 to-primary-100 text-white font-semibold mt-2 rounded-sm sm:w-[10vw] p-2 w-[30vw]"><a href="login.php">Proceed to sign in!</a></button>
            <?php } ?>
            <?php
            if(isset($_GET['unsuccessful'])){ ?>
            <img src="./media/circle-xmark-regular.svg" alt="Check" class="w-20 h-20 filter-red-100"><br>
            <h1 class="font-semibold text-2xl text-redbutton-100">Unsuccessful</h1><br>
                <p class="text-txtgray-100">Email link expired!</p>
                <button class="bg-gradient-to-tl from-secondary-100 to-primary-100 text-white font-semibold mt-2 rounded-sm sm:w-[10vw] p-2 w-[30vw]"><a href="homepage.php">Back to home!</a></button>
            <?php } ?>
        </div>
    </div>
</body>
</html>