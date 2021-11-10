import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class Compteur {
    private String nomFichier;
    private int nbMots;
    private int nbMots5;
    public abstract void addOccurrence(String mot);

    public Compteur(String fichierTexte){
        try {
            Scanner in = new Scanner(new File(fichierTexte));
            in.useDelimiter(" ");

            while (in.hasNextLine()) {
                String line = in.nextLine();
                String line2 = line.replaceAll("\\p{Punct}", "");
                String[] listeMot = line2.toLowerCase().split(" |\r\n");
                for (String m : listeMot) {
                    String[] listeMot5 = m.split("");
                    if (listeMot5.length > 4) {
                        addOccurrence(m);
                        nbMots5++;
                    } else {
                        nbMots++;
                    }
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
