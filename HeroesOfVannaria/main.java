/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica_juego;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andre
 */
public class main {
    
    static Scanner sc = new Scanner(System.in);
    static Scanner in = new Scanner(System.in);
    
    private ArrayList<Personatge> personatges;
    private Arma[] armes;
    private Dau dado;
    private int numTiradas;
    private String path;
    
    private main() {
        //creamos una array cn las aramas dentro
        armes = new Arma[3];
        armes[0] = new Arma("Daga", 5, 15);
        armes[1] = new Arma("Espasa", 10, 10);
        armes[2] = new Arma("Martell de combat", 15, 5);
        //creamos un dado de 25 caras
        dado = new Dau(25);
        //declaramos el numero de tiradas
        numTiradas = 3;
        //declaramos el path del archivo
        path = "C:\\Users\\andre\\OneDrive\\Escritorio\\main\\";
        //asignamos a la lista personatges el ccontenido del ichero csv
        personatges = llegirFitxer(path, "personatges.csv");
        
    }
    
    public static void main(String[] args) throws IOException {
        main joc = new main();
        joc.jugar();
        
    }
    
    public void jugar() {
        
        boolean finalJoc = false;
        while (!finalJoc) {

            // Mostrar el menú
            System.out.println("\n\n*** HEROES OF VANNARIA ***\n");
            System.out.println("1.- Crear personatge");
            System.out.println("2.- Iniciar combat");
            System.out.println("3.- Editar persoatge");
            System.out.println("4.- Acabar joc");
            
            System.out.print("\nTria una opció: ");
            String opcio = sc.nextLine();

            //Seleccionar opció i cridar al mètode corresponent
            switch (opcio) {
                case "1":
                    crearPersonatge();
                    break;
                case "2":
                    combat();
                    break;
                case "3":
                    modificaPersonatge();
                    break;
                case "4":
                    finalJoc = true;
                    guardaPersonatges();
                    break;
                default:
                    System.out.println("Opció incorrecta!");
            }
            
        }
    }
    
    private void crearPersonatge() {
        //Primer mostrem les categories dels personatges i fem que esculli 
        System.out.println("Escull la categoria del teu personatge");
        System.out.println("1.Guerrer 2.Cavaller 3.Valkiria 4.Assassí");
        int clase = comprovarMax(4);

        //Escull la categoria del teu personatge
        System.out.println("Escull el nom del teu personatge");
        String nom = sc.nextLine();
        System.out.println("Escull l'arma del teu personatge:");
        System.out.println("1." + armes[0].getNom() + " 2." + armes[1].getNom() + "  3." + armes[2].getNom());
        int numArma = comprovarMax(3);
        
        int maxAtributs = 60 - 12; //restam 12 punts per reservar-los com a mínim per als altres atributs
        //Ara farem que introdueixi la quantitat que vol assignar-li a cada atribut
        System.out.println("Ingressa la força del personatge (min = 3, max =18)");
        int forca = atributs(18);
        maxAtributs = restarAtributs(maxAtributs, forca);
        int maxAtribut = maxAtribut(maxAtributs);
        
        System.out.println("Ingressa la constitució del personatge (min = 3, max = " + maxAtribut + ")");
        int constitucio = atributs(maxAtribut);
        maxAtributs = restarAtributs(maxAtributs, constitucio);
        maxAtribut = maxAtribut(maxAtributs);
        
        System.out.println("Ingressa la velocitat del personatge (min = 3, max = " + maxAtribut + ")");
        int velocitat = atributs(maxAtribut);
        maxAtributs = restarAtributs(maxAtributs, velocitat);
        maxAtribut = maxAtribut(maxAtributs);
        
        System.out.println("Ingressa la intel·ligència del personatge (min = 3, max = " + maxAtribut + ")");
        int intelligencia = atributs(maxAtribut);
        maxAtributs = restarAtributs(maxAtributs, intelligencia);
        maxAtribut = maxAtribut(maxAtributs);
        
        System.out.println("Ingressa la sort del personatge (min = 3, max = " + maxAtribut + ")");
        int sort = atributs(maxAtribut);
        
        Arma arma = null;
        
        switch (numArma) { //depenent del nombre de l' arma rebuda li assignarem a la variable arma l' arma corresponent
            case 1:
                arma = armes[0];
                break;
            case 2:
                arma = armes[1];
                break;
            case 3:
                arma = armes[2];
                break;
        }
        Personatge personatge;
        switch (clase) {            
            case 1:
                personatge = new Guerrer(nom, forca, constitucio, velocitat,
                        intelligencia, sort, arma);
                personatges.add(personatge);
                break;
            case 2:
                personatge = new Cavaller(nom, forca, constitucio, velocitat,
                        intelligencia, sort, arma);
                personatges.add(personatge);
                break;
            case 3:
                personatge = new Valkiria(nom, forca, constitucio, velocitat,
                        intelligencia, sort, arma);
                personatges.add(personatge);
                break;
            case 4:
                personatge = new Assassi(nom, forca, constitucio, velocitat,
                        intelligencia, sort, arma);
                personatges.add(personatge);
                break;
        }
        
    }
    
    private int maxAtribut(int maxAtributs) {
        //aquesta funcion la fem servir per comprovar que maxim d'atributs es major o iguala 18 si és major  assignem 18 si és menor assignem el valor de maxAtribut
        int num;
        if (maxAtributs >= 18) {
            num = 18;
        } else {
            num = maxAtributs;
        }
        return num;
    }
    
    private int restarAtributs(int maxAtributs, int atribut) {
        //aquesta funció la fem servir per restar els atributs rebuts del màxim d' atributs
        maxAtributs += 3; //sumen el minim del atribut
        maxAtributs -= atribut;
        return maxAtributs;
    }
    
    private int atributs(int max) {
        //Aquesta funciona la farem servir per comprovar que els atrinuts ingressats siguin correctes
        int num = in.nextInt();
        while (num < 3 || num > max) {
            System.out.println("El número introduït és incorrecte torna a intentar-ho");
            num = in.nextInt();
        }
        return num;
    }
    
    private int comprovarMax(int max) {
        //Aquesta funció la utilitzarem per comprovar que el nombre que introdueix en escollir categoria i arma és correcte
        int num = in.nextInt();
        while (num < 0 || num > max) {
            System.out.println("El número introduït és incorrecte torna a intentar-ho");
            num = in.nextInt();
        }
        return num;
    }
    
    private void combat() {
        
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println((i + 1) + ": " + personatges.get(i).getNom());// Mostramos por pantalla todos los personajes disponibles
        }
        System.out.print("Jugador 1 escull un dels personatges:");
        int numPj1 = comprobarExistenciaPersonaje(personatges.size(), 1, -2);
        System.out.print("Jugador 2 escull un dels personatges:");
        int numPj2 = comprobarExistenciaPersonaje(personatges.size(), 2, numPj1);
        
        //Asignamos los personajes escogidos a las siguientes variables
        Personatge pjJugador1 = personatges.get(numPj1);
        Personatge pjJugador2 = personatges.get(numPj2);
  
        // asigamos la vida de los personajes a una variablr paara despues poder devolversela una vez acabado el combate
        int vidapj1 = personatges.get(numPj1).getPs();
        int vidapj2 = personatges.get(numPj2).getPs();
        
        while (pjJugador1.getPs() > 0 || pjJugador2.getPs() > 0) { //En este while se ejecutara el combate. Estara activo mintras las vidas de los personajes sean mayores de 0
            ataqueYDefensa(pjJugador1, pjJugador2, "Jugador 1", "Jugador 2");
            ataqueYDefensa(pjJugador2, pjJugador1, "Jugador 2", "Jugador 1");
        }
        
        if (pjJugador1.getPs() <= 0) {
            System.out.println("\n\nJugador 2 ha guanyat el combat");
            pjJugador1.setPs(vidapj1);
            pjJugador2.setPs(vidapj2);
            pjJugador2.anadirPex(vidapj1);
            comprobarExperiencia(pjJugador2);
        } else {
            System.out.println("\n\nJugador 1 ha guanyat el combat");
            pjJugador1.setPs(vidapj1);
            pjJugador2.setPs(vidapj2);
            pjJugador1.anadirPex(vidapj2);
            comprobarExperiencia(pjJugador1);
        }
        
    }
    
    private void comprobarExperiencia(Personatge pj) {
        switch (pj.getPex()) {
            case 100:
                pj.setNivel(1);
                pj.amuentarAtributos();
                pj.calculaDerivades();
                break;
            case 200:
                pj.setNivel(2);
                pj.amuentarAtributos();
                pj.calculaDerivades();
                break;
            case 500:
                pj.setNivel(3);
                pj.amuentarAtributos();
                pj.calculaDerivades();
                break;
            case 1000:
                pj.setNivel(4);
                pj.amuentarAtributos();
                pj.calculaDerivades();
                break;
            case 2000:
                pj.setNivel(5);
                pj.amuentarAtributos();
                pj.calculaDerivades();
        }
        
    }
    
    private void ataqueYDefensa(Personatge atacante, Personatge defensor, String jugadorAtacante, String jugadorDefensor) {
        int resultadoDadoA = dados(); //reultado del dado del atacante
        int resultadoDadoD = dados(); //reultado del dado del defensor
        String clasePj1 = atacante.getClass().getSimpleName();
        String clasePj2 = defensor.getClass().getSimpleName();
    
        if (resultadoDadoA <= atacante.getPa()) { //si el resultado de los dados del atacante es menor o igual que su pa....
            if (resultadoDadoD <= defensor.getPe()) {//si el resultado de los dados del defensor es menor o igual que su pe....
                System.out.println(jugadorDefensor + " ha esquivat l'atac");
                if (clasePj2.equals("Assassi")) {//Si el defensor es un asesion intentara hacer un contrataque
                    if (((Assassi) defensor).contraAtaca(dado) == true) { //si acierta 
                        System.out.println(jugadorDefensor + " ha realitzat un contraatac");
                        atacante.restarPsCombate(defensor.getPd());
                    }
                }
            } else {//si el resultado de los dados del defensor no es menor o igual que su pa....
                System.out.println(jugadorAtacante + " va encertar l'atac");
                defensor.restarPsCombate(atacante.getPd());
                if (clasePj1.equals("Cavaller")) { // Si el atacante es un caballero recuperara ps al acertar el atacque
                    ((Cavaller) atacante).recuperaParcialmentPS();
                    System.out.println(jugadorAtacante + " ha recuperat uns ps");
                }
                
            }
        } else { //si el resultado de los dados del atacante no es menor o igual que su pa...
            System.out.println(jugadorAtacante + " ha fallat l'atac");
        }
        
    }
    
    private int dados() {
        //Con esta funcion sumanos el resultado de tres tiradas de un dado
        int sumDados = 0;
        for (int i = 0; i < numTiradas; i++) {
            sumDados += dado.tirada();
        }
        return sumDados;
    }
    
    private int comprobarExistenciaPersonaje(int maxLista, int numJuagor, int pjEscogido) {
        //En esta funcion haremos que el usuario escoja el personaje 
        int num = in.nextInt();
        pjEscogido += 1;
        while (num <= 0 || num >= maxLista + 1 || num == pjEscogido) { //Aqui comprobamos que el personaje escogido existe. Si no existe entra en un while hasta que escoja un personaje valido
            if (num == pjEscogido) {
                System.out.println("El personatge que has escollit ja ha estat seleccionat");
            } else {
                System.out.println("Personatge no existent");
                
            }
            if (numJuagor == 1) {
                System.out.print("Jugador 1 escull un dels personatges:");
            } else {
                System.out.print("Jugador 2 escull un dels personatges:");
            }
            num = in.nextInt();
        }
        return num - 1; // restamos uno al numero del personaje escogido para que despues no de problemas al seleccionar al personaje de la lista
    }
    
    private ArrayList<Personatge> llegirFitxer(String path, String nomFitxer) {
        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        try {
            BufferedReader entrada = new BufferedReader(
                    new FileReader(path + nomFitxer));
            
            String personatgeStr;
            personatgeStr = entrada.readLine();
            while (personatgeStr != null) {
                String[] caracteristiques = personatgeStr.split(";"); //separamos la linea recibida por ";" mediante el split
                String classe = caracteristiques[1]; //assignamos la clase

                Arma laMevaArma = null;
                switch (caracteristiques[7]) { //dependiendo del nombre del arma recibida le asignaremos a la variable laMevaArma el arma correspondiente
                    // Nom arma
                    case "Daga":
                        laMevaArma = armes[0];
                        break;
                    case "Espasa":
                        laMevaArma = armes[1];
                        break;
                    case "Martell de combat":
                        laMevaArma = armes[2];
                        break;
                }

                //A continuacion recogeremos en variables el nombre y atributos recibidos 
                String nom = caracteristiques[0];
                int forca = Integer.parseInt(caracteristiques[2]);
                int constitucio = Integer.parseInt(caracteristiques[3]);
                int velocitat = Integer.parseInt(caracteristiques[4]);
                int intelligencia = Integer.parseInt(caracteristiques[5]);
                int sort = Integer.parseInt(caracteristiques[6]);
                int nivel = Integer.parseInt(caracteristiques[8]);
                int pex = Integer.parseInt(caracteristiques[8]);
                
                Personatge personatge;
                switch (classe) { //dependiendo de la clase que hemos recogidio antes usaremos cierto constructor para crear el personage y lo añadiremos a la lista personatges
                    case "Guerrer":
                        personatge = new Guerrer(nom, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma, nivel, pex);
                        personatges.add(personatge);
                        break;
                    case "Cavaller":
                        personatge = new Cavaller(nom, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma, nivel, pex);
                        personatges.add(personatge);
                        break;
                    case "Valkiria":
                        personatge = new Valkiria(nom, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma, nivel, pex);
                        personatges.add(personatge);
                        break;
                    case "Assassí":
                        personatge = new Assassi(nom, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma, nivel, pex);
                        personatges.add(personatge);
                        break;
                }
                
                personatgeStr = entrada.readLine();
            }
            
        } catch (FileNotFoundException fnf) {
            
            System.out.println("Error fitxer no trobat.");
        } catch (IOException ioe) {
            System.out.println("Error I/O: " + ioe.getMessage());
        }
        
        return personatges;
        
    }
    
    public void guardaPersonatges() {
        File fichero = new File(path + "personatges.csv");
        try {

            //If para comprobar si existe el archivo si existe lo eliminamos
            if (fichero.exists()) {
                fichero.delete();
                fichero.createNewFile();
                
            }
        } catch (IOException e) {
            System.out.println("El fitxer no existeix");
        }
        try {
            //Creamos el buffered writed y escribimos el contenido de equipos y puntos en el nuevo fichero
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero.getAbsoluteFile(), true)); //opción append habilitada

            for (int i = 0; i < personatges.size(); i++) {
                Personatge pj = personatges.get(i);
                bw.write(pj.getNom() + ";" + pj.getClass().getSimpleName() + ";" + pj.getForca() + ";" + pj.getConstitucio() + ";" + pj.getVelocitat() + ";"
                        + pj.getIntelligencia() + ";" + pj.getSort() + ";" + pj.getArma().getNom() + ";" + pj.getNivel() + ";" + pj.getPex());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("No es pot llegir el fitxer");
        }
    }
    
    public void modificaPersonatge() {
        //Creació de les variables encarregades de gestionar el metode
        int escullPeronatge, modStat, minStat = 3, totalStats, posicioPersonatge;

        //Mostrem a l'usuari els personatges que hi ha per que pugui escollir quin modificar
        System.out.println("Quin personatge vols modificar?");
        for (int i = 0; i < personatges.size(); i++) {
            System.out.println((i + 1) + ". " + personatges.get(i).getNom());
        }
        //Escollim personatge
        System.out.println("Quin personatge vols escullir");
        escullPeronatge = in.nextInt();

        //Declarem el valor de variables que ens serviran per modificar les estadistiques
        posicioPersonatge = escullPeronatge - 1;
        Personatge pjMod = personatges.get(posicioPersonatge);
        //Mostrar Stats Personaje per que els tomi com a referencia

        personatges.get(posicioPersonatge).mostraStats();
        
        totalStats = pjMod.getConstitucio() + pjMod.getForca() + pjMod.getIntelligencia() + pjMod.getSort() + pjMod.getVelocitat() - 12; // Restem 12 que seran els que ens guardarem que son minimes per cada stat

        //Preguntem el nou nom que li vol asignar al personatge
        System.out.println("Que nom li vols possar?");
        String nom = sc.nextLine();
        pjMod.setNom(nom);
        //Preguntem quin valor li vol asignar a cadascuna de les estadistiques
        System.out.println("Que valor li vols possar a constitucio(Min = " + minStat + " y Max = " + totalStats + ")");
        //Preguntem el estat a posar
        modStat = in.nextInt();
        //Comprobem si es correcte i si ho es ho asigarem
        int novaConstitucio = modStats(modStat, minStat, totalStats);
        pjMod.setConstitucio(novaConstitucio);
        //Recalcularem els punts que ens queden per asignar
        totalStats = recalculaTotal(totalStats, novaConstitucio);
        
        System.out.println("Que valor li vols possar a velocitat(Min = " + minStat + " y Max = " + totalStats + ")");
        modStat = in.nextInt();
        int novaVelocitat = modStats(modStat, minStat, totalStats);
        pjMod.setVelocitat(novaVelocitat);
        totalStats = recalculaTotal(totalStats, novaVelocitat);
        
        System.out.println("Que valor li vols possar a intelligencia(Min = " + minStat + " y Max = " + totalStats + ")");
        modStat = in.nextInt();
        int novaIntelligencia = modStats(modStat, minStat, totalStats);
        pjMod.setIntelligencia(novaIntelligencia);
        totalStats = recalculaTotal(totalStats, novaIntelligencia);
        
        System.out.println("Que valor li vols possar a sort(Min = " + minStat + " y Max = " + totalStats + ")");
        modStat = in.nextInt();
        int novaSort = modStats(modStat, minStat, totalStats);
        pjMod.setSort(novaSort);
        totalStats = recalculaTotal(totalStats, novaSort);
        
        System.out.println("Que valor li vols possar a forca(Min = " + minStat + " y Max = " + totalStats + ")");
        modStat = in.nextInt();
        int novaForca = modStats(modStat, minStat, totalStats);
        pjMod.setForca(novaForca);
        personatges.get(posicioPersonatge).mostraStats();
        
    }
    
    public int recalculaTotal(int totalStats, int modStat) {
        //Sumem 3 dels que hi ha com a minim per a cada stat
        totalStats += 3;
        //Tambe li restem el modStat per que els punts que ja hi hem asignat no els puguem tornar a asignar
        totalStats -= modStat;
        return totalStats;
    }

    // Comprobem el modStat de constitucio
    public int modStats(int modStat, int minStat, int totalStats) {
        boolean sortir = false;
        //creem un bucle que comprobara el modStat i si es incorrecte o tornara a preguntar o ho asignara si es correcte
        while (!sortir) {
            //comprobem si es correcte el modstat
            if ((modStat >= minStat) && (modStat <= totalStats)) {
                
                sortir = true;
            } else {// si no ho es o tornem a demanar
                System.out.println("El valor es o massa petit o massa gran, tarna-ho a escriure : ");
                modStat = in.nextInt();
            }
        }
        return modStat;
    }
}
