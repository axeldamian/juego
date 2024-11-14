## Descripción

- Con fuerza bruta calculo todas las matrices 3x3 que cumplen:
-
- todos los numeros son distintos
- el numero siguiente esta en un lugar adyacente (menos ñas diagonales) 
- Si esta en un borde el siguiente puede ser 1 extremo opuesto (puede haber 2 extremos opuesyos, si es esquina)
- También se genera un tablero paralelo donde el siguiente coincide el color o forma.
- Son 600 y algo nada más, se tardan 4 segundos en calcularlas.
- 600 y algo no es nada al lado de matrices 3x3 con números del 1 al 9 distintos, 9! factorial combinaciones.
-
- Una vez que se calcula todo, se guarda en un set y se devuelve uno random en menos de 1 seg.
- Si no se apaga la aplicación se devuelve un tablero de juego y su solución en menos de 1 seg en los logs, en la respuesta un json con el tablero.
