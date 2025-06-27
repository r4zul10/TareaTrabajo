# Documentación

### Algunos comentarios acerca de la tarea.
Textualmente las instrucciones indican: 

{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
        {
            "number": "1234567",
            "citycode": "1",
            "contrycode": "57"
        },
        {
            "number": "55533",
            "citycode": "1",
            "contrycode": "57"
        }
    ]
}

Que se recibiran estos datos en esta estructura en un micro servicio web. Es necesario aclarar que los campos:

created : fecha de creación del usuario
modified : fecha de la última actualización de usuario
last_login : del último ingreso (en caso de nuevo usuario, va a coincidir con la
fecha de creación)

No son campos utilizables realmente dado que ete servicio no recibe el ID.



### Script DLL para la base de datos H2.

-- Secuencia para user.id
CREATE SEQUENCE IF NOT EXISTS user_seq START WITH 1 INCREMENT BY 1;

-- Secuencia para phone.id
CREATE SEQUENCE IF NOT EXISTS phone_seq START WITH 1 INCREMENT BY 1;

-- Tabla de usuarios
CREATE TABLE IF NOT EXISTS users (
    id BIGINT DEFAULT NEXT VALUE FOR user_seq PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255)
);

-- Tabla de teléfonos
CREATE TABLE IF NOT EXISTS phones (
    id BIGINT DEFAULT NEXT VALUE FOR phone_seq PRIMARY KEY,
    number VARCHAR(20),
    citycode VARCHAR(10),
    contrycode VARCHAR(10),
    user_id BIGINT,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);

### Para cambiar la prueba para base de bases local a base en memoria solo se deben usar estas dos propiedades.

spring.datasource.url=jdbc:h2:mem:testdb   #BD EN MEMORIA
spring.datasource.url=jdbc:h2:~/test       #BD LOCAL PARA PRUEBAS