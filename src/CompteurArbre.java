public class CompteurArbre extends Compteur{
    private MotArbre elements;
    private int max = 0;

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
            if(mot.hashCode()<actuel.cle())
                actuel = actuel.getGauche();
            else
                actuel = actuel.getDroite();
        }
        ajouteMot(mot);
    }

    public void ajouteMot(String mot){
        MotArbre actuel = elements;
        while(actuel!=null){
            if(mot.hashCode()<actuel.cle())
                actuel = actuel.getGauche();
            else
                actuel = actuel.getDroite();
        }
        actuel = new MotArbre(mot);
    }

    public MotArbre bestOccurence(MotArbre arbre){
        MotArbre best = arbre;
        MotArbre gauche = best;
        MotArbre droite = best;
        if (best.getOccurrence() > max)
            max = best.getOccurrence();
        if(best.getDroite()!=null)
            droite = bestOccurence(best.getDroite());
        if(best.getGauche()!=null)
            gauche = bestOccurence(best.getGauche());
        if(best.getOccurrence()<gauche.getOccurrence())
            best=gauche;
        if(best.getOccurrence()<droite.getOccurrence())
            best=droite;
        return best;
    }
    public void resetOccurence(MotArbre arbre){
        MotArbre best = arbre;
        MotArbre gauche = best;
        MotArbre droite = best;
        if (best.getOccurrence() > max)
            max = best.getOccurrence();
        if(best.getDroite()!=null)
            droite = bestOccurence(best.getDroite());
        if(best.getGauche()!=null)
            gauche = bestOccurence(best.getGauche());
        if(best.getOccurrence()<gauche.getOccurrence())
            best=gauche;
        if(best.getOccurrence()<droite.getOccurrence())
            best=droite;
        best.setOccurence(-1);
    }

    public static void main(String[] args){
        CompteurArbre ct = new CompteurArbre(args[0]);
        MotArbre best;
        System.out.println("Fichier : " + ct.getNomFichier());
        System.out.println("Nombre de mots : " + ct.getNbMots());
        System.out.println("Nombre de mots de taille > 4: " + ct.getNbMots5());
        System.out.println("----------");
        System.out.println("Mots les plus fréquents : ");
        for (int i =0; i<10; i++){
            best = ct.bestOccurence(ct.elements);
            System.out.println(best.getMot() + " " + best.getOccurrence());
            ct.resetOccurence(ct.elements);
        }
    }

    public CompteurArbre (String fichierTexte) {
        super(fichierTexte);
    }
}
