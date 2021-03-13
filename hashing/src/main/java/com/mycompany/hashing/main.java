/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hashing;

import hashes.*;

/**
 *
 * @author leo_s
 */
public class main {
    public static void main(String args[]) {
        hashFunctionWithDivision();
        line();
        hashFunctionWithMult();
    }
    
    //MARK: Abaixo os dois metodos que chamam todos os pontos da 2.1
    
    //Todas as questões usando o método de divisão ficam dentro dessa função
    private static void hashFunctionWithDivision() {
        System.out.println("Método da divisão");
        line();
        
        System.out.println("Teste 2a com m = 12 e valor = 3");
        divisionValues(12, 3, 100);
        line();
        
        System.out.println("Teste 2b com m = 11 e valor = 3");
        divisionValues(11, 3, 100);
        line();
        
        System.out.println("Teste 2c com chave = 10000 e m = 97");
        colisionsCount(97, 10000, 0, true);
        line();
    }
    
    //Todas as questões usando o método de multiplicação ficam dentro dessa função
    private static void hashFunctionWithMult() {
        System.out.println("Método da multiplicação");
        line();
        
        System.out.println("Teste 2a com m = 200 e A = 0.62");
        colisionsCount(200, 500000, 0.62, false);
        line();
        
        System.out.println("Teste 2b com m = 200 e A = 0.61803398875");
        colisionsCount(200, 500000, 0.61803398875, false);
        line();
    }
    
    //MARK: - Methods 
    //Nessa função temos a parte dos primeiros pontos, passando para ele o valor de m, o valor para comparar e o tamanho da key 
    //No exercicio temos o m variando de 11 e 12, o valor fixamente 3 e keysize de 0 a 100
    private static void divisionValues(Integer m, Integer value, Integer keySize) { //Ponto 2.1.a e 2.1.b
        for (int key = 0; key < keySize; key++) {
            try {
               if (hashes.division(key, m) == value) {
                   System.out.println("A chave resultando no valor " + value + ": " + key);
               }
            } catch (incorrectInputException error) {
                System.out.println(error);
                return;
            }
        }
    }
    
    //Nessa função temos o count das colisoes, para isso criei apenas um onde passo um boleano, dessa forma verifico com método hash deve ser chamado
    //Assim temos o valor m, o tamanho da key, o valor de a e o boolean para saber qual o metodo para ser chamado e comparado
    private static void colisionsCount(Integer m, Integer keySize, double a, Boolean itsDivision) {
        int[] array;
        array = new int[m];
        
        for (int key = 1; key <= keySize; key++) {
            try {
               int value = itsDivision ? hashes.division(key, m) : hashes.multiplication(m, key, a);
               if(value <= array.length) {
                   array[value] += 1;
               }
            } catch (incorrectInputException error) {
              System.out.println(error);
              return;
            }
        }
      
        printArray(array);
    }
    
    //MARK: - Aux functions
    //Uma função para imprimir somente uma linha para dividir a resposta
    private static void line() {
      System.out.println("-----------------------------------------");
    }

    //Uma função para imprimir um vetor passado 
    private static void printArray(int[] array) {
        for (int lenght = 0; lenght < array.length; lenght++) {
           System.out.println("pos: " + lenght + " value: " + array[lenght]);
        } 
    }
}
