public class CompteurTableau extends Compteur{
    public final int TAILLE_INITIALE = 100;
    private Mot[] elements;
    private int nbMotsTab;
    public CompteurTableau(String fichierTexte) {
        super(fichierTexte);
        elements = new Mot[TAILLE_INITIALE];
        nbMotsTab = 0;
    }

    @Override
    public void addOccurrence(String mot){
        int tmp = -1;
        for(int i =0; i<elements.length;i++){
            if(elements[i].getMot().equals(mot))
                tmp = i;
        }
        if(tmp != -1)
            elements[tmp].nouvelleOccurrence();
        else if(nbMotsTab < elements.length && tmp == -1) {
            elements[nbMotsTab] = new Mot(mot);
            nbMotsTab++;
        }else{
            Mot[] tab = elements;
            int taille = 2*elements.length;
            elements = new Mot[taille];
            for(int i = 0; i<tab.length;i++){
                elements[i] = tab[i];
            }
            elements[nbMotsTab] = new Mot(mot);
            nbMotsTab++;
        }
    }
}
