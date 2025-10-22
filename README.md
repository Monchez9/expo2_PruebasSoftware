# FOD Requisiciones - Sistema de Gestión de Proveedores

API REST para la gestión de proveedores (requisiciones) construida con Spring Boot 3.5.6, MariaDB y documentada con Swagger/OpenAPI.

## 📋 Tabla de Contenidos

- [Requisitos Previos](#requisitos-previos)
- [Configuración del Proyecto](#configuración-del-proyecto)
- [Ejecutar la Aplicación](#ejecutar-la-aplicación)
- [Ejecutar Tests con EvoMaster](#ejecutar-tests-con-evomaster)
- [Documentación API](#documentación-api)

---

## 🔧 Requisitos Previos

Antes de comenzar, asegúrate de tener instalado:

- **Java 17** o superior
- **Maven 3.8+** (incluido con el wrapper `./mvnw`)
- **MariaDB 11.8.3+** corriendo en `localhost:3307`
- **Docker Desktop** (para ejecutar EvoMaster)

### Base de Datos

1. Crear la base de datos:
```sql
CREATE DATABASE mydb;
```

2. Crear el usuario y dar permisos:
```sql
CREATE USER 'root'@'localhost' IDENTIFIED BY 'password!';
GRANT ALL PRIVILEGES ON mydb.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
```

3. Ejecutar el script de tablas:
```bash
mysql -h localhost -P 3307 -u root -p mydb < DB_Scripts/Tablas.sql
```

---

## ⚙️ Configuración del Proyecto

### 1. Clonar el Repositorio

```bash
git clone https://github.com/Monchez9/expo2_PruebasSoftware.git
cd fod_requisiciones
```

### 2. Configurar `application.properties`

El archivo ya está configurado para:
- **Puerto**: 3002
- **Base de datos**: MariaDB en localhost:3307
- **Credenciales**: root / password
- **Security**: Usuario admin / secret

### 3. Compilar el Proyecto

```bash
./mvnw clean package
```

---

## 🚀 Ejecutar la Aplicación

### Opción 1: Usando Maven

```bash
./mvnw spring-boot:run
```

### Opción 2: Usando el JAR

```bash
java -jar target/Fod_Requisiciones-0.0.1-SNAPSHOT.jar
```

La aplicación estará disponible en: **http://localhost:3002**

---

## 🧪 Ejecutar Tests con EvoMaster

EvoMaster es una herramienta de generación automática de tests que analiza tu API REST y genera tests de integración.

### Paso 1: Iniciar la Aplicación

```bash
# En una terminal
./mvnw spring-boot:run
```

Espera a que la aplicación esté lista (verás el mensaje "Started FodRequisicionesApplication")

### Paso 2: Ejecutar EvoMaster con Docker

```bash
# En otra terminal, desde el directorio raíz del proyecto
docker run --rm \
  --add-host=host.docker.internal:host-gateway \
  -v "$(pwd)/evomaster-output:/output" \
  webfuzzing/evomaster \
  --blackBox true \
  --bbSwaggerUrl http://host.docker.internal:3002/v3/api-docs \
  --bbTargetUrl http://host.docker.internal:3002 \
  --outputFormat JAVA_JUNIT_5 \
  --maxTime 60s \
  --outputFolder /output \
  --testSuiteFileName ProveedorTest
```

**Parámetros explicados:**
- `--blackBox true`: Modo black-box (no necesita acceso al código)
- `--bbSwaggerUrl`: URL de la especificación OpenAPI
- `--bbTargetUrl`: URL base de tu API
- `--outputFormat JAVA_JUNIT_5`: Genera tests en Java con JUnit 5
- `--maxTime 60s`: Tiempo de ejecución (ajustable)
- `--testSuiteFileName`: Nombre base de los archivos generados

### Paso 3: Visualizar el Reporte

EvoMaster genera un reporte HTML interactivo:

```bash
cd evomaster-output
python3 webreport.py
```

Esto abrirá automáticamente tu navegador en **http://localhost:8000** con:
- Estadísticas de cobertura
- Tests generados (faults, successes, others)
- Visualización de los casos de prueba

### Paso 4: Ejecutar los Tests Generados

```bash
# Compilar tests
./mvnw test-compile

# Ejecutar solo los tests de EvoMaster
./mvnw test -Dtest="ProveedorTest*"

# O ejecutar todos los tests
./mvnw test
```

**Resultado esperado:**
```
Tests run: 10, Failures: 0, Errors: 0, Skipped: 0
```

---

## 📚 Documentación API

### Swagger UI

Interfaz interactiva para probar la API:
- **URL**: http://localhost:3002/swagger-ui.html

### OpenAPI Specification (JSON)

Especificación completa de la API:
- **URL**: http://localhost:3002/v3/api-docs

### Endpoints Principales

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| GET | `/` | Información de la API | No |
| GET | `/api/proveedor` | Listar proveedores | Sí (admin/secret) |
| POST | `/api/proveedor` | Crear proveedor | Sí (admin/secret) |
| GET | `/api/proveedor/{id}` | Obtener proveedor | Sí (admin/secret) |
| PUT | `/api/proveedor/{id}` | Actualizar proveedor | Sí (admin/secret) |
| DELETE | `/api/proveedor/{id}` | Eliminar proveedor | Sí (admin/secret) |

### Autenticación

La API usa **HTTP Basic Authentication**:
- Usuario: `admin`
- Contraseña: `secret`

Ejemplo con curl:
```bash
curl -u admin:secret http://localhost:3002/api/proveedor
```

Evomaster no puede ejecutar nada de la API si no está autenticada, para ello correr el contenedor de evomaster con el siguiente comando:
````
 docker run --rm \
  --add-host=host.docker.internal:host-gateway \
  -v "$(pwd)/evomaster-output:/output" \
  webfuzzing/evomaster \
  --blackBox true \
  --bbSwaggerUrl http://host.docker.internal:3002/v3/api-docs \
  --bbTargetUrl http://host.docker.internal:3002 \
  --outputFormat JAVA_JUNIT_5 \
  --maxTime 60s \
  --outputFolder /output \
  --testSuiteFileName ProveedorTest \
  --header0 "Authorization: Basic YWRtaW46c2VjcmV0" 
  ````


En base 64
admin:secret = YWRtaW46c2VjcmV0 

---

## 📁 Estructura del Proyecto

```
fod_requisiciones/
├── src/
│   ├── main/
│   │   ├── java/ucr/fod/fod_requisiciones/
│   │   │   ├── FodRequisicionesApplication.java
│   │   │   ├── Modelos/
│   │   │   │   └── Proveedor.java
│   │   │   ├── Proveedores/
│   │   │   │   ├── ProveedorControlador.java
│   │   │   │   ├── ProveedorServicio.java
│   │   │   │   └── ProveedorRepositorio.java
│   │   │   └── Security/
│   │   │       └── SecurityConfig.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           ├── ProveedorTest_faults.java      # Tests generados por EvoMaster
│           ├── ProveedorTest_others.java      # Tests generados por EvoMaster
│           ├── ProveedorTest_successes.java   # Tests generados por EvoMaster
│           └── ucr/fod/fod_requisiciones/
├── DB_Scripts/
│   └── Tablas.sql
├── pom.xml
└── README.md
```

---

## 🛠️ Tecnologías

- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **Spring Security**
- **MariaDB 11.8.3**
- **SpringDoc OpenAPI 2.2.0** (Swagger)
- **Rest-Assured** (Testing)
- **JUnit 5** (Testing)
- **EvoMaster** (Generación automática de tests)

---

## 📝 Notas Importantes

### Tests Generados por EvoMaster

Los tests generados detectan:
- ✅ **Faults**: Inconsistencias entre tu API y la documentación Swagger
- ✅ **Edge Cases**: Casos límite (IDs negativos, valores nulos, etc.)
- ✅ **Successes**: Casos de éxito esperados

**Ejemplo de fault detectado:**
```
Fault101: Response status 401 not defined for path '/api/proveedor'
```
Significa: Tu API devuelve 401 cuando no hay autenticación, pero Swagger no documenta ese código de respuesta.

