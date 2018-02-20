/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2path.nio.directoris;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.util.Scanner;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author Arnau
 */
public class NIODirectoris {

    public static int menu() {
        int opcio = -1;
        System.out.println("ESCULL UNA OPCIÓ \n------ --- ----\n");
        System.out.println("1) Comprova Directori/Fitxer");
        System.out.println("2) Accesibilitiat Fitxer");
        System.out.println("3) Eliminar Fitxer/directori");
        System.out.println("4) Accesibilitiat Fitxer");
        System.out.println("5) Eliminar Fitxer/directori");
        System.out.println("6 )Metadades Fitxer");
        System.out.println("7) Escriu Dintre Fitxer(Atencio sobrescriura el contingut)");
        System.out.println("\n0) Que tinguin un bon dia");

        //selecio del usuari
        opcio = scan.nextInt();
        return opcio;
    }

    public static void ComprovaDirectori (String dir) {
        Path path = Paths.get(dir);

        boolean ok = Files.exists(path);
        if (ok) {
            System.out.println(dir + "Si existeix");

        } else {
            System.out.println(dir + "No existeix");
        }

    }
    
    public static void FitxerAccessible (String fitx) throws IOException{
    Path path = Paths.get(fitx);
    UserPrincipal propietari;
    FileTime Ultmod;
   
        //Pots llegir el fitxer?
        boolean isReadable = Files.isReadable(path);
        
        // Podem executar-lo?
        boolean isExecutable = Files.isExecutable(path);
        
        //Podem Modificar-lo?
        boolean isWritable = Files.isWritable(path);
        
        //qui es el propietari
        propietari=Files.getOwner(path);
        
        //Ultima modificació
        Ultmod=Files.getLastModifiedTime(path);
  
          
      //   System.out.println(userPrincipal.getName());
    
        System.out.println("El fitxer "+fitx+" llegir "+isReadable+", executar "+isExecutable+" modificar "+isWritable+" Qui es el propietari "+propietari+" ");
    
    }
    
    public static void EliminarFitxerDirectori(String fitx) throws IOException{
        Path path = Paths.get(fitx);
        Files.delete(path);
       
    
    
    }
    
    public static void CopiaFitxerDirectori (String origen,String desti) throws IOException{
        Path pathOrigen = Paths.get(origen);
        Path pathDesti = Paths.get(desti);
        
        Files.copy(pathOrigen, pathDesti);
    
    
    
    }
    
    public static void MoureFitxerDirectori (String origen,String desti) throws IOException{
    
     Path pathOrigen = Paths.get(origen);
        Path pathDesti = Paths.get(desti);
        
        Files.move(pathOrigen, pathDesti);
    
    }
    
    public static void MetaDades(String fitx) throws IOException{
         Path path = Paths.get(fitx);
    UserPrincipal propietari;
     FileTime Ultmod;
     double mida;
     
    propietari=Files.getOwner(path);
    Ultmod=Files.getLastModifiedTime(path);
    mida=Files.size(path);
        System.out.println("Metadades del fitxer "+path+" el propietari és "+propietari+", l'ultima modificació és "+Ultmod+" té una mida de "+mida+" ");
    
    
    }

    /**
     * @param args the command line arguments
     */
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // Em de fer un menu per fer servir les variable paht
        int op = -1;
        String dir,fitx,dir2;

        do {
            op = menu();

            switch (op) {
                case 1:
                    System.out.println("Diga'm el directori (Si és Windows C:) "); // per preguntar el fitxer haig de fer una funcio millor funcio preguntaFitxer
                    dir = scan.next();
                    ComprovaDirectori(dir);
                    break;

                case 2:
                    System.out.println("Dona'm el fitxer per compovar l'accesibilitat");
                    fitx= scan.next();
                    FitxerAccessible(fitx);
                    break;

                case 3:
                    System.out.println("Dona', el fitxer per borrar");
                   fitx=scan.next();
                   JOptionPane.showMessageDialog(null,"segur que vols borrar ??");
                 
                    EliminarFitxerDirectori(fitx);
                    break;
                case 4:
                      System.out.println("Dona', el fitxer per copiar");
                      fitx=scan.next();
                      System.out.println("Dona'm el directori per copiar");
                      dir=scan.next();
                        CopiaFitxerDirectori(fitx,dir);
                    
                 
                    break;
                case 5:
                     System.out.println("Dona', el fitxer d'origen");
                      dir=scan.next();
                      System.out.println("Dona'm el directori de desti");
                      dir2=scan.next();   
                     MoureFitxerDirectori(dir,dir2);
                    
                    
                    
                    break;
                case 6:
                    System.out.println("Digam el fitxer per treure les metadades ");
                    fitx=scan.next();
                    MetaDades(fitx);
                    
                       
                    break;
                case 7:
                    System.out.println("Escriu dintre d'un fitxer");
                    break;
                case 0:
                    System.out.println("Que tinguis un bon dia");
                    break;

            }

        } while (op != 0);

    }

}
