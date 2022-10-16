/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica_juego;

/**
 *
 * @author rferrero
 */
public class Dau {
 
    private int cares;
    
    public Dau(int cares) {
        this.cares = cares;
    }
    
    public int tirada() {
        return (int)(Math.random()*cares) + 1; //con esta funcion devolveremos un numero aleatorio entre 1 i el  numero de caras recibidas
    }
}
