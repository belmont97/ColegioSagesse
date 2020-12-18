function validar_iniciar_sesion(){
    var usuario, password1;

    // inicializa las variables usuario y password1 con los valores del formulario
    usuario = document.getElementById("usuario").value;
    password1 = document.getElementById("password").value;
    
    // verificamos que el usuario y el password no esten vacios
    if(usuario=="" || password1==""){
      alert("¡Todos los campos son requeridos!");
      return false;
    }else if(usuario.length>7){   // validamos que el usuario no sea mayor a 7 caracteres
      alert("La longitud del usuario es incorrecta");
      // si es mayor a 7, se limpian el campo usuario
      document.getElementById("usuario").value = "";  
      document.getElementById("usuario").focus();
      return false;
    }else if(password1.length>5){ // validamos que la contraseña no sea mayor a 5 caracteres
      alert("La longitud de la contraseña es incorrecta");
      document.getElementById("password").focus();
      return false;
    }

    // si los datos son válidos, se verifica que las credenciales coincidan
    // en este caso con  sagesse y admin
    if(usuario=="sagesse" && password1=="admin"){
        // si es correcto se abre la ventana de la pagina con el sistema
        window.open("http://127.0.0.1:4567/mainAdmin");
        //window.location.replace("http://127.0.0.1:4567/mainAdmin"); 

        // y se cierra la ventana del login
        window.close();
    }else{
        // en caso de que sean incorrectos el usuario o contraseña, se envía un mensaje de notificación
        alert("Credenciales inválidas, verifique!!!!");
        document.getElementById("usuario").value = "";
        document.getElementById("usuario").focus();
        document.getElementById("password").value = "";
        document.getElementById("password").focus();
        return false;
    }
  }