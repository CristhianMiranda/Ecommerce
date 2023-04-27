


<h1 align="center"> Ecommerce</h1>
<p align="center"><img src="https://i.postimg.cc/DyhW1wJ7/logo.png"/></p> 

## Tabla de contenidos:
---


- [Descripción y contexto](#descripción-y-contexto)
- [Guía de instalación](#guía-de-instalación)
- [Información adicional](#información-adicional)


## Descripción y contexto
---
Este proyecto es una aplicación de ecommerce que permite a  clientes agregar productos, ver y consultar a su carrito de compras . El proyecto está desarrollado en Java con el framework Spring Boot y utiliza una base de datos MySQL, React js (Pendiente).


## Guía de instalación
---
Antes de ejecutar la aplicación, asegúrate de tener instalado:

- Java 11.
- MySQL.
- Spring Boot 2X.
- Npm

## Guía de instalación
1 Clona este repositorio: 

    https://github.com/CristhianMiranda/Ecommerce.git

2 Crea una bases de datos en MySql:

    create databases ecommerce;
    use ecommerce;

3. Actualiza el archivo application.properties con la información de tu base de datos: 

    
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_tu_bd
    spring.datasource.username=tu_usuario
    spring.datasource.password=tu_contraseña


## Información adicional
---
En la carpeta recursos_necesarios (VER), esta recursos para consumir las apis y demas otros archivos.

