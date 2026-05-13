# Micro-Ejercicios de Pensamiento QA
## Lectura de Código Ajeno y Análisis de Comportamiento

> Objetivo:
> entrenar la capacidad de leer código y descubrir:
>
> - qué promete el sistema
> - qué reglas existen
> - qué vulnerabilidades hay
> - qué escenarios deberían probarse
>
> La idea NO es programar inmediatamente.
>
> Primero:
> pensar como QA.

---

# EJEMPLO RESUELTO 1 — Detectar reglas y vulnerabilidades

## Código

```java
public class Cuenta {

    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public void retirar(double monto) {
        saldo -= monto;
    }

    public double getSaldo() {
        return saldo;
    }
}
```

---

# PASO 1 — ¿Qué promete este código?

## Posibles respuestas

- permite retirar dinero
- guarda un saldo
- el saldo cambia después de retirar

---

# PASO 2 — ¿Qué reglas deberían existir?

## Reglas esperadas

- no retirar más dinero del disponible
- no retirar números negativos
- el saldo no debería quedar negativo

---

# PASO 3 — ¿Qué vulnerabilidades detectamos?

## Problemas

Actualmente el sistema permite:

```java
cuenta.retirar(999999);
```

↓

saldo negativo.

---

También permite:

```java
cuenta.retirar(-100);
```

↓

retirar negativo en realidad suma dinero.

---

# PASO 4 — ¿Qué tests nacen naturalmente?

## Escenarios

- retirar correctamente
- retirar más del saldo
- retirar negativo
- retirar exactamente el saldo

---

# Enseñanza importante

## El test NO nació de JUnit.

Nació de esta pregunta:

> “¿Cómo podría romper este sistema?”

---

# EJEMPLO RESUELTO 2 — Pensamiento de estados

## Código

```java
public class Puerta {

    private boolean abierta;

    public void abrir() {
        abierta = true;
    }

    public void cerrar() {
        abierta = false;
    }

    public boolean isAbierta() {
        return abierta;
    }
}
```

---

# PASO 1 — Identificar estados

## Estados del objeto

```text
abierta = true
abierta = false
```

---

# PASO 2 — Identificar transiciones

```text
cerrada -> abrir() -> abierta

abierta -> cerrar() -> cerrada
```

---

# PASO 3 — Detectar posibles problemas

Actualmente:

```java
puerta.abrir();
puerta.abrir();
puerta.abrir();
```

NO genera error.

---

# Pregunta QA importante

## ¿Eso debería permitirse?

Ahí nace el análisis del negocio.

---

# PASO 4 — Escenarios de prueba

- puerta inicia cerrada
- abrir cambia estado
- cerrar cambia estado
- abrir varias veces
- cerrar varias veces

---

# Enseñanza importante

## Los objetos tienen estados.

Y muchos tests existen para verificar:
## cambios de estado.

---

# EJERCICIO 1 — Ahora tú

## Código

```java
public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}
```

---

# PASO 1 — ¿Qué promete esta clase?

Escribe:
- qué información guarda
- qué reglas deberían existir

---

# PASO 2 — Detecta vulnerabilidades

Pregúntate:

- ¿Puede existir un producto sin nombre?
- ¿Puede tener precio negativo?
- ¿Qué entradas peligrosas existen?

---

# PASO 3 — Diseña escenarios de prueba

Escribe mentalmente:

- flujo feliz
- casos inválidos
- límites

---

# EJERCICIO 2 — Encontrar reglas ocultas

## Código

```java
public class Sala {

    private boolean reservada;

    public void reservar() {

        if(reservada){
            throw new IllegalStateException();
        }

        reservada = true;
    }
}
```

---

# PASO 1 — ¿Qué regla protege este código?

Piensa:

- ¿qué comportamiento está prohibido?
- ¿qué situación intenta evitar?

---

# PASO 2 — Detectar estados

¿Cuáles son los estados posibles?

---

# PASO 3 — Pensar como QA

¿Cómo intentarías romper este sistema?

---

# PASO 4 — Escenarios de prueba

¿Qué probarías primero?

---

# EJERCICIO 3 — Analizar entradas inválidas

## Código

```java
public class LoginService {

    public boolean login(String user, String password) {

        if(user.equals("admin")
                && password.equals("1234")) {
            return true;
        }

        return false;
    }
}
```

---

# PASO 1 — ¿Qué promete este método?

---

# PASO 2 — Buscar vulnerabilidades

Preguntas importantes:

- ¿Qué pasa si `user` es null?
- ¿Qué pasa si `password` es null?
- ¿Existen riesgos de seguridad?

---

# PASO 3 — Escenarios QA

Piensa en:

- login correcto
- contraseña incorrecta
- usuario incorrecto
- null
- vacío

---

# EJERCICIO 4 — Buscar edge cases

## Código

```java
public class Temperatura {

    public boolean esCongelacion(int grados) {
        return grados < 0;
    }
}
```

---

# PASO 1 — ¿Qué promete?

---

# PASO 2 — Buscar límites peligrosos

Pregunta clave:

## ¿Qué ocurre exactamente en 0?

---

# PASO 3 — Escenarios importantes

- temperatura negativa
- temperatura positiva
- exactamente 0

---

# EJERCICIO 5 — Pensamiento de colecciones

## Código

```java
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<String> libros = new ArrayList<>();

    public void agregarLibro(String titulo) {
        libros.add(titulo);
    }
}
```

---

# PASO 1 — ¿Qué promete esta clase?

---

# PASO 2 — Detectar reglas faltantes

Preguntas QA:

- ¿Permite null?
- ¿Permite duplicados?
- ¿Permite vacío?
- ¿Eso debería permitirse?

---

# PASO 3 — Escenarios de prueba

Piensa en:

- agregar válido
- agregar null
- agregar duplicado
- agregar vacío

---

# Checklist QA Mental

Cuando lean código ajeno, háganse SIEMPRE estas preguntas:

---

## 1. ¿Qué promete este código?

---

## 2. ¿Qué reglas existen?

---

## 3. ¿Qué estados tiene?

---

## 4. ¿Qué NO debería permitirse?

---

## 5. ¿Cómo podría romperse?

---

## 6. ¿Qué casos límite existen?

---

## 7. ¿Qué probaría primero?

---

# Frase clave

> “El testing empieza leyendo y cuestionando el comportamiento del sistema.”
