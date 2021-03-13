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
public class incorrectInputException extends Exception {
    
    public incorrectInputException(String errorMessage) {
        super(errorMessage);
    }
}
