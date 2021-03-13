/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashes;

/**
 *
 * @author leo_s
 */
public class hashes {

    public static int division (Integer key, Integer m) throws incorrectInputException { 
        if (key < 0) {
            throw new incorrectInputException("Valor da chave menor que 0");
        }
        
        return Math.abs(key) % m; 
    }
    
    public static int multiplication (Integer m, Integer key, double A) throws incorrectInputException {  
        if(m < 0) {
          throw new incorrectInputException("Valor de m menor que zero");
        }
        
        if(A < 0 || A > 1) {
          throw new incorrectInputException("Valor de A fora do intervalo de 0 e 1");
        }
        
        return (int) (m * ((A * key) % 1));
    }  
}

