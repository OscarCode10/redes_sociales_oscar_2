const aside = document.getElementById('aside'),
        menu = document.getElementById('menu'); 
menu.onclick =()=>{
        console.log("Le diste");
        aside.classList.toggle('active')
}