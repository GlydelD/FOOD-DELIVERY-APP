const sideBar = document.querySelector('#sideBar');

function toggleSideBar() {
    if( sideBar.style.display === 'none' || sideBar.style.display == '') {
         sideBar.style.display = 'flex'
    } else {
         sideBar.style.display = 'none'
    }
}


let curMonth = new Date().getMonth();
let curYer = new Date().getFullYear();
let secDate = null; 
document.addEventListener('DOMContentLoaded', () => {
    derCalendar(curMonth, curYer);
    updMonthYear();
});

function derCalendar(month, year) {
    const calendar = document.getElementById('calendar');
    calendar.innerHTML = ''; 

    const firstDay = new Date(year, month, 1).getDay();
    const daysInMonth = new Date(year, month + 1, 0).getDate();

    for (let i = 0; i < firstDay; i++) {
        const emptyCell = document.createElement('div');
        emptyCell.className = 'empty-cell';
        calendar.appendChild(emptyCell);
    }

    for (let day = 1; day <= daysInMonth; day++) {
        const dayCell = document.createElement('div');
        dayCell.className = 'day-cell p-3';
        dayCell.innerText = day;
        dayCell.onclick = (event) => selectDay(day, month, year, event);
        calendar.appendChild(dayCell);
    }
}

function updMonthYear() {
    const monthYear = document.getElementById('monthYear');
    const monthNames = [
        'January', 'February', 'March', 'April', 'May', 'June', 'July', 
        'August', 'September', 'October', 'November', 'December'
    ];
    monthYear.innerText = `${monthNames[curMonth]} ${curYer}`;
}

function prevMonth() {
    curMonth--;
    if (curMonth < 0) {
        curMonth = 11;
        curYer--;
    }
    derCalendar(curMonth, curYer);
    updMonthYear();
}

function nextMonth() {
    curMonth++;
    if (curMonth > 11) {
        curMonth = 0;
        curYer++;
    }
    derCalendar(curMonth, curYer);
    updMonthYear();
}
function selectDay(day, month, year, event) {
    secDate = `${year}-${month + 1}-${day < 10 ? '0' + day : day}`;
    document.getElementById('appointDate').value = secDate;
    
    const dayCells = document.querySelectorAll('.day-cell');
    dayCells.forEach(cell => cell.classList.remove('clicked'));

    event.currentTarget.classList.add('clicked');
}

function secTimeSlot(time, event) {
    const appointTimeInput = document.getElementById('appointTime');
    appointTimeInput.value = time; 

    const buttons = document.querySelectorAll('.time-slot');
    buttons.forEach((btn) => {
        btn.classList.remove('clicked');
    });

    event.currentTarget.classList.add('clicked'); 
}
function onDateClick(date) {
    const formattedDate = date.toISOString().split('T')[0]; 
    selectDate(formattedDate);
}

function bookAppointment() {
    if (!secDate || !selectedTimeSlot) {
        alert('select both  date og  time');
        return false; 
    }
    return true;
}