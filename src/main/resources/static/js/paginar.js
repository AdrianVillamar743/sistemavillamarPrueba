$(document).ready(function(){
 cargarpagina();
 $('#myTable').dataTable();
nombreUsuario();

});

async function nombreUsuario(){
document.getElementById('nombreusuario').outerHTML=localStorage.correo;
}

function getHeader(){
return {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      'Authorization': localStorage.token
};
}

async function cargarpagina(){
  const rawResponse = await fetch('api/usuarios', {
    method: 'GET',
    headers: getHeader()
  });
  const usuarios= await rawResponse.json();
let cuerpazo='';
let borrar='<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16"><path fill-rule="evenodd" d="M13.854 2.146a.5.5 0 0 1 0 .708l-11 11a.5.5 0 0 1-.708-.708l11-11a.5.5 0 0 1 .708 0Z"/><path fill-rule="evenodd" d="M2.146 2.146a.5.5 0 0 0 0 .708l11 11a.5.5 0 0 0 .708-.708l-11-11a.5.5 0 0 0-.708 0Z"/></svg>';
let editar='<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16"><path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/><path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/></svg>';

  for (let usuario of usuarios){
let botones='<td> <button  id="borrar" value="Borrar" onclick="eliminar('+usuario.id_usuario+')" class="btn btn-danger"  type="button">'+borrar+'</button> <button  class="btn btn-warning" id="EDITAR" value="EDITAR"     type="button">'+editar+'</button></td></tr>';

let cuerpo='<tr> <td>'+usuario.id_usuario+'</td> <td>'+usuario.nombre+'</td><td>'+usuario.apellido+'</td><td>'+usuario.email+'</td>'+botones;
 cuerpazo+=cuerpo;
  }


  document.querySelector('#myTable tbody').outerHTML=cuerpazo;
}


async function eliminar(id){

  if (!confirm('Desea eliminar este usuario?')) {
            return;
        }
  const rawResponse = await fetch('api/usuario/'+id, {
    method: 'DELETE',
    headers: getHeader()
  });
  location.reload();

}