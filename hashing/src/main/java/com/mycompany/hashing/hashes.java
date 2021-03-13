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
public class hashes {

    public static int division (Integer key, Integer m) throws incorrectInputException { 
        if (key < 0) {
            throw new incorrectInputException("Key menor que 0");
        }
        
        return Math.abs(key) % m; 
    }
    
    public static int hashKey(Integer tableSize, Integer key, double A) throws incorrectInputException {  
        if(tableSize < 0) {
          throw new incorrectInputException("Tamanho da tabela menor que 0");
        }
        
        return (int) (tableSize * ((A * key) % 1));
    }  
}

