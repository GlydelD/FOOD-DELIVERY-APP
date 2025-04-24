<?php
    require_once("sql/createDB.php");
    session_start();

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./output.css">
    <title>Profile</title>
</head>
<body>
    <?php
        include 'nav.php';
    ?>
    <div class="bg-gradient-to-tl from-secondary-100 to-primary-100 w-full h-[50vh] absolute z-0">
    </div>
    <div class="w-full h-[100vh] flex flex-row justify-center items-center">
        <div class="bg-white shadow-md sm:w-[50vw] w-[70vw] sm:h-[50vh] rounded-md z-10 mt-[20vh] flex flex-col items-center">
            <div class="w-[15vh] h-[15vh] sm:w-[25vh] sm:h-[25vh] translate-y-[-6vh] sm:translate-y-[-10vh] shadow-md rounded-full">
                <img src="<?php echo $_SESSION['profilePic'] ?>" class="w-full h-full rounded-full border-white border-4" alt="profile picture">
            </div>
            <div class="flex flex-col items-center translate-y-[-5vh]">
                <div>
                    <p class="p-2 sm:text-4xl text-xl font-semibold text-primary-100"><?php echo $_SESSION['fullName']?></p>
                </div>
                <p class="text-txtgray-100 sm:text-xl text-sm"><?php echo $_SESSION['emailLogin'] ?></p>
                <div class="text-center">
                    <p class="text-txtgray-100 "><?php echo $_SESSION['cNumber'] ?></p>
                </div>
                <div>
                    <a href="edit_profile.php"><button  class="p-2 bg-gradient-to-tl from-secondary-100 to-primary-100 w-[30vw] sm:w-[10vw] rounded-sm text-white font-semibold mt-2">Edit Profile</button></a>
                </div>
            </div>
        </div>
    </div>
    <script src="./script2.js"></script>
</body>
</html>