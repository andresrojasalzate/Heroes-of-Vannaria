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
public class Arma {
    
    private String nom;
    private int wpow;
    private int wvel;
    
    public Arma(String nom,int wpow,int wvel) {
        this.nom  = nom;
        this.wpow = wpow;
        this.wvel = wvel;
    }

    public String getNom() {
        return nom;
    }

    public int getWpow() {
        return wpow;
    }

    public int getWvel() {
        return wvel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setWpow(int wpow) {
        this.wpow = wpow;
    }

    public void setWvel(int wvel) {
        this.wvel = wvel;
    }
    
    
}
