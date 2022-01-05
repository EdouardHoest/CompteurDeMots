public class CompteurArbre extends Compteur{
    private MotArbre elements;

    public void addOccurrence(String mot) {
        if(elements == null) {
            elements = new MotArbre(mot);
            return;
        }
        MotArbre actuel = elements;
        while(actuel!=null){
            if (actuel.cle() == mot.hashCode()){
                actuel.nouvelleOccurrence();
                return;
            }
            if(mot.hashCode()>actuel.cle())
                actuel = actuel.getGauche();
            else
                actuel = actuel.getDroite();
        }
        actuel = new MotArbre(mot);
    }

    public static void main(String[] args){
        CompteurArbre ct = new CompteurArbre(args[0]);
        System.out.println("Fichier : " + ct.getNomFichier());
        System.out.println("Nombre de mots : " + ct.getNbMots());
        System.out.println("Nombre de mots de taille > 4: " + ct.getNbMots5());
        System.out.println("----------");
        System.out.println("Mots les plus fréquents : ");
        for (int i =0; i<10; i++){
            MotArbre suivant = ct.elements;
            int max = 0;
            while(suivant!=null) {
                if (suivant.getOccurrence() > max)
                    max = suivant.getOccurrence();
                if(suivant.getDroite()!=null)
                    suivant = suivant.getDroite();
                else
                    suivant=suivant.getGauche();
            }
            suivant = ct.elements;
            while (suivant.getOccurrence()!=max){
                suivant = suivant.getNext();
            }
            suivant.affiche();
            suivant.setOccurence(-1);
        }
    }

    public CompteurArbre (String fichierTexte) {
        super(fichierTexte);
    }
}
