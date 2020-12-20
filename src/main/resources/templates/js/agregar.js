var btnAccep = document.getElementById("sub"); 
btnAccep.addEventListener('click', function(){

    axios.post('https://cole-sag.herokuapp.com/agregarMaestro', {
        
        name: document.getElementById('name').value,
        rfc: document.getElementById('rfc').value,
        curp: document.getElementById('curp').value,
        imparte: document.getElementById('inputImparte').value,
        grado: document.getElementById('inputGrado').value,
        materia: document.getElementById('materia').value,
        address: document.getElementById('address').value,
        edad: document.getElementById('age').value,
        phone: document.getElementById('nPhone').value,
        email: document.getElementById('mail').value,
        
    }).then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        var mensaje = document.getElementById("mensaje"); 
        mensaje.innerHTML = response.data;
    }).catch(function (error) {
        console.log(error)
    })
});