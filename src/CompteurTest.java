public class CompteurTest extends Compteur {

    public CompteurTest(String fichierTexte) {
        super(fichierTexte);
    }

    public void addOccurrence(String mot){
        System.out.println(mot);
    }
    public static void main(String[] args){
        Compteur c;
        if (args.length<1) System.err.println("nom de fichier manquant");
        else{
            c = new CompteurTest(args[0]);
            System.out.println("Il y a " + c.getNbMots() + "mots et " + c.getNbMots5() + "mots de 5 lettres ou plus");
        }
    }
}
