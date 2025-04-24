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
    <title>Set Appoinment</title>
    <style>
        .clicked {
            background-color: #ADD372;
            color: white;
            border-radius: 4px;
        }

        .day-cell {
            cursor: pointer;
            height: 10vh;
        }

        #calendar {
            display: grid;
            grid-template-columns: repeat(7, minmax(0, 1fr));
        }

        #selectTIME {
            display: grid;
            grid-template-columns: repeat(2, minmax(0, 1fr));
        }

        .time-slot {
            height: 7vh;
        }
    </style>
</head>
<body>
    <?php
    include 'nav.php';

    ?>
    <div class="w-full h-screen flex flex-col items-center">
        <div class="w-[90vw] h-screen flex flex-col items-center relative">
            <div class="w-[90%] mt-10">
                <div class="sm:text-4xl text-2xl font-bold text-primary-100" id="appointTitle">Book an Appointment</div>
                <div class="text-primary-100">Book an appointment for your  pet, fill up the form.</div>
            </div>
            <div class="w-full h-[90vh] sm:flex sm:flex-row flex flex-col">
                <div class="flex flex-col items-center justify-center sm:w-[45vw] w-full sm:h-[80vh] h-full">
                    <div class="w-[90%] h-full sm:h-[80%] flex flex-col text-primary-100 font-semibold shadow-md p-5 rounded-md">
                        <div class="flex justify-between items-center">
                            <div>
                                <span id="monthYear" class="text-2xl font-bold">December 2024</span>
                            </div>
                            <div>
                                <button class="w-10 text-3xl text-primary-100 hover:text-secondary-200" onclick="prevMonth()">&#11207;</button>
                                <button class="w-10 text-3xl text-primary-100 hover:text-secondary-200" onclick="nextMonth()">&#11208;</button>
                            </div>
                        </div>
                        <div id="calendar" class="calendar grid grid-cols-7 gap-1 bg-white text-txtgray-100 sm:text-2xl text-xl"></div>
                    </div>
                </div>
                <div class="flex flex-col items-center justify-center sm:w-[45vw] w-full sm:h-[80vh] h-full">
                    <div class="w-[90%] h-full sm:h-[80%] flex flex-col text-primary-100 font-semibold shadow-md p-5 rounded-md m-10 sm:m-0">
                        <input type="hidden" name="petId" value="<?php echo htmlspecialchars($petData['petId']);?>">
                        <input type="hidden" name="userId" value="<?php echo htmlspecialchars($petData['userId']);?>">
                        <input type="hidden" name="petName" value="<?php echo htmlspecialchars($petData['petName']);?>">
                        <input type="hidden" name="species" value="<?php echo htmlspecialchars($petData['species']);?>">
                        <input type="hidden" id="appointDate" name="appointDate" value="">
                        <input type="hidden" id="appointTime" name="appointTime" value=""> 
                        <div class="flex justify-between items-center">
                            <div>
                                <span class="text-2xl font-bold">Select Pet</span>
                            </div>
                        </div>
                        <div>
                            <!-- select pet -->
                            <select name="petName" class="w-full p-2 outline-none rounded-sm border-txtgray-100 border-[1px] text-txtgray-100">
                                <option value="" class="text-txtgray-100 p-2">Pet name</option>
                            </select>
                        </div>
                        <div class="mb-1 mt-2">
                            <span class="text-2xl font-bold">Purpose</span>
                        </div>
                        <div>
                            <!-- purpose -->
                            <input type="text" placeholder="Purpose of appointment" required name="purpose" class="w-full p-2 outline-none rounded-sm border-txtgray-100 border-[1px] text-txtgray-100">
                        </div>
                        <div class="mb-1 mt-2">
                            <span class="text-2xl font-bold">Select Time Slot</span>
                        </div>
                        <div id="selectTIME" class="grid sm:grid-cols-2 gap-3" id="timeSlots">
                            <button type="button" class="time-slot w-full border-2 border-secondary-100 p-2 text-secondary-100 rounded-sm" id="colorTime" onclick="secTimeSlot('8:00 - 10:00 AM', event)">8:00 - 10:00 AM</button>
                            <button type="button" class="time-slot w-full border-2 border-secondary-100 p-2 text-secondary-100 rounded-sm" id="colorTime" onclick="secTimeSlot('10:00 - 12:00 PM', event)">10:00 - 12:00 PM</button>
                            <button type="button" class="time-slot w-full border-2 border-secondary-100 p-2 text-secondary-100 rounded-sm" id="colorTime" onclick="secTimeSlot('1:00 - 3:00 PM', event)">1:00 - 3:00 PM</button>
                            <button type="button" class="time-slot w-full border-2 border-secondary-100 p-2 text-secondary-100 rounded-sm" id="colorTime" onclick="secTimeSlot('3:00 - 5:00 PM', event)">3:00 - 5:00 PM</button>
                        </div>
                        <div class="mt-4">
                            <button class=" p-2 rounded-sm w-full bg-gradient-to-tl from-secondary-100 to-primary-100 text-white">Appoint</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="./appointment.js"></script>
</body>
</html>