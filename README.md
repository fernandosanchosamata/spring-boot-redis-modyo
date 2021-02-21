# spring-boot-redis-modyo

# Título del Proyecto

_Acá va un párrafo que describa lo que es el proyecto_

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._

Mira **Deployment** para conocer como desplegar el proyecto.


### Pre-requisitos 📋

_Que cosas necesitas para instalar el software y como instalarlas_

```
Da un ejemplo
```

### Instalación 🔧

_Para la instalación es necesario tener el proyecto en github y tambien en crear una "app" en heroku, ademas de tenerlo conectados_

_Comando utilizados git_

```
git add .
git commit -m "cambios"
git push github master
```

_Comandos utilizados en Heroku para ver los logs_

```
heroku logs --tail
```
_Comandos utilizados en Heroku para ver las keys en la cache_

```
heroku redis:cli --confirm [nombre de app]
```

_Finaliza con un ejemplo de cómo obtener datos del sistema o como usarlos para una pequeña demo_

## Ejecutando las pruebas con curl ⚙️

### Obtener lista de pokemones por parametro inicio y cantidad 🔩

```
curl http://stark-sands-15413.herokuapp.com/api/pokemones?offset=1&limit=1
```

### Obtener pokemon por id ⌨️

```
curl http://stark-sands-15413.herokuapp.com/api/pokemon/1
```
### Obtener evoluciones por id ⌨️

```
curl http://stark-sands-15413.herokuapp.com/api/evoluciones/1
```

## Despliegue 📦

_El despliegue es automatico a heroku, aplicando los comandos anteriormente mencionados, al realizar push se realiza compilacion e instalación._

## Construido con 🛠️

_Menciona las herramientas que utilizaste para crear tu proyecto_

* [redis](https://redis.io/) - cache distruida
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spring boot](https://start.spring.io/) - Plantilla de Proyecto de cero


## Versionado 📌

Se utilizo [GitHub/spring-boot-redis-modyo](https://github.com/fernandosanchosamata/spring-boot-redis-modyo) para el versionado. 

## Autores ✒️
* **Fernando Alfredo Sancho Samata** - *Desarrollador java enterprise*

---
⌨️ con ❤️ por [Villanuevand](https://github.com/Villanuevand) 😊
