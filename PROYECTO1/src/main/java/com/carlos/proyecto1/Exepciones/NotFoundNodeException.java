/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.proyecto1.Exepciones;

/**
 *
 * @author benjamin
 */
public class NotFoundNodeException extends Exception{

    public NotFoundNodeException() {
    }

    public NotFoundNodeException(String message) {
        super(message);
    }
    
}
