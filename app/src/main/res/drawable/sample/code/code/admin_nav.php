<div id="sideBar" class="w-[260px] hidden h-screen bg-gradient-to-tl from-secondary-100 to-primary-100 flex-col fixed p-[6px] items-start top-0 left-0 transition-all duration-200 ease-in-out z-10">
        <div class="w-12 h-12 mb-10 flex justify-center items-center rounded-md cursor-pointer" onclick="toggleSideBar()">
            <img src="media/bars-solid.svg" alt="Side navigation menu" class="w-8 h-8 filter-white">
        </div>
        <div class="profile flex items-center mb-10">
            <div class="w-12 h-12 bg-white flex justify-center items-center rounded-md">
                <img src="media/user-solid.svg" alt="User photo" class="w-8 h-8 rounded-md filter-secondary-100">
            </div>
            <div class="text-white ml-2"> 
                <span class="labelSideBar font-bold">
                    Admin
                </span><br>
            </div>
        </div>
        <a href="homepage.php" class="flex items-center w-full hover:bg-secondary-100 hover:rounded-md">
                <div class="w-12 h-12 flex justify-center items-center rounded-md">
                    <img src="media/house-solid.svg" alt="Home icon" class="w-8 h-8 filter-white">
                </div>
            <span class="labelSideBar ml-2 font-semibold text-white">Home</span>
        </a>
        <a href="admin_panel.php" class="flex items-center w-full hover:bg-secondary-100 hover:rounded-md mt-2">
                <div class="w-12 h-12 flex justify-center items-center rounded-md">
                    <img src="media/calendar-solid.svg" alt="Pet list icon" class="w-8 h-8 filter-white">
                </div>
            <span class="labelSideBar ml-2 font-semibold text-white">Appointment</span>
        </a>
        <a href="appointment.php" class="flex items-center w-full hover:bg-secondary-100 hover:rounded-md mt-2">
                <div class="iconSideBar w-12 h-12 flex justify-center items-center rounded-md">
                    <img src="media/qrcode-solid.svg" alt="Appointment icon" class="w-8 h-8 filter-white">
                </div>
            <span class="labelSideBar ml-2 font-semibold text-white">QR Scanner</span>
        </a>
        <a href="history.php" class="flex items-center w-full hover:bg-secondary-100 hover:rounded-md mt-2">
                <div class="w-12 h-12 flex justify-center items-center rounded-md">
                    <img src="media/clock-rotate-left-solid.svg" alt="History icon" class="w-8 h-8 filter-white">
                </div>
            <span class="labelSideBar ml-2 font-semibold text-white">History</span>
        </a>
        <a href="admin_login.php" class="flex items-center w-full border-t-2 mt-10">
            <div class="w-12 h-12 flex justify-center items-center rounded-md">
                <img src="media/right-from-bracket-solid.svg" alt="Sign out icon" class="w-8 h-8 filter-white">
            </div>
        <span class="labelSideBar ml-2 font-semibold text-white">Sign out</span>
    </a>
    </div>
    <div class="header w-full h-[60px] shadow-lg flex items-center justify-end">
        <div class="w-[60px] h-[60px] flex justify-center items-center cursor-pointer absolute left-0" onclick="toggleSideBar()">
            <img src="media/bars-solid.svg" alt="Side navigation menu" class="w-8 h-8 filter-secondary-100">
        </div>
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" class="w-8 h-8 text-white" fill="currentColor">
            <path d="M0 96C0 78.3 14.3 64 32 64l384 0c17.7 0 32 14.3 32 32s-14.3 32-32 32L32 128C14.3 128 0 113.7 0 96zM0 256c0-17.7 14.3-32 32-32l384 0c17.7 0 32 14.3 32 32s-14.3 32-32 32L32 288c-17.7 0-32-14.3-32-32zM448 416c0 17.7-14.3 32-32 32L32 448c-17.7 0-32-14.3-32-32s14.3-32 32-32l384 0c17.7 0 32 14.3 32 32z"/>
        </svg>
        <div class="absolute left-0 ml-[70px]">
            <span class="font-black text-transparent bg-gradient-to-tl from-secondary-100 to-primary-100 bg-clip-text">VETSYSTEM | ADMIN</span>
        </div>
    </div>