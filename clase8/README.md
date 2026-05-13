# Sistema Básico de Biblioteca

## Descripción del Proyecto

Este proyecto representa un sistema de biblioteca desarrollado con Java y probado con JUnit 5.

El objetivo principal NO es únicamente aprender sintaxis de testing, sino comprender cómo identificar:

- reglas de negocio
- comportamientos esperados
- estados del sistema
- restricciones
- escenarios inválidos

---

# Conceptos Trabajados

- Programación Orientada a Objetos
- Encapsulamiento
- Estados de un objeto
- Validaciones
- Colecciones (`List`)
- Búsqueda de elementos
- Reglas de negocio
- Excepciones
- Sobrescritura de `equals()`
- Test Unitarios con JUnit 5

---

# Reglas de Negocio Implementadas

## Clase `Libro`

- Un libro debe tener título válido.
- Un libro nuevo inicia disponible.
- Un libro prestado no puede prestarse otra vez.
- Un libro disponible no puede devolverse.

---

## Clase `Biblioteca`

- No se permiten libros nulos.
- No se permiten libros duplicados.
- La biblioteca puede buscar libros por título.
- Solo se pueden prestar libros existentes.
- Solo se pueden prestar libros disponibles.

---

# Objetivo Pedagógico

Comprender que:

> Los tests verifican comportamientos y reglas del sistema, no solamente métodos o asserts.

El estudiante debe aprender a pensar:

- ¿Qué debería ocurrir?
- ¿Qué no debería permitirse?
- ¿Qué podría romper el sistema?
- ¿Qué estados puede tener el objeto?

---

# Aprendizajes Esperados

Al finalizar este proyecto el estudiante debería ser capaz de:

- Identificar reglas de negocio.
- Diseñar escenarios de prueba.
- Diferenciar flujo feliz y casos inválidos.
- Comprender cambios de estado.
- Utilizar JUnit 5 para validar comportamientos.
- Entender la importancia de las excepciones.
- Comprender el propósito de `equals()` en colecciones.

---

# Idea Central del Proyecto

La meta principal es desarrollar pensamiento de testing.

Es decir, que el estudiante deje de pensar:

```text
"Testing = usar assertEquals"
```

y comience a pensar:

```text
"Testing = verificar comportamientos, reglas y riesgos del sistema"
```