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
public class Assassi extends Personatge implements Caos {

    public Assassi(String nom,int forca,int cons,int vel,int inte,int sort, Arma arma, int nivel, int pex) {        
        super(nom,forca,cons,vel,inte,sort, arma, nivel, pex);
    }

    public Assassi(String nom, int forca, int cons, int vel, int inte, int sort, Arma arma) {
        super(nom, forca, cons, vel, inte, sort, arma);
    }

    public void calculaDerivades() {
        ps = constitucio + forca;
        pd = (forca + arma.getWpow()) / 4;
        pa = intelligencia + sort + arma.getWvel() + velocitat;
        pe = velocitat + sort + intelligencia;

    }

    public boolean contraAtaca(Dau daus) {
        int sumDados = 0;
        boolean resultado = false;
        for (int i = 0; i < 3; i++) {
            sumDados += daus.tirada(); // acumulamos los resultados de tres tiradas de dados
        }
        
        if (sumDados <= pa / 2) {//si el resultado de los dados es menor o igual que la mitad del pa del personaje devolvemos un true si no devolvemos un false
            resultado = true;
        }
        return resultado;
    }

}
