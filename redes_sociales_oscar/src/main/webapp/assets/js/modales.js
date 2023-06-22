// let ventanaModal=document.getElementById("ventanaModal")
// let abrirModal=document.getElementById("abrirModal")
// let modal=document.querySelector("modal")

// abrirModal.onclick=function(){
//     ventanaModal.style.setProperty("display","flex")
// }

// let X=document.querySelector(".X")
// X.onclick=function(){
//     ventanaModal.style.setProperty("display","none")
// }

// window.onclick=function(event){
//     if (event.target == ventanaModal) {
//         ventanaModal.style.setProperty("display","none")
//     }
// }
// window.addEventListener("click",function(event){
//     if (event.target==modal) {
//         ventanaModal.style.setProperty("display","flex")
//     }
// })

let abrirModal=document.getElementById("abrirModal")
let modal=document.querySelector(".modal")
let ventanaModal=document.getElementById("ventanaModal")

abrirModal.onclick=function(){
    ventanaModal.style.setProperty("display","flex")
}

let X=document.querySelector(".X")
X.onclick=function(){
    ventanaModal.style.setProperty("display","none")
}

window.onclick=function(event){
    if (event.target == ventanaModal) {
        ventanaModal.style.setProperty("display","none")
    }
}
window.addEventListener("click",function(event){
    if (event.target==modal) {
        ventanaModal.style.setProperty("display","none")
    }
})


let abrirModalF=document.getElementById("abrirModalF")
let modalF=document.querySelector(".modalF")
let ventanaModalF=document.getElementById("ventanaModalF")

abrirModalF.onclick=function(){
    ventanaModalF.style.setProperty("display","flex")
}

let XF=document.querySelector(".XF")
XF.onclick=function(){
    ventanaModalF.style.setProperty("display","none")
}

window.onclick=function(event){
    if (event.target == ventanaModalF) {
        ventanaModalF.style.setProperty("display","none")
    }
}
window.addEventListener("click",function(event){
    if (event.target==modalF) {
        ventanaModalF.style.setProperty("display","none")
    }
})