<?php
    require_once("sql/createDB.php");
    session_start();

    if(isset($_SESSION['idLogin'])) {
        header("Location: profile.php");
        die;
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
    <div class="sm:flex sm:flex-row flex flex-col box-border">
        <div class="bg-gradient-to-tl from-secondary-100 to-primary-100 sm:w-[45vw] h-screen w-full flex flex-col justify-center items-center text-white text-center relative">
            <span class="absolute top-0 left-0 mt-10 ml-10 font-black">Placeholder logo</span>
            <p class="font-bold text-4xl">Register now!</p>
            <p class="mt-2 w-[80vw] sm:w-[35vw]">Create your account to unlock all the powerful features of our veterinary management system. From seamless patient tracking to efficient scheduling, VetSystem simplifies your daily operations so you can focus on what matters most—providing exceptional care. Sign up now and elevate your practice!</p>
            <a href="signup.html"><button class="border-white border-2 w-40 mt-2 p-1 rounded-md font-semibold">SIGN UP</button></a>
            <span class="absolute bottom-0 text-[12px] mb-5">VETSYSTEM 2024</span>
        </div>
        <div class="flex flex-col items-center sm:w-[55vw] w-screen h-screen relative">
            <?php
            if(isset($_GET['invalid'])){ ?>
            <div id="prompt" class="absolute mt-[40vh] sm:w-[30vw] sm:h-[30vh] w-[80vw] h-[30vh] bg-white rounded-md text-txtgray-100 shadow">
                <div class="flex flex-col items-center text-white">
                    <img src="./media/circle-xmark-regular.svg" alt="Check" class="w-14 h-14 filter-red-100 mt-5">
                    <h1 class="font-semibold sm:text-2xl text-redbutton-100 text-xl">Invalid Email or Password!</h1>
                    <p class="text-txtgray-100 mt-3">Please try again!</p>
                    <button id="close" onclick="closePrompt()" class="bg-gradient-to-tl from-secondary-100 to-primary-100 text-white font-semibold mt-2 rounded-sm sm:w-[10vw] p-2 w-[30vw]">Close</button>
                </div>
            </div>
            <?php } ?>
            <form action="login_validate.php" method="POST" class="flex flex-col items-center sm:w-[55vw] w-screen h-screen mt-[10vh]">
                <div class="flex flex-col sm:w-[40vw] w-[75%]">
                    <a href="homepage.php" class="mb-24 text-txtgray-100">&#8249;&nbsp;Back to home</a>
                    <p class="font-bold text-4xl text-primary-100 mb-12">Sign In</p>
                    <p class="font-bold text-md mb-1">Email</p>
                    <input autocomplete="off" required name="email" type="text" placeholder="sample@gmail.com" class="box-border text-txtgray-100 border-[0.5px] border-txtgray-100 outline-none p-2 rounded-[3px] w-full mb-2">
                    <p class="font-bold text-md mb-1">Password</p>
                    <input autocomplete="off" required name="password" type="password" placeholder="Password" class="box-border text-txtgray-100 border-[0.5px] border-txtgray-100 outline-none p-2 rounded-[3px] w-full mb-2">
                    <button class="text-white bg-gradient-to-tl from-secondary-100 to-primary-100 box-border border-[0.5px] font-semibold outline-none p-2 rounded-[3px] w-full mt-1 mb-1" type="submit">SIGN IN</button>
                    <div><span class="font-bold">Doesn't have an account?</span><a href="signup.html" class="font-bold text-primary-100 ml-2">Create an account</a></div>
                </div>
            </form>
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