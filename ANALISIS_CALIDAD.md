## Reporte de cobertura con JaCoCo

Se ejecutó el comando:

`mvn clean verify`

El proyecto compiló correctamente y se generó el reporte de cobertura con JaCoCo.

### Resultados obtenidos

- Instruction coverage total: 39 %.
- Branch coverage total: 19 %.
- Líneas totales: 490.
- Líneas no cubiertas: 237.
- Líneas cubiertas: 253.
- Line coverage calculado: 51.6 % aproximadamente.

### Interpretación

La cobertura obtenida no alcanza el 85 %, debido a que las pruebas implementadas se limitaron a las reglas de negocio solicitadas para la actividad.

No se agregaron pruebas adicionales para cubrir clases como `Trainer`, `BattleMenu`, `PokemonFactory` o `Main`, ya que el objetivo fue validar comportamientos críticos del sistema Pokémon y no aumentar cobertura artificialmente.

Las pruebas unitarias se enfocaron en:

- Orden de turnos según velocidad.
- Cálculo correcto del daño.
- Prevención de HP negativo.
- Efectividad por tipo.
- Condición de derrota.
- Conservación de atributos durante un ataque.

Este resultado demuestra que una cobertura baja no significa necesariamente que las pruebas sean inútiles; significa que el alcance probado fue específico. La cobertura debe interpretarse junto con las reglas de negocio y los riesgos funcionales analizados.