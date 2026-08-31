

### Api With Spring Boot And Postgres 
<p align = "center">
<img width = "500" heigth = "500" src="https://kbase.com.br/novo/wp-content/uploads/2020/09/BANNER-BLOG-5.png"> 
</p>

<div align = "center">
  
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) 
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white) 
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white) 
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
  
</div>



### For run
1. ```.\mvnw.cmd spring-boot:run```

##¿Qué significa Persistence?

La **persistencia** consiste en guardar información de una aplicación para que no se pierda cuando esta termina su ejecución.

Por ejemplo:

```text
Aplicación
    ↓
Objeto Customer
    ↓
Base de datos
    ↓
Tabla CUSTOMER
```

Si guardamos:

```java
Customer customer = new Customer();
customer.setName("Juan");
customer.setEmail("juan@email.com");
```

La información puede terminar almacenada en una tabla:

```text
CUSTOMER
--------------------------------
ID    NAME    EMAIL
1     Juan    juan@email.com
```

---

# Controller

Un **Controller (controlador)** es una clase encargada de recibir y procesar las **peticiones HTTP** que llegan a nuestra aplicación.

Es uno de los puntos de entrada de una petición.

```text
Cliente
   ↓
Petición HTTP
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
Base de datos
```

En Spring Boot, una clase se convierte en un controlador utilizando la anotación:

```java
@RestController
public class CustomerController {
}
```

---

## Anotaciones importantes

### `@RestController`

Indica que una clase es un **controlador REST** y que sus métodos pueden devolver directamente datos, normalmente en formato JSON.

```java
@RestController
public class CustomerController {
}
```

---

### `@RequestMapping`

Permite definir una **ruta base** para las peticiones del controlador.

```java
@RequestMapping("/customers")
```

Por ejemplo:

```text
/customers
```

Las rutas de los métodos del controlador pueden utilizar esta ruta como base.

---

### `@GetMapping`

Indica que un método responde a una petición HTTP **GET**.

```java
@GetMapping("/all")
public List<Customer> getCustomers() {
    // ...
}
```

La petición sería:

```text
GET /customers/all
```

---

### `@PostMapping`

Indica que un método responde a una petición HTTP **POST**, normalmente utilizada para crear un nuevo recurso.

```java
@PostMapping
public Customer createCustomer(@RequestBody Customer customer) {
    // ...
}
```

---

### `@PutMapping`

Indica que un método responde a una petición HTTP **PUT**, normalmente utilizada para actualizar un recurso.

```java
@PutMapping
public Customer updateCustomer(@RequestBody Customer customer) {
    // ...
}
```

---

### `@DeleteMapping`

Indica que un método responde a una petición HTTP **DELETE**, normalmente utilizada para eliminar un recurso.

```java
@DeleteMapping("/{id}")
public void deleteCustomer(@PathVariable Long id) {
    // ...
}
```

---

### `@RequestBody`

Indica que los datos enviados en el **cuerpo de la petición HTTP** deben convertirse en un objeto Java.

```java
@PostMapping
public Customer createCustomer(@RequestBody Customer customer) {
    // ...
}
```

Por ejemplo, el cliente puede enviar:

```json
{
    "name": "Juan",
    "email": "juan@email.com"
}
```

Spring convierte estos datos en un objeto `Customer`.

---

### `@PathVariable`

Permite obtener un valor directamente desde la URL.

```java
@GetMapping("/{id}")
public Customer getCustomer(@PathVariable Long id) {
    // ...
}
```

Petición:

```text
GET /customers/10
```

Entonces:

```text
id = 10
```

---

### `@RequestParam`

Permite obtener parámetros enviados en la URL.

```java
@GetMapping
public Customer getCustomer(@RequestParam Long id) {
    // ...
}
```

Petición:

```text
GET /customers?id=10
```

Entonces:

```text
id = 10
```

---

# Service

Un **Service (servicio)** contiene la **lógica de negocio** de nuestra aplicación.

Se utiliza para separar las reglas de negocio del Controller.

```text
Controller
    ↓
Service
    ↓
Repository
```

En Spring Boot se utiliza normalmente `@Service`.

```java
@Service
public class CustomerService {

    public Customer createCustomer(Customer customer) {
        // Lógica de negocio
        return customer;
    }
}
```

**Idea principal:**

> El Service se encarga de **qué debe hacer la aplicación**.

---

# Repository

Un **Repository (repositorio)** se encarga de **interactuar con la base de datos**.

En Spring Data JPA podemos utilizar `JpaRepository` para obtener operaciones como guardar, buscar, actualizar y eliminar.

```java
@Repository
public interface CustomerRepository
        extends JpaRepository<Customer, Long> {
}
```

Por ejemplo:

```java
customerRepository.save(customer);
customerRepository.findById(1L);
```

**Idea principal:**

> El Repository se encarga de **cómo acceder a los datos**.

# Entity

Una **Entity (entidad)** es una clase Java que representa una **entidad de la base de datos**, normalmente asociada a una tabla.

```text
Clase Java Employee
        ↓
@Table(name = "employees")
        ↓
Tabla EMPLOYEES
```

Se utiliza la anotación `@Entity` para indicarle a JPA que la clase será persistida en la base de datos.

`@Table` permite indicar explícitamente el **nombre real de la tabla** en la base de datos.

```java
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    private String email;
    private String salary;
}
```

`@Column` permite indicar explícitamente el **nombre de la columna** correspondiente en la base de datos.

**Idea principal:**

> La Entity representa los datos que se almacenan en la base de datos.

---

# DTO (Data Transfer Object)

Un **DTO (Data Transfer Object)** es un objeto utilizado para **transportar los datos que necesitamos enviar o recibir** entre diferentes partes de nuestra aplicación.

No es necesario enviar todos los datos de una Entity.

Por ejemplo, si `Employee` tiene:

```text
id
name
email
salary
address
phone
```

Podemos crear un DTO que solamente necesite:

```java
public record EmployeeDTO(
    String name,
    String email
) {}
```

Entonces una petición puede enviar solamente:

```json
{
    "name": "Juan",
    "email": "juan@email.com"
}
```

En lugar de enviar todos los campos de la Entity.

**Idea principal:**

> La Entity representa los datos de la base de datos, mientras que el DTO define los datos que queremos **transferir**.

# JPA (Java Persistence API)

## 1. ¿Qué es JPA?

**JPA (Java Persistence API)** es una **especificación de Java** que define cómo trabajar con bases de datos relacionales utilizando objetos Java.

Su objetivo principal es facilitar el almacenamiento, consulta, actualización y eliminación de objetos Java en una base de datos.

En otras palabras:

```text
Objetos Java  <----->  Tablas de Base de Datos
```

Esta técnica se conoce como:

**ORM (Object-Relational Mapping)**

---
# Hibernate

**Hibernate** es una implementación de **JPA** que se encarga de realizar realmente la comunicación entre los objetos Java y la base de datos.

Mientras **JPA define las reglas**, **Hibernate las implementa**.

Por ejemplo, JPA define cómo debe funcionar el mapeo entre una clase Java y una tabla de la base de datos, mientras que Hibernate se encarga de realizar ese trabajo en la práctica.

---

# Flujo desde el Controller hasta la Base de Datos

Cuando llega una petición a nuestra aplicación, normalmente tenemos un flujo parecido a este:

```text
Cliente
   ↓
Controller
   ↓
Service
   ↓
IUsuarioRepository
   ↓
Spring Data JPA
   ↓
Hibernate
   ↓
JDBC
   ↓
Base de datos
```

## Resumen de cada concepto

```text
Controller
→ Recibe las peticiones HTTP.

DTO
→ Transporta únicamente los datos necesarios.

Service
→ Contiene la lógica de negocio.

Repository
→ Se encarga del acceso a los datos.

JPA
→ Define la especificación para trabajar con persistencia.

Hibernate
→ Implementa JPA y realiza la comunicación con la DB.

Entity
→ Representa los datos que se almacenan en la DB.

@Table / @Column
→ Indican qué tabla y columnas representan los atributos de la Entity.
```

