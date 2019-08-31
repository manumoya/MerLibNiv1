# Ejercicio MercadoLibre Nivel 1 (Agosto 2019)
###### Autor: [Manuel Moya - mmoyam@gmail.com]
El objetivo de este documento es detallar la resolución del caso MercadoLibre, donde se debe diseñar un algortimo que detecte mutantes basados su secuencia de ADN que será entregado.

### Enunciado

* Crear un programa con un método o función con la siguiente firma:

	**boolean isMutant(String[] dna);**

* En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. 
* Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.
* Un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales​, de forma oblicua, horizontal o vertical.
* Ejemplo (Caso mutante):

	**String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};**

* En este caso el llamado a la función isMutant(dna) devuelve “true”.

### Entregable

Programa (java) que cumpla con el método solicitado

