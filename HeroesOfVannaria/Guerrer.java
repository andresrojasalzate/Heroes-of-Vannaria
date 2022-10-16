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
public class Guerrer extends Personatge {
  
    public Guerrer(String nom,int forca,int cons,int vel,int inte,int sort, Arma arma, int nivel, int pex) {        
        super(nom,forca,cons,vel,inte,sort, arma, nivel, pex);
    }
    
    public Guerrer(String nom,int forca,int cons,int vel,int inte,int sort,Arma arma) {
        super(nom,forca,cons,vel,inte,sort,arma);
    }

    public void calculaDerivades() {        
        ps = constitucio + forca;
        pd = (forca + arma.getWpow() + constitucio) / 4;
        pa = intelligencia + sort + arma.getWvel();
        pe = velocitat + sort + intelligencia;
        
    }


    
}
