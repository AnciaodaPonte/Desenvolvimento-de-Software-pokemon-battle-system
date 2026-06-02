# Pokemon Battle System (Java)

# Sistema de Batallas Pokémon

Proyecto desarrollado en Java aplicando los principales conceptos de Programación Orientada a Objetos (POO) y buenas prácticas de Calidad de Software.

## Conceptos de POO Implementados

* Herencia
* Clases Abstractas
* Interfaces
* Encapsulamiento
* Polimorfismo

## Funcionalidades del Sistema

El sistema simula combates entre Pokémon considerando:

* Tipos de Pokémon
* Ataques y habilidades
* Velocidad y orden de turnos
* Cálculo de daño
* Efectividad entre tipos
* Condiciones de victoria y derrota

## Calidad de Software

Como parte del proceso de aseguramiento de la calidad, se implementaron las siguientes prácticas:

* Pruebas unitarias con JUnit 5
* Medición de cobertura de código mediante JaCoCo
* Validación de reglas de negocio críticas
* Casos de prueba válidos, inválidos y de borde
* Integración Continua (CI) con GitHub Actions
* Quality Gate con cobertura mínima del 85%
* Protección de la rama principal (main)

## Reglas de Negocio Evaluadas

* El Pokémon con mayor velocidad debe atacar primero.
* El daño debe reducir correctamente los puntos de vida.
* La efectividad de los ataques depende del tipo de Pokémon.
* Un Pokémon queda derrotado cuando sus puntos de vida llegan a cero.
* Durante el combate solo deben modificarse los puntos de vida (HP).

## Tecnologías Utilizadas

* Java
* Maven
* JUnit 5
* JaCoCo
* GitHub Actions
* GitHub
* IntelliJ IDEA

## Objetivo Académico

Este proyecto fue utilizado para aplicar conceptos de Calidad de Software y Sistemas, incluyendo análisis de riesgos, diseño e implementación de pruebas unitarias, medición de cobertura de código y automatización del control de calidad mediante integración continua.

