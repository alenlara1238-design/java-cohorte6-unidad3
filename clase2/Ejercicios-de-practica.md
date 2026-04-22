# Ejercicio 1: Sistema de préstamo de libros

Una biblioteca necesita gestionar el préstamo de libros a sus usuarios.

Cada libro tiene:

- un título,
- una cantidad disponible.

Cuando un usuario solicite un préstamo, el sistema debe verificar:

1. que la cantidad solicitada sea mayor que cero,
2. que haya suficientes unidades disponibles.

Si alguna regla no se cumple, debe lanzarse una excepción personalizada.

---

## Requisitos

### 1. Crear la clase `Libro`

Debe almacenar:

- título,
- cantidad disponible.

Debe implementar el método:

```java
prestar(int cantidad)
```
este método debe validar:

que la cantidad sea válida,
que existan unidades disponibles.

Si ocurre un error, debe lanzar la excepción correspondiente.
### 2. Crear la clase Biblioteca

Debe tener el método:
```java
procesarPrestamo(Libro libro, int cantidad)
```
Este método debe invocar el préstamo del libro y permitir que la excepción se propague.
### 3. Crear excepciones personalizadas

Debes implementar:

CantidadInvalidaException
LibroNoDisponibleException

Ambas deben heredar de ***Exception.***
### 4. Crear la clase Main

Debe:

crear un libro,
solicitar préstamos,
capturar excepciones,
mostrar mensajes al usuario.

Objetivo

Practicar la propagación básica:
```text
Libro -> Biblioteca -> Main
```


# Ejercicio 2: Reserva de cupos en cursos

## Contexto

Una institución necesita permitir que estudiantes reserven cupos en
cursos.

Cada curso tiene: - Nombre - Número de cupos disponibles

Cuando un estudiante intente reservar, el sistema debe validar: - Que la
cantidad de cupos solicitados sea válida - Que existan cupos suficientes

Si ocurre un problema, debe lanzarse una excepción.

------------------------------------------------------------------------

## Requisitos

### 1. Crear la clase `Curso`

Debe almacenar: - Nombre - Cupos disponibles

Debe implementar el método:

``` java
reservarCupo(int cantidad)
```

Este método debe: - Validar la cantidad solicitada - Verificar
disponibilidad de cupos - Lanzar excepciones cuando sea necesario

------------------------------------------------------------------------

### 2. Crear la clase `ServicioReservas`

Debe implementar el método:

``` java
realizarReserva(Curso curso, int cantidad)
```

Este método debe: - Llamar al método de reserva del curso - Propagar las
excepciones sin manejarlas

------------------------------------------------------------------------

### 3. Crear la clase `PlataformaCursos`

Debe implementar el método:

``` java
solicitarReserva(Curso curso, int cantidad)
```

Este método debe: - Delegar la operación al servicio de reservas

------------------------------------------------------------------------

### 4. Probar en `Main`

Debes probar los siguientes casos: - Una reserva válida - Una cantidad
inválida - Cupos insuficientes

------------------------------------------------------------------------

## Objetivo

Practicar la propagación de excepciones en varias capas:

Curso -\> ServicioReservas -\> PlataformaCursos -\> Main