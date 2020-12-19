var btnAccep = document.getElementById("sub"); 
btnAccep.addEventListener('click', function(){
    $('#exampleModal').modal('hide');
    axios.post('https://cole-sag.herokuapp.com/modificar', {
        ID : document.getElementById('ID').value,
        name: document.getElementById('name').value,
        rfc: document.getElementById('rfc').value,
        curp: document.getElementById('curp').value,
        imparte: document.getElementById('inputImparte').value,
        grado: document.getElementById('inputGrado').value,
        materia: document.getElementById('materia').value,
        address: document.getElementById('address').value,
        edad: document.getElementById('age').value,
        phone: document.getElementById('nPhone').value,
        email: document.getElementById('mail').value
    }).then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        var mensaje = document.getElementById("result"); 
        mensaje.innerHTML = response.data;
        $('#realizado').modal('show')
    }).catch(function (error) {
        console.log(error)
    })
});