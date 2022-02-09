$(document).ready(function() {

});

async function validar(){
 var validado = true;
  elementos = document.getElementsByClassName("login-username");
  for(i=0;i<elementos.length;i++){
    if(elementos[i].value == "" || elementos[i].value == null){
    validado = false
    }
  }
  if(validado){
  document.getElementById("registrar").disabled = false;
 verificarClave();
  }else{
 alert("Hay campos vacios")
  }
}

async function verificarClave (){
let clave=document.getElementById("clave").value;
let repite=document.getElementById("repetirclave").value;

if (clave!=repite){
alert ("Las claves no son iguales")
document.getElementById("repetirclave").focus();
}
else {
registrar()
}

}



async function registrar(){
let usu ={};
usu.nombre=document.getElementById('nombre').value;
usu.apellido=document.getElementById('apellido').value;
usu.email=document.getElementById('correo').value;
usu.clave=document.getElementById('clave').value;
usu.estado='A';

  const rawResponse = await fetch('api/usuarios/',{
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body:JSON.stringify(usu)

  });

alert ('Registrado con exito')
  window.location.href='index.html';
}