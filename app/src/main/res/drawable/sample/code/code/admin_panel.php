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
    <title>ADMIN PANEL</title>
</head>
<body class="border-box">
    <?php
        include 'admin_nav.php';
    ?>
    <!-- desktop view!!!!!!!!!!!!!! -->
    <div class="mt-[10vh]">
        <h1 class="flex text-primary-100 font-bold text-3xl ml-[5vw]"> List of Appointments</h1>

        <div class="flex overflow-hidden w-[90%] mx-auto mt-4 b" id="Con">
            <div class="" id="searchCon" >
                
                <form class="flex items-center " method="get" action="" >                                                       
                    <input type="text"                                                                                                                         
                        placeholder="Search your pet here" 
                        name="searchField" 
                        class="px-10 py-2 border  border-gray-400  bg-gray-50 focus:outline-none  w-full sm:w-auto mx-auto  justify-center ">
                                <button type="submit" class="flex items-center py-2 bg-primary-100 text-white text-sm font-medium  w-[100px]   justify-center ">
                            <img src="media/magnifying-glass-solid.svg" class="w-6 h-6 mr-3 filter-white inline-block ">
                            <span  class="hidden lg:inline">Search</span>
                        </button>
                </form>
            </div>
        </div>
        <div class="hidden lg:block w-[90%] mx-auto mt-2">
            <table class="table-fixed w-full border-collapse space-between " >
            <thead>
                <tr class="bg-gradient-to-tl from-secondary-100 to-primary-100 text-white">
                    <th class="px-1 py-1 text-center">Pet Owner</th>
                    <th class="px-1 py-1 text-center">Pet Name</th>
                    <th class="px-1 py-1 text-center">Breed</th>
                    <th class="px-1 py-1 text-center">Appointment Date</th>
                    <th class="px-1 py-1 text-center">Appointment Time</th>
                    <th class="px-1 py-1 text-center">Purpose</th>
                    <th class="px-1 py-1 text-center">Status</th>
                </tr>
            </thead>
            <tbody>
                <tr class="border-t border-gray-300">
                    <td class="px-1 py-1 text-center">Dino</td>
                    <td class="px-1 py-1 text-center">Dinosaur</td>
                    <td class="px-1 py-1 text-center">dinssssso</td>
                    <td class="px-1 py-1 text-center">Dino</td>
                    <td class="px-1 py-1 text-center">Dino</td>
                    <td class="px-1 py-1 text-center">Check up</td>
                    <td class="px-1 py-1 text-center flex gap-2">
                        <button class="p-2 w-[12rem] bg-secondary-100 font-semibold text-white">Accept</button>
                        <button class="p-2 w-[12rem] bg-redbutton-100 font-semibold text-white">Reject</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
         <!-- mobile view!!!!!!!!!!!! -->
    <div class="grid gap-3 lg:hidden w-[90%]  mx-auto mt-5 shadow-lg relative">
        <div class="flex">
            <div class="mt-7 ml-3 flex mb-10">
                <img src="media/profilepic.png" alt="Image" class="ml-4 w-[30vw] h-[20vh] rounded-lg">
            </div>
            <div class="w-2/3 mt-6 grid grid-cols-1 ml-[10vw] md:ml-[3vw] sm:ml-[3vw] py-5 text-sm"> 
                <div class=" font-semibold  text-gray-400 text-xl">NANA</div>
                <div class="  border-t-2 border-gray-400 mr-[3vw] "></div>
                <div class=" text-primary-100 font-semibold h-auto">Pet Owner:  <span class="text-gray-400"> Maria</span> </div>
                <div class=" text-primary-100 font-semibold">Appointment Date:  <span class="text-gray-400"> January 1, 2025</span> </div>
                <div class=" text-primary-100 font-semibold">Appointment Time:  <span class="text-gray-400"> 10:00am - 12:00pm</span> </div>
                <div class=" text-primary-100 font-semibold">Purpose:  <span class="text-gray-400"> Cheek up</span> </div>
                <div class="flex gap-2 justify-end p-2">
                <a href="update_Pet.html">
                <button class="py-1.5 px-6 w-auto bg-secondary-100 font-semibold text-sm text-white">
                    Accept
                </button>
            </a>    
            <button class="py-1.5 px-6 w-auto bg-redbutton-100 text-sm font-semibold text-white">
                Reject
            </button>
                </div>
            </div>
        </div>
    </div>
    <script src="./script2.js"></script>
</body>
</html>