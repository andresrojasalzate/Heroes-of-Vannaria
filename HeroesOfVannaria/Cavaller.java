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
public class Cavaller extends Personatge implements Ordre {

    public Cavaller(String nom,int forca,int cons,int vel,int inte,int sort, Arma arma, int nivel, int pex) {        
        super(nom,forca,cons,vel,inte,sort, arma, nivel, pex);
    }

    public Cavaller(String nom, int forca, int cons, int vel, int inte, int sort, Arma arma) {
        super(nom, forca, cons, vel, inte, sort, arma);
    }

    public void calculaDerivades() {
        ps = constitucio + forca + intelligencia;
        pd = (forca + arma.getWpow()) / 4;
        pa = intelligencia + sort + arma.getWvel();
        pe = velocitat + sort + intelligencia;

    }

    public void recuperaParcialmentPS() {

        int saludaMax = constitucio + forca + intelligencia; // Claculamos los ps maximos del personaje
        int saludaRecuperar = (int) saludaMax * 10 / 100; // calculamos el 10% de esos ps maximos

        if (ps < saludaMax) { // si los ps son infereriores a los ps maximos calculados
            ps += saludaRecuperar; //le sumamos el 10%
            if (ps > saludaMax) { // comprobamos si los ps se pasasn de los ps maximos
                ps = saludaMax; // si se pasan de los ps maximos  establecemos los ps maximos como los ps porque no puede tner mas vida que la que tenia inicialmente al prinicipiop del combate
            }
        }
    }

}
