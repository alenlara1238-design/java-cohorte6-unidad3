# Ejercicios Progresivos de Test Unitarios con Java y JUnit 5

## Objetivo General

Estos ejercicios están diseñados para que los estudiantes aprendan a identificar:

- reglas de negocio
- comportamientos esperados
- casos inválidos
- cambios de estado
- escenarios límite

El enfoque NO es aprender únicamente asserts de JUnit, sino desarrollar pensamiento de testing.

---

# Ejercicio 1 — Sistema de Cuenta Bancaria 💳

## Objetivo pedagógico

Aprender a identificar:

- estados
- límites
- reglas de negocio
- operaciones válidas e inválidas

---

## Código base

```java
public class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {

        if (monto > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        saldo -= monto;
    }
}
```

---

# FASE 1 — Comprender el comportamiento

## Preguntas para análisis

### Estado inicial

- ¿Cómo debería iniciar el saldo?
- ¿Puede iniciar en negativo?
- ¿Qué garantiza el constructor?

---

### Flujo feliz

- ¿Qué debería pasar al depositar?
- ¿Qué debería pasar al retirar correctamente?

---

### Casos inválidos

- ¿Qué NO debería permitirse?
- ¿Qué pasa si intentan retirar más dinero del disponible?
- ¿Qué ocurre si depositan números negativos?

---

### Límites

- ¿Qué pasa si retiran exactamente el saldo disponible?
- ¿Qué pasa si retiran 0?

---

# FASE 2 — Clasificar escenarios

| Tipo | Escenario |
|---|---|
| Estado inicial | cuenta inicia con saldo correcto |
| Flujo feliz | depositar aumenta saldo |
| Flujo feliz | retirar disminuye saldo |
| Límite | retirar saldo exacto |
| Error | retirar más del saldo |
| Entrada inválida | depositar negativo |

---

# RETO

## “Escriban un test por cada regla.”

NO por método.  
Por regla.

---

# Preguntas guía

- ¿Qué comportamiento promete el sistema?
- ¿Cómo intentarían romper esta cuenta bancaria?

---

---

# Ejercicio 2 — Carrito de Compras 🛒

## Objetivo pedagógico

Aprender:

- acumulación de estado
- validaciones
- pruebas sobre colecciones
- consistencia del sistema

---

## Código base

```java
import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<String> productos = new ArrayList<>();

    public void agregarProducto(String producto) {

        if (producto == null || producto.isBlank()) {
            throw new IllegalArgumentException("Producto inválido");
        }

        productos.add(producto);
    }

    public int cantidadProductos() {
        return productos.size();
    }

    public boolean contieneProducto(String producto) {
        return productos.contains(producto);
    }
}
```

---

# FASE 1 — Comprender el sistema

## Preguntas pedagógicas

### Estado inicial

- ¿Cómo inicia el carrito?
- ¿Tiene productos inicialmente?

---

### Flujo feliz

- ¿Qué debe pasar al agregar un producto?
- ¿Qué debería pasar después de agregar varios?

---

### Estados

- ¿Cómo cambia el carrito después de agregar productos?
- ¿Qué información cambia?

---

### Casos inválidos

- ¿Qué entradas peligrosas existen?
- ¿Qué pasaría con null?
- ¿Qué pasaría con ""?

---

# FASE 2 — Tabla de análisis

| Tipo | Escenario |
|---|---|
| Estado inicial | carrito inicia vacío |
| Flujo feliz | agregar producto aumenta cantidad |
| Estado | producto agregado debe existir |
| Error | no permitir null |
| Error | no permitir texto vacío |

---

# RETO GUIADO

## Pregunta principal

### “¿Cómo demostrarían que el carrito realmente cambió?”

---

## Pregunta avanzada

### “¿Qué pasaría si agregan el mismo producto dos veces?”

(No responder todavía.  
Dejar que los estudiantes definan el comportamiento esperado.)

---

---

# Ejercicio 3 — Sistema de Reserva de Sala 🏢

## Objetivo pedagógico

Aprender:

- estados del sistema
- restricciones
- reglas de disponibilidad
- pruebas de transición de estado

---

## Código base

```java
public class Sala {

    private boolean reservada;

    public Sala() {
        this.reservada = false;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void reservar() {

        if (reservada) {
            throw new IllegalStateException("Sala ya reservada");
        }

        reservada = true;
    }

    public void liberar() {
        reservada = false;
    }
}
```

---

# FASE 1 — Descubrir reglas

## Preguntas pedagógicas

### Estado inicial

- ¿Cómo inicia la sala?
- ¿Está reservada al crearla?

---

### Flujo feliz

- ¿Qué debería pasar al reservar?

---

### Cambio de estado

- ¿Qué cambia dentro del objeto?

---

### Restricciones

- ¿Qué NO debería permitirse?
- ¿Qué pasa si reservan dos veces?

---

### Recuperación

- ¿Qué debería pasar después de liberar?

---

# FASE 2 — Clasificación de pruebas

| Tipo | Escenario |
|---|---|
| Estado inicial | sala inicia libre |
| Flujo feliz | reservar cambia estado |
| Error | no reservar dos veces |
| Estado | liberar vuelve a disponible |

---

# RETO PEDAGÓGICO

## Pregunta poderosa

### “¿Qué historia cuenta esta clase?”

Posibles respuestas esperadas:

- libre → reservada
- reservada → libre

Esto ayuda a comprender que:

# Los tests verifican transiciones de estado.

---

# Dinámica Didáctica Recomendada

## PASO 1

Ejecutar el programa.

NO hacer tests aún.

---

## PASO 2

Preguntar:

### “¿Qué reglas descubren?”

---

## PASO 3

Construir tabla:

- flujo feliz
- error
- límites
- estados

---

## PASO 4

Recién ahora:
escribir tests.

---

## PASO 5

Pregunta final:

### “¿Qué escenario importante NO estamos probando todavía?”

---

# Conclusión Pedagógica

El objetivo es que los estudiantes dejen de pensar:

> “Testing = assertEquals”

y comiencen a pensar:

> “Testing = verificar comportamientos, reglas y riesgos del sistema”.
