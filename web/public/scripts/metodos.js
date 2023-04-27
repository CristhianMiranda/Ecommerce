function convertirFecha(fecha) {
    let fechaConvertida = new Date(fecha);
    let dia = fechaConvertida.getDate();
    let mes = fechaConvertida.toLocaleString('default', {month: 'long'});
    let anio = fechaConvertida.getFullYear();
    return dia + "-" + mes + "-" + anio;
}

function convertMinutesToHoursAndMinutes(minutes) {
    let hours = Math.floor(minutes / 60);
    let remainingMinutes = minutes % 60;
    return hours + " hrs y " + remainingMinutes + " min";
}


document.getElementById("lista").addEventListener("click", function(event) {
    event.preventDefault();
    /*let searchTerm = document.getElementById("searchTerm").value;*/
    axios.get(`http://localhost:8080/api/browser/cartelera`)
        .then(response => {
            document.getElementById("header").style.position = "static";
            document.getElementById("determinado").style.display="none";
            let responseContainer = document.getElementById("response");
            let peliculas = response.data;
            let resultados = '';

            peliculas.forEach(pelicula => {



                let fecha = convertirFecha(pelicula.estreno);
                let duracion = convertMinutesToHoursAndMinutes(pelicula.duracionPelicula);
                console.log(pelicula.estado);
                console.log(pelicula.estado==='Pre-estreno');
                switch(pelicula.estado)
                {

                    case 'Estreno':
                        console.log(pelicula.estado);
                        resultados += `
          <div id="diseno-pelicula">
          
          <div class="icon">+</div>
          <img id = "estado" src="logos/Estreno.png">
          <!--<p class="estilo">Estado: ${pelicula.estado}</p>-->
          <img id = "miniatura-pelicula"src="${pelicula.url_Imagen}" alt="Image">
          
          <p class="titulo-pelicula">${pelicula.nombre}</p>
          <p class="informacion-pelicula">Estreno: ${fecha}</p>
          <p class="informacion-pelicula">Género: ${pelicula.genero}</p>
          <p class="advertencia-pelicula">Recomendada para Mayores de ${pelicula.restriccionEdad} años</p>
          <p class="advertencia-pelicula">Duración: ${duracion}</p>
          
          <!--<p class="sipnosis-pelicula">${pelicula.sipnosis}</p>-->
          
         <!--<p class="estilo">Reparto: ${pelicula.reparto}</p>-->
          <br>
            <br>
            </div>
          `;

                        break;

                    case 'Pre-estreno':
                        console.log(pelicula.estado);
                        resultados += `
          <div id="diseno-pelicula">
          <div class="icon">+</div>
          <img id = "estado" src="logos/Pre-estreno.png">
          <!--<p class="estilo">Estado: ${pelicula.estado}</p>-->
          <img id = "miniatura-pelicula"src="${pelicula.url_Imagen}" alt="Image">
          
          <p class="titulo-pelicula">${pelicula.nombre}</p>
          <p class="informacion-pelicula">Estreno: ${fecha}</p>
          <p class="informacion-pelicula">Género: ${pelicula.genero}</p>
          <p class="advertencia-pelicula">Recomendada para Mayores de ${pelicula.restriccionEdad} años</p>
          <p class="advertencia-pelicula">Duración: ${duracion}</p>
          
          <!--<p class="sipnosis-pelicula">${pelicula.sipnosis}</p>-->
          
         <!--<p class="estilo">Reparto: ${pelicula.reparto}</p>-->
          <br>
            <br>
            </div>
          `;

                        break;

                    case 'Proximamente':
                        console.log(pelicula.estado);
                        resultados += `
            <div id="diseno-pelicula">
            <div class="icon">+</div>
            <img id = "estado" src="logos/Proximamente.png">
            <!--<p class="estilo">Estado: ${pelicula.estado}</p>-->
            <img id = "miniatura-pelicula"src="${pelicula.url_Imagen}" alt="Image">
            
            <p class="titulo-pelicula">${pelicula.nombre}</p>
            <p class="informacion-pelicula">Estreno: ${fecha}</p>
            <p class="informacion-pelicula">Género: ${pelicula.genero}</p>
            <p class="advertencia-pelicula">Recomendada para Mayores de ${pelicula.restriccionEdad} años</p>
            <p class="advertencia-pelicula">Duración: ${duracion}</p>
            
            <!--<p class="sipnosis-pelicula">${pelicula.sipnosis}</p>-->
            
           <!--<p class="estilo">Reparto: ${pelicula.reparto}</p>-->
            <br>
              <br>
              </div>
            `;

                        break;

                    default:
                        console.log(pelicula.estado);
                        resultados += `
        
          <div id="diseno-pelicula">
          <div class="icon">+</div>
          <!--<p class="estilo">Estado: ${pelicula.estado}</p>-->
          <img id = "miniatura-pelicula"src="${pelicula.url_Imagen}" alt="Image">
          
          <p class="titulo-pelicula">${pelicula.nombre}</p>
          <p class="informacion-pelicula">Estreno: ${fecha}</p>
          <p class="informacion-pelicula">Género: ${pelicula.genero}</p>
          <p class="advertencia-pelicula">Recomendada para Mayores de ${pelicula.restriccionEdad} años</p>
          <p class="advertencia-pelicula">Duración: ${duracion}</p>
          
          <!--<p class="sipnosis-pelicula">${pelicula.sipnosis}</p>-->
          
         <!--<p class="estilo">Reparto: ${pelicula.reparto}</p>-->
          <br>
          </div>
        `;

                }






            });
            responseContainer.innerHTML = resultados;

            let randomColor = function () {
                let r = Math.floor(Math.random() * 256);
                let g = Math.floor(Math.random() * 256);
                let b = Math.floor(Math.random() * 256);
                return "rgb(" + r + "," + g + "," + b + ")";
            };

            let images = document.querySelectorAll("#miniatura-pelicula");
            images.forEach(function(image) {
                image.style.boxShadow = "0px 255px 183px 12px " + randomColor();
            });
        })
        .catch(error => {
            console.error('Ha ocurrido un error:', error);
        });

});

