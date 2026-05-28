# Análisis inicial de calidad - Sistema Pokémon

## Estado inicial del proyecto

El proyecto fue clonado y ejecutado localmente utilizando Java 21 y Maven 3.9.16.

Resultado inicial:

- Compilación del proyecto: BUILD SUCCESS.
- El sistema original no cuenta inicialmente con pruebas unitarias.

## Clases principales analizadas

### Pokemon.java

La clase `Pokemon` administra:

- Puntos de vida actuales (`currentHp`).
- Ataque y defensa física.
- Ataque y defensa especial.
- Velocidad.
- Tipos del Pokémon.
- Movimientos disponibles.
- Aplicación de daño.
- Condición de derrota.

Se identificó que `currentHp` puede cambiar durante la batalla, mientras que atributos como tipo, ataque, defensa y velocidad están declarados como `final`.

### BattleSystem.java

La clase `BattleSystem` administra:

- Inicio y desarrollo del combate.
- Elección de movimientos.
- Orden de ataque según velocidad.
- Reemplazo de Pokémon derrotados.
- Identificación del ganador.

## Reglas de negocio analizadas

1. El Pokémon con mayor velocidad debe atacar primero.
2. El daño debe reducir correctamente el HP sin generar valores negativos.
3. La efectividad por tipo debe modificar el daño causado.
4. Un Pokémon queda derrotado cuando su HP llega a cero.
5. Durante un ataque solamente deben modificarse los puntos de vida.

## Hallazgo inicial

En `BattleSystem.java`, cuando dos Pokémon tienen la misma velocidad, se utiliza:

`random.nextBoolean()`

para decidir cuál ataca primero.

Sin embargo, la regla de negocio establece que, en caso de empate de velocidad, el sistema debe mantener un orden consistente y no aleatorio.

## Riesgo identificado

Este comportamiento puede generar resultados diferentes en batallas iguales, provocando una lógica de turnos inconsistente e injusta.

## Decisión de pruebas

Primero se probarán las reglas relacionadas con daño, vida y derrota, debido a que son comportamientos directos y verificables en la clase `Pokemon`.

Posteriormente se probarán la efectividad por tipo y el orden de turnos, incluyendo el caso de empate de velocidad que presenta un posible incumplimiento de la regla de negocio.