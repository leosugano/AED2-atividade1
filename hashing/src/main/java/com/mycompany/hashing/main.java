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
        hashFunctionWithMult();
    }
    
    //MARK: - Parte das funções de divisões
    private static void hashFunctionWithDivision() {
        System.out.println("Método da divisão");
        line();
        System.out.println("Teste 2a com m = 12 e valor = 3");
        divisionTests(12);
        line();
        System.out.println("Teste 2b com m = 11 e valor = 3");
        divisionTests(11);
        line();
        System.out.println("Teste 2c com chave = 10000 e m = 97");
        colisionsCountDivionsMethod();
        line();
        line();
    }
    
    private static void divisionTests(Integer m) { //Ponto 2.1.a e 2.1.b
        for (int key = 0; key < 100; key++) {
            try {
               if (hashes.division(key, m) == 3) {
                   System.out.println("A chave com valor 3: " + key);
               }
            } catch (incorrectInputException error) {
                System.out.println(error);
                return;
            }
        }
    }
    
    private static void colisionsCountDivionsMethod() { //Ponto 2.1.c
        int[] array;
        array = new int[97];
        
        for (int key = 1; key <= 10000; key++) {
            try {
               int value = hashes.division(key, 97);
               if(value <= array.length) {
                   array[value] += 1;
               }
            } catch (incorrectInputException error) {
              System.out.println(error);
              return;
            }
        }
        
        for (int lenght = 0; lenght < array.length; lenght++) {
            System.out.println("pos: " + lenght + " value: " + array[lenght]);
        }
    }

    //MARK: - Parte das funções de multiplicação
    private static void hashFunctionWithMult() {
        System.out.println("Método da multiplicação");
        line();
        System.out.println("Teste 2a com m = 200 e A = 0.62");
        colisionsCountMultMethod(200, 0.62);
        line();
        System.out.println("Teste 2b com m = 200 e A = 0.61803398875");
        colisionsCountMultMethod(200, 0.61803398875);
    }
    
    private static void colisionsCountMultMethod(Integer m, double a) {
        int[] array;
        array = new int[200];
                
        for (int key = 1; key <= 500000; key++){
             try {
               int value = hashes.multiplication(m, key, a);
               if(value <= array.length ) {
                   array[value] += 1;
               }
            } catch (incorrectInputException error) {
              System.out.println(error);
              return;
            }
        }
        
        for (int lenght = 0; lenght < array.length; lenght++) {
            System.out.println("pos: " + lenght + " value: " + array[lenght]);
        }
    }
    
    //MARK: - Aux functions
    private static void line() {
      System.out.println("-----------------------------------------");
    }
}
