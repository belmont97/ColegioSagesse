var btnAccep = document.getElementById("sub"); 
btnAccep.addEventListener('click', function(){

    axios.post('http://127.0.0.1:4567/modificar', {
        id : document.getElementById('ID').value

    })
    .catch(function (error) {
        console.log(error)
    })
});