var btnAccep = document.getElementById("yes"); 
bLogeo.addEventListener('click', function(){

    axios.post('http://127.0.0.1:4567/deleteMtro', {
        id : document.getElementById('inputID').value
    })
    .then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        
    })
    .catch(function (error) {
        console.log(error)
    })
});