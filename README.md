# HomeBanking
Hexagonal Arquitecture Example


Ejemplo de aplicación bancaria con Arquitectura Hexagonal (Ports & Adapters) y Domain-Driven Design (DDD)

Este proyecto es un ejemplo de cómo estructurar una aplicación (en este caso un modelo de home banking básico) en Java utilizando arquitectura hexagonal con adaptadores y puertos y principios de DDD (Domain Driven Design). La aplicación está diseñada para mantener el dominio del negocio independiente de las tecnologías externas, como bases de datos o interfaces de usuario.

Este proyecto demuestra cómo estructurar una aplicación en Java utilizando una arquitectura hexagonal y principios de DDD.
La aplicación mantiene el núcleo del negocio independiente de las tecnologías externas y aplica la inversión de dependencias para que los casos de uso dependan de interfaces, no de implementaciones concretas.

# Arquitectura
La aplicación se organiza en torno a los siguientes componentes:
Domain (Core): Contiene las reglas de negocio esenciales, como entidades, value objects, agregados y servicios de dominio.
Application: Define los casos de uso que coordinan operaciones sobre el dominio. Aquí se definen los puertos (interfaces) que serán implementados por la infraestructura.
Adapters / Infrastructure: Implementaciones concretas de los puertos, como repositorios, APIs externas o controladores REST.

# Principios aplicados:
Domain-Driven Design (DDD): Separación clara entre dominio, casos de uso y adaptadores.
Arquitectura Hexagonal: Independencia del núcleo del negocio frente a infraestructuras externas.
Inversión de dependencias: Los casos de uso y el dominio dependen de interfaces (puertos); las implementaciones concretas de adaptadores se inyectan desde la infraestructura.
Testabilidad y mantenibilidad: El núcleo del negocio puede probarse sin necesidad de infraestructura concreta.

# Base de Datos
El proyecto utiliza PostgreSQL. Para levantar la base de datos, ejecuta:
docker compose -f docker-compose.yml up -d --build

#Compilar y ejecutar:
./mvnw spring-boot:run

# Acceder:
[POST](http://localhost:8000/homeBanking)
name: "nombre"

Respuesta:
{
    "balance": 0.0,
    "customerId": "f66e9e13-a6f0-4205-9b8f-cd4cb44009bb",
    "productId": "865f12c2-2eb2-4cb6-831d-5f14864c04a2"
}


# AddAmount -Ingresar dinero- :
[POST](http://localhost:8000/homeBanking/f66e9e13-a6f0-4205-9b8f-cd4cb44009bb/865f12c2-2eb2-4cb6-831d-5f14864c04a2/add/1000.00)

# TakeAmount -Retirar dinero-
[POST](http://localhost:8000/homeBanking/f66e9e13-a6f0-4205-9b8f-cd4cb44009bb/865f12c2-2eb2-4cb6-831d-5f14864c04a2/add/20.00)


