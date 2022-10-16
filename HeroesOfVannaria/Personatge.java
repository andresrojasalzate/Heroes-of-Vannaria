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
public abstract class Personatge {

    protected String nom;
    protected int forca;
    protected int constitucio;
    protected int velocitat;
    protected int intelligencia;
    protected int sort;
    protected int ps;
    protected int pd;
    protected int pa;
    protected int pe;
    protected Arma arma;
    protected int nivel;
    protected int pex;

    public Personatge(String nom, int forca, int cons, int vel, int inte, int sort, Arma arma) {
        this.nom = nom;
        this.forca = forca;
        this.constitucio = cons;
        this.velocitat = vel;
        this.intelligencia = inte;
        this.sort = sort;
        this.arma = arma;
        this.nivel = 0;
        this.pex = 0;
        calculaDerivades();
    }

    public Personatge(String nom, int forca, int cons, int vel, int inte, int sort, Arma arma, int nivel, int pex) {
        this.nom = nom;
        this.forca = forca;
        this.constitucio = cons;
        this.velocitat = vel;
        this.intelligencia = inte;
        this.sort = sort;
        this.arma = arma;
        this.nivel = nivel;
        this.pex = pex;
        calculaDerivades();
    }

    public void amuentarAtributos() { //estas funcion será utilizada para aumentar en 1 las estadisticas de los personajes una vez suban de nivel
        this.forca += 1;
        this.constitucio += 1;
        this.velocitat += 1;
        this.intelligencia += 1;
        this.sort += 1;

    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPex(int pex) {
        this.pex = pex;
    }

    public void anadirPex(int pex) {
        this.pex += pex;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPex() {
        return pex;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getForca() {
        return forca;
    }

    public int getConstitucio() {
        return constitucio;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public int getIntelligencia() {
        return intelligencia;
    }

    public int getSort() {
        return sort;
    }

    public int getPs() {
        return ps;
    }

    public int getPd() {
        return pd;
    }

    public int getPa() {
        return pa;
    }

    public int getPe() {
        return pe;
    }

    public Arma getArma() {
        return arma;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setConstitucio(int constitucio) {
        this.constitucio = constitucio;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public void setIntelligencia(int intelligencia) {
        this.intelligencia = intelligencia;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public void restarPsCombate(int ps) {
        this.ps -= ps;
    }

    public void setPd(int pd) {
        this.pd = pd;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public void setArma(Arma arma) {
        this.arma = arma;

    }

    public abstract void calculaDerivades(); //esta funciona abstracta la usaremos en las clases hijas de personage para caxular las estadisticas derivadas 

    public void mostraStats() { // esta funcion la usaremos par mostrar los atributos de los personajes despues de ser selecccionados para modificar sus estadisticas
        System.out.println("-------" + this.nom + "-------");
        System.out.println("Força: " + this.forca);
        System.out.println("Constitució: " + this.constitucio);
        System.out.println("Velocitat: " + this.velocitat);
        System.out.println("Intel·ligencia: " + this.intelligencia);
        System.out.println("Sort: " + this.sort);
    }

}
