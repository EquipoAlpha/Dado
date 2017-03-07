#Proyecto Dado

Proyecto Web 2.5 desallorado con Java6 y Spring 3.


![Alt text](documentacion/screenshot.png?raw=true 'pantallazo Dado 2.0')

## Requisitos:

	Es necesario tener instalado el siguiente entorno para poder ejecutar la App:
	-Java JDK 6 o superior
	-SGBD: MySQL 5.0.8 o superior
	-Servidor Aplicaciones Tomcat6 o superior


## Instalacion:

	-Importar script de la carpeta "deploy/install.sql
	-Desplegar "deploy/dado.war" en Tomcat
	-Acceder mediante el navegador a la url: "http://localhost.8080/dado"

	*Si se desea cambiar las credenciales de la base de datos, modificar el fichero: 	"src\main\resources\database.properties" y volver a generar el WAR

##Login
	El login de la App es el siguiente:
		-Usuario: admin
		-Password: admin