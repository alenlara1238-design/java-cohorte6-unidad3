# Taller de Excepciones en Java

## Objetivo general
Practicar el manejo de excepciones verificadas y no verificadas en Java, el uso de múltiples bloques `catch`, bloques `try-catch` anidados y la creación de excepciones personalizadas.

---

# Nivel 1: Manejo básico de excepciones

## Ejercicio 1: División segura (Unchecked Exception)

### Objetivo:
Practicar el manejo de una excepción no verificada (`ArithmeticException`).

### Enunciado:
Crea un programa que solicite al usuario dos números enteros y realice la división entre ellos.

Si el usuario intenta dividir entre cero, el programa debe capturar la excepción y mostrar un mensaje indicando que no es posible realizar esa operación.

### Indicaciones:
- Usa `Scanner` para pedir los números.
- Usa un bloque `try-catch`.
- Captura `ArithmeticException`.
- Muestra un mensaje amigable al usuario.

---

## Ejercicio 2: Acceso a arreglo (Unchecked Exception)

### Objetivo:
Practicar `ArrayIndexOutOfBoundsException`.

### Enunciado:
Declara un arreglo de 5 elementos y solicita al usuario una posición para consultar.

Si el usuario ingresa una posición inválida, captura la excepción y muestra un mensaje adecuado.

### Indicaciones:
- Crea un arreglo con valores fijos.
- Usa `Scanner`.
- Captura `ArrayIndexOutOfBoundsException`.

---

## Ejercicio 3: Lectura de archivo (Checked Exception)

### Objetivo:
Practicar una excepción verificada (`FileNotFoundException`).

### Enunciado:
Crea un programa que intente abrir un archivo llamado `datos.txt`.

Si el archivo no existe, captura la excepción y muestra un mensaje indicando el problema.

### Indicaciones:
- Usa `FileReader`.
- Usa `try-catch`.
- Captura `FileNotFoundException`.

---

# Nivel 2: Manejo intermedio de excepciones

## Ejercicio 4: Múltiples `catch`

### Objetivo:
Practicar el manejo de varias excepciones en una misma estructura.

### Enunciado:
Solicita al usuario dos números enteros y realiza una división.

Debes controlar:
1. Si el usuario divide entre cero.
2. Si el usuario ingresa texto en vez de números.

### Indicaciones:
- Usa `Scanner`.
- Usa un `try` con varios `catch`.
- Captura:
  - `ArithmeticException`
  - `InputMismatchException`

---

## Ejercicio 5: `catch` anidados

### Objetivo:
Practicar bloques `try-catch` dentro de otros bloques.

### Enunciado:
Crea un programa que:

1. Solicite el nombre de un archivo.
2. Intente abrir el archivo.
3. Dentro de ese proceso, solicite dos números y realice una división.

Debe manejar:
- `FileNotFoundException`
- `ArithmeticException`

### Indicaciones:
- Un `try-catch` externo para el archivo.
- Un `try-catch` interno para la división.

### Estructura sugerida:

```java
try {
    // abrir archivo

    try {
        // división
    } catch (...) {
    }

} catch (...) {
}
```

---

# Nivel 3: Excepciones personalizadas

## Ejercicio 6: Excepción personalizada simple

### Objetivo:
Crear y usar una excepción personalizada.

### Enunciado:
Diseña una excepción personalizada llamada `EdadInvalidaException`.

El programa debe solicitar la edad de una persona y lanzar la excepción si la edad es menor que 18.

### Indicaciones:
- Crear una clase que herede de `Exception`.
- Lanzarla usando `throw`.
- Capturarla en `main`.

---

## Ejercicio 7: Excepción personalizada en una clase

### Objetivo:
Aplicar excepciones personalizadas dentro de métodos.

### Enunciado:
Crea una clase `CuentaBancaria` con un método `retirar(double monto)`.

Si el monto es mayor que el saldo disponible, debe lanzar una excepción personalizada llamada `SaldoInsuficienteException`.

### Indicaciones:
- Crear la excepción personalizada.
- Crear el método `retirar`.
- Usar `throw`.
- Manejar la excepción en `main`.

---

## Ejercicio 8: Integrador

### Objetivo:
Combinar excepciones verificadas, no verificadas y personalizadas.

### Enunciado:
Crea un programa bancario que:

1. Intente leer un archivo de clientes.
2. Solicite un monto para retirar.
3. Si el monto es mayor al saldo, lance `SaldoInsuficienteException`.
4. Si el usuario ingresa datos inválidos, maneje la excepción correspondiente.

### Debe manejar:
- `FileNotFoundException`
- `InputMismatchException`
- `SaldoInsuficienteException`

---

# Recomendaciones generales

- Implementa cada ejercicio en una clase diferente.
- Usa mensajes claros para informar al usuario sobre cada error.
- Antes de ejecutar, analiza qué excepciones podrían ocurrir.
- Usa nombres descriptivos en clases, métodos y variables.
- Prueba cada programa con datos válidos e inválidos.

---

# Entrega sugerida

Organiza los ejercicios en carpetas según el nivel:

```bash
Nivel1/
Nivel2/
Nivel3/
```

Cada ejercicio debe contener:
- Código fuente `.java`
- Comentarios explicativos en el código

---

¡Éxitos desarrollando el taller!
