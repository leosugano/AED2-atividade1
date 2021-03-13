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
    private static void divisionValues(Integer m, Integer value, Integer keySize) { //Ponto 2.1.a e 2.1.b
        for (int key = 0; key < keySize; key++) {
            try {
               if (hashes.division(key, m) == value) {
                   System.out.println("A chave com valor " + value + ": " + key);
               }
            } catch (incorrectInputException error) {
                System.out.println(error);
                return;
            }
        }
    }
    
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
    private static void line() {
      System.out.println("-----------------------------------------");
    }

    private static void printArray(int[] array) {
        for (int lenght = 0; lenght < array.length; lenght++) {
            System.out.println("pos: " + lenght + " value: " + array[lenght]);
        } 
    }
}
