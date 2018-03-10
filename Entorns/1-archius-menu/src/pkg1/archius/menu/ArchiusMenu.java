/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.archius.menu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author infot
 */
public class ArchiusMenu {

    public static int menu() {

        int opcio = -1;
        System.out.println("\tESCULL UNA OPCIÓ \n\t----- --- -----\n\n");
        System.out.println("1) Utilitzar BytesStreams");
        System.out.println("2) Utilitzar CaracterStreams");
        System.out.println("3) Utilitzar BufferStreams");
        System.out.println("4) Utilitzar DataStreams");
        System.out.println("5) Utilitzar ObjecteStreams\n");
        System.out.println("6) EscriuString");
        System.out.println("0) Sortir");

        opcio = scan.nextInt();
        return opcio;

    }

    public static void UtilitzarByteStream(String a, String b) throws FileNotFoundException, IOException {

        try (
                FileInputStream in = new FileInputStream(a);
                FileOutputStream out = new FileOutputStream(b);) {

            int c; //variable temporal

            while ((c = in.read()) != -1) {

                out.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void UtilitzarCaracterStream(String a, String b) throws FileNotFoundException, IOException {

        try (
                FileReader in = new FileReader(a);
                FileWriter out = new FileWriter(b);) {

            int f; //variable temporal

            while ((f = in.read()) != -1) {

                out.write(f);
            }
        }

    }

    public static void EscriuCharacter(String arxiu, String text) throws FileNotFoundException, IOException {
        //escriu una string al fitxer
        try (
                FileWriter out = new FileWriter(arxiu,true);) {
            out.write(text);
        }

    }
    
    public static void Llegeixcharacher (String arxiu) throws FileNotFoundException, IOException{
    
    try(
            
            
            
            FileReader entra = new FileReader(arxiu);){
    int c;
    while ((c= entra.read()) !=-1){
        System.out.println((char) (c));
    }
    }catch (Exception e){
    System.err.println("Error en el fitxer");
    
    } 
    
    
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // crearem un menu, cada partat tindra funcions i donara les alertes per joptionpane
        int opcio = -1;

        // Rutes fitxers que tinc
        String fitxerBinariEntrada = "../fitxers/fotobit.jpg";
        String fitxerBinariSortida = "../fitxers/fotobit_2.jpg";
        String fitxerStringSortida = "../fitxers/fitxer_string.txt";
        String fitxerStringEntrada = "../fitxers/fitxer_string_2.txt";
        String fitxerBinariData = "../fitxers/fitxer_date.txt";
        String fitxerobjecte = fitxerBinariData;
        String text;
        String fitxer="../fitxers/fitxer_string.txt";
        do {
            opcio = menu();

            switch (opcio) {
                case 1:
                    UtilitzarByteStream(fitxerBinariEntrada, fitxerBinariSortida);
                    break;

                case 2:
                    UtilitzarCaracterStream(fitxerStringSortida, fitxerStringEntrada);
                    break;

                case 3:
                    //UtilitzarBufferStream(fitxerBinariEntrada,fitxerBinariSortida,fitxerStringSortida,fitxerStringEntrada);
                    break;
                case 4:
                    //UtilitzarDataStreams();
                    break;
                case 5:
                    //UtilitzarObjecteStreams();
                    break;
                
                case 6:
                        System.out.println("Quin text vols escriure en el fitxer "+fitxer+"");
                        text=scan.next();
                        EscriuCharacter(fitxer,text);
                        
                        
                    break;
                case 0:
                    System.out.println("Que tinguis un bon dia");
                    break;

            }

        } while (opcio != 0);

    }

}
