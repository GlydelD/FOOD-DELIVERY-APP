const sideBar = document.querySelector('#sideBar');

function toggleSideBar() {
    if( sideBar.style.display === 'none' || sideBar.style.display == '') {
         sideBar.style.display = 'flex'
    } else {
         sideBar.style.display = 'none'
    }
}
