# Spring Boot con Redis  😊

_El proyecto construido por solicitud de modyo para postulación de trabajo, es una aplicación spring boot el cual consume una api externa, los datos consultados son almacenados en una cache distribuida Redis. La aplicacion tiene una arquitectura multicapa, el consumo de api externa es por medio de restTemplate, excepciones son centralizadas con  "ControllerAdvice" además de crear una factory de excepciones._
-Se implementa StructMapper-
_Se utilizan pruebas unitarias con mockito y de integración_
-Se valida con sonar-

## Comenzando 🚀

_ _


### Pre-requisitos 📋

```
- Eclipse 2020-12 o cualquiera de los ultimos
- Junit 5
- Java 8
- Maven 3.6.3
- Cuenta Heroku 
- Cuenta github
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
## Contrato con openapi ⚙️

### Se utiliza swagger de openapi 🔩

```
http://stark-sands-15413.herokuapp.com/swagger-ui.html
```
## Despliegue 📦

_El despliegue es automatico a heroku, aplicando los comandos anteriormente mencionados, al realizar push se realiza compilacion e instalación._

## Construido con 🛠️

_Herramientas destacadas_

* [redis](https://redis.io/) - cache distruida
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Spring boot](https://start.spring.io/) - Plantilla de Proyecto de cero
* Sonar Lint
* OpenApi (swagger)

## Versionado 📌

Se utilizo [GitHub/spring-boot-redis-modyo](https://github.com/fernandosanchosamata/spring-boot-redis-modyo) para el versionado. 

## Autores ✒️
* **Fernando Alfredo Sancho Samata** - *Desarrollador java enterprise*

---
