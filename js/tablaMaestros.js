window.onload = function() {
    axios.post('http://127.0.0.1:4567/tablaMaestros', {
    })
    .then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        var divTabla = document.getElementById('table');
        var tabla = document.createElement('table');
        tabla.setAttribute("class", "table table-striped table-borderless table-hover");

        var headerTabla = document.createElement('thead');
        var renglonHeader = document.createElement('tr');

        var colMaestro = document.createElement('th');
        colMaestro.setAttribute("scope", "col");
        colMaestro.innerHTML = "Maestro";
        renglonHeader.appendChild(colMaestro);

        var colModificar = document.createElement('th');
        colModificar.setAttribute("scope", "col");
        colModificar.innerHTML = "Modificar";
        renglonHeader.appendChild(colModificar);

        var colEliminar = document.createElement('th');
        colEliminar.setAttribute("scope", "col");
        colEliminar.innerHTML = "Eliminar";
        renglonHeader.appendChild(colEliminar);

        headerTabla.appendChild(renglonHeader);
        tabla.appendChild(headerTabla);
        
        var bodyTabla = document.createElement('tbody');
        for (var clave in response.data){
            // Controlando que json realmente tenga esa propiedad
            if (response.data.hasOwnProperty(clave)) {
              
              var renglonBody = document.createElement('tr');

              var verMaestro = document.createElement('th');
              verMaestro.setAttribute("scope", "row");
              var anclaVer = document.createElement('a');
              anclaVer.setAttribute("href", "http://127.0.0.1:4567/verInfo?id="+response.data[clave].ID);
              anclaVer.innerHTML = response.data[clave].name;
              verMaestro.appendChild(anclaVer);
              renglonBody.appendChild(verMaestro);

              var modificarMaestro = document.createElement('td');
              var anclaMod = document.createElement('a');
              anclaMod.setAttribute("href", "http://127.0.0.1:4567/getDatos?id="+response.data[clave].ID);
              anclaMod.setAttribute("class", "btn btn-warning");
              var imgMod = document.createElement('img');
              imgMod.setAttribute("src", "../Bootstrap/iconos/pencil.svg");
              anclaMod.appendChild(imgMod);
              modificarMaestro.appendChild(anclaMod);
              renglonBody.appendChild(modificarMaestro);

              var eliminarMaestro = document.createElement('td');
              var anclaDel = document.createElement('a');
              anclaDel.setAttribute("href", "http://127.0.0.1:4567/eliminar?id="+response.data[clave].ID+"&name="+response.data[clave].name);
              anclaDel.setAttribute("class", "btn btn-danger");
              var imgDel = document.createElement('img');
              imgDel.setAttribute("src", "../Bootstrap/iconos/trashcan.svg");
              anclaDel.appendChild(imgDel);
              eliminarMaestro.appendChild(anclaDel);
              renglonBody.appendChild(eliminarMaestro);

              bodyTabla.appendChild(renglonBody);
            }
        }
        tabla.appendChild(bodyTabla);
        divTabla.appendChild(tabla);
    })
    .catch(function (error) {
        console.log(error)
    })
};
/*var bLogeo = document.getElementById("singin");
bLogeo.addEventListener('click', function(){
    
    //crea parámetros
    const parametros = new URLSearchParams();
    parametros.append("email", document.getElementById("email").value);
    parametros.append("password", document.getElementById("password").value);
    parametros.append("id", document.getElementById("id").value);
    //axios.get('http://127.0.0.1:4567/hello?'+parametros)
    //.then(function(response){
    //    console.log(response)
    //    console.log(response.data)
    //    console.log(response.statusText)
    //    document.getElementById("Titulo").innerHTML=response.data
    //})
    //.catch(function(error){
    //    console.log(error)
    //})

    //manda los parámetros a queryparams con el método get
    // axios.get('http://127.0.0.1:4567/queryparams?'+parametros)
    // .then(function(response){
    //    console.log(response)
    //    console.log(response.data)
    //    console.log(response.statusText)
    //    document.getElementById("Titulo").innerHTML=response.data
    // })
    // .catch(function(error){
    //    console.log(error)
    // })

    //Envía datos al servidor en apartado JSON con el método POST
    axios.post('http://127.0.0.1:4567/usuariosC', {
        email : document.getElementById('email').value,
        password : document.getElementById('password').value,
        id : document.getElementById('id').value
    })
    .then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        document.getElementById('titulo').innerHTML = response.data
    })
    .catch(function (error) {
        console.log(error)
    })

    // axios.post('http://127.0.0.1:4567/formdata', parametros)
    // .then(function(response){
    //     console.log(response)
    //     console.log(response.data)
    //     console.log(response.statusText)
    //     document.getElementById("Titulo").innerHTML=response.data
    // })
    // .catch(function(error){
    //     console.log(error)
    // })
});*/