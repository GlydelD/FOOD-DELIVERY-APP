<?php
    require_once("sql/createDB.php");
    session_start();

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link rel="stylesheet" href="./output.css">
</head>
<body>
    <div class="bg-gradient-to-tl from-secondary-100 to-primary-100 w-full h-screen flex flex-col items-center justify-center">
        <a href="homepage.php" class="absolute text-white top-10 text-xl left-10">&#8249;&nbsp;Back to home</a>
        <?php
            if(isset($_GET['invalid'])){ ?>
            <div id="prompt" class="absolute sm:w-[30vw] sm:h-[30vh] w-[80vw] h-[30vh] bg-white rounded-md text-txtgray-100 shadow">
                <div class="flex flex-col items-center text-white">
                    <img src="./media/circle-xmark-regular.svg" alt="Check" class="w-14 h-14 filter-red-100 mt-5">
                    <h1 class="font-semibold sm:text-2xl text-redbutton-100 text-xl">Invalid Username or Password!</h1>
                    <p class="text-txtgray-100 mt-3">Please try again!</p>
                    <button id="close" onclick="closePrompt()" class="bg-gradient-to-tl from-secondary-100 to-primary-100 text-white font-semibold mt-2 rounded-sm sm:w-[10vw] p-2 w-[30vw]">Close</button>
                </div>
            </div>
            <?php } ?>
        <div class="bg-white shadow-md sm:w-[40vw] w-[80vw] h-[50vh] rounded-md sm:h-[70vh] flex flex-col justify-center items-center">
            <div class="sm:w-[30vw] w-[70vw] h-auto">
                <form action="admin_validate.php" method="POST">
                    <div class="w-auto h-auto mb-10">
                        <span class="font-black text-transparent bg-gradient-to-tl from-secondary-100 to-primary-100 bg-clip-text text-[1.5rem] sm:text-3xl">VETSYSTEM | ADMIN</span>
                    </div>
                    <p class="font-bold text-md mb-1">Username</p>
                    <input autocomplete="off" required name="username" type="text" placeholder="Username" class="box-border text-txtgray-100 border-[0.5px] border-txtgray-100 outline-none p-2 rounded-[3px] w-full mb-2">
                    <p class="font-bold text-md mb-1">Password</p>
                    <input autocomplete="off" required name="password" type="password" placeholder="Password" class="box-border text-txtgray-100 border-[0.5px] border-txtgray-100 outline-none p-2 rounded-[3px] w-full mb-2">
                    <button class="text-white bg-gradient-to-tl from-secondary-100 to-primary-100 box-border border-[0.5px] font-semibold outline-none p-2 rounded-[3px] w-full mt-1 mb-1" type="submit">SIGN IN</button>
                </form>
            </div>
        </div>
    </div>
    <script>
        let promptCon = document.getElementById('prompt');

        function closePrompt() {
            if (promptCon) {
                promptCon.style.display = 'none';
            }
        }
    </script>
</body>
</html>