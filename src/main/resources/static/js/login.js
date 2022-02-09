$(document).ready(function(){
});


async function loguear(){
let usu ={};
usu.email=document.getElementById('correo').value;
usu.clave=document.getElementById('clave').value;

  const rawResponse = await fetch('api/login',{
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body:JSON.stringify(usu)

  });

  const respuesta = await rawResponse.text();

  if (respuesta!='FAIL'){
  localStorage.token=respuesta;
  localStorage.correo=usu.email;
  window.location.href='tabla.html';
  }else{
  alert('Credenciales incorrectas');
  }

}