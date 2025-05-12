# RiverSpain - Arquitectura de Microservicios con Spring Boot y Docker

RiverSpain es un sistema distribuido desarrollado como proyecto académico, enfocado en la gestión de información relacionada con ríos, peces, zonas protegidas, voluntariado ambiental y envío de notificaciones por correo. La aplicación está construida bajo una arquitectura de microservicios utilizando **Spring Boot**, **Spring Cloud**, **Eureka**, **Config Server**, **Docker** y **MySQL**.

## ⚙️ Tecnologías utilizadas

- **Spring Boot**: Framework para desarrollo de microservicios.
- **Spring Cloud Config Server**: Gestión centralizada de configuraciones.
- **Eureka Discovery Server**: Registro y descubrimiento de servicios.
- **Spring Data JPA & MySQL**: Persistencia de datos relacionales.
- **Feign Client**: Comunicación entre microservicios.
- **Docker & Docker Compose**: Contenerización y orquestación.
- **Swagger (OpenAPI 3)**: Documentación de APIs.
- **Arquitectura RESTful**: Diseño de APIs basado en REST.
- **Arquitectura orientada a microservicios**: Modularidad y escalabilidad.
- **Mockito y JUnit5**: Test de los microservicios.

## 📦 Estructura de microservicios

El proyecto está compuesto por los siguientes microservicios independientes:

- **Eureka Server**: Registro y descubrimiento de servicios.
- **Config Server**: Gestión centralizada de configuraciones externas.
- **Gateway**: Punto de entrada unificado para las solicitudes.
- **Usuarios**: Gestión de usuarios y autenticación.
- **Peces**: Registro y consulta de especies de peces.
- **Ríos**: Gestión de ríos y su relación con especies.
- **Zonas**: Administración de zonas protegidas.
- **Voluntarios**: Gestión de voluntarios y asignaciones.

> ⚠️ **Nota**: El microservicio de **batidas** ha sido migrado a un repositorio independiente por motivos de organización:  
> 👉 [https://github.com/JoseR23072/Proyecto-Api-informes](https://github.com/JoseR23072/Proyecto-Api-informes)

## 🚀 Despliegue de RiverSpain con Docker

Este documento detalla cómo clonar, configurar y ejecutar **RiverSpain** utilizando **Docker** y **Docker Compose**.

### 📋 Requisitos previos

Asegúrate de tener instalados los siguientes componentes:

#### 🐳 Docker
- **Última versión de Docker** compatible con tu sistema operativo (Windows, Linux o macOS).
- Descarga: [https://www.docker.com/products/docker-desktop](https://www.docker.com/products/docker-desktop)

#### 🧬 Git
- Necesario para clonar el repositorio.
- Descarga: [https://git-scm.com/downloads](https://git-scm.com/downloads)

#### ⚙️ Otros
- Conexión a internet para descargar imágenes de Docker y dependencias.
- Espacio suficiente en disco para imágenes y contenedores (~5 GB recomendado).

### 🔧 Pasos de instalación

#### 1. Clonar el repositorio
Clona el proyecto desde el repositorio oficial:

```bash
git clone <url_repositorio>
cd riverspain
```

> **Nota**: Reemplaza `<url_repositorio>` con la URL real del repositorio.

#### 2. Crear una red Docker personalizada
Crea una red personalizada para permitir la comunicación entre los contenedores:

```bash
docker network create riverspain_network
```

#### 3. Levantar los contenedores con Docker Compose
Desde la raíz del proyecto, ejecuta:

```bash
docker compose up --build
```

Esto construirá las imágenes de los microservicios y levantará los contenedores. Para ejecutar en modo detached (en segundo plano):

```bash
docker compose up --build -d
```

#### 4. Verificar el estado de los servicios
Accede a los siguientes endpoints para confirmar que los servicios están funcionando:

- **Eureka Server**: [http://localhost:8761](http://localhost:8761)

#### 5. Detener los contenedores
Para detener los servicios, usa:

```bash
docker compose down
```

### 🛠️ Solución de problemas

- **Puertos ocupados**: Asegúrate de que los puertos configurados (8761, 8888, 8080, etc.) no estén en uso.
- **Eureka no registra servicios**: Confirma que todos los microservicios están conectados a la red `riverspain_network`.

Consulta los logs para más detalles:

```bash
docker compose logs
```

## 📝 Estado del proyecto

- ✅ Arquitectura de microservicios estable.
- ✅ Comunicación entre servicios mediante Feign Client.
- ✅ Configuración centralizada con Spring Cloud Config.
- ✅ Servicio de descubrimiento con Eureka.
- 🛠️ En constante mejora y escalabilidad.

## 🤝 Contribuciones

Este proyecto es un trabajo académico individual, pero se aceptan sugerencias y mejoras. Si deseas contribuir:

1. Crea un **Issue** para discutir tu propuesta.
2. Realiza un **Fork** del repositorio.
3. Implementa tus cambios en una nueva rama.
4. Envía un **Pull Request** con una descripción clara de las modificaciones.

## 📜 Licencia

Este proyecto está licenciado bajo la [MIT License](LICENSE).
