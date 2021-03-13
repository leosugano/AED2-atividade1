/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hashing;

/**
 *
 * @author leo_s
 */
public class main {
    public static void main(String args[]) {
        hashFunctionWithDivision();
        
    }
    
    //MARK: - Parte das funções de divisões
    private static void hashFunctionWithDivision() {
        System.out.println("Testes 2a de divisao com m 12 e valor 3");
        divisionTests(12);
        line();
        System.out.println("Testes 2b de divisao com m 11 e valor 3");
        divisionTests(11);
        line();
        System.out.println("Testes 2c de divisao com chave 10000 e m 97");
        colisionsCount();
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
            }
        }
    }
    
    private static void colisionsCount() { //Ponto 2.1.c
        int[] array;
        array = new int[97];
        
        for (int key = 1; key <= 10000; key++) {
            try {
               int value = hashes.division(key, 97);
               if(value <= array.length ) {
                   array[value] += 1;
               }
            } catch (incorrectInputException error) {
              System.out.println(error);
            }
        }
        
        for (int lenght = 0; lenght < 97; lenght++) {
            System.out.println("pos: " + lenght + " value: " + array[lenght]);
        }
    }

    
    
    //MARK: - Aux functions
    private static void line() {
      System.out.println("-----------------------------------------");
    }
}
