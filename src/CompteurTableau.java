public class CompteurTableau extends Compteur{
    public final int TAILLE_INITIALE = 100;
    private Mot[] elements;
    private int nbMotsTab = 0;

    public int getTAILLE_INITIALE() {
        return TAILLE_INITIALE;
    }

    public Mot[] getElements() {
        return elements;
    }

    public int getNbMotsTab() {
        return nbMotsTab;
    }

    public CompteurTableau(String fichierTexte) {
        super(fichierTexte);
    }

    @Override
    public void addOccurrence(String mot){
        if(elements == null) {
            elements = new Mot[TAILLE_INITIALE];
        }
        int tmp = -1;
        int cpt = 0;
        while(cpt<elements.length && elements[cpt]!=null){
            if(this.elements[cpt].getMot().equals(mot))
                tmp = cpt;
            cpt++;
        }
        if(tmp != -1)
            this.elements[tmp].nouvelleOccurrence();
        else if(nbMotsTab < this.elements.length) {
            this.elements[nbMotsTab] = new Mot(mot);
            nbMotsTab++;
        }else{
            Mot[] tab = this.elements;
            int taille = 2*this.elements.length;
            this.elements = new Mot[taille];
            System.arraycopy(tab, 0, this.elements, 0, tab.length);
            this.elements[nbMotsTab] = new Mot(mot);
            nbMotsTab++;
        }
    }
    public static void main(String[] args){
        CompteurTableau ct = new CompteurTableau(args[0]);
        System.out.println("Fichier : " + ct.getNomFichier());
        System.out.println("Nombre de mots : " + ct.getNbMots());
        System.out.println("Nombre de mots de taille > 4: " + ct.getNbMots5());
        System.out.println("----------");
        System.out.println("Mots les plus fréquents : ");
        for (int i =0; i<10; i++){
            int max = 0;
            int cpt=0;
            while(cpt<ct.elements.length && ct.elements[cpt]!=null) {
                if (ct.elements[cpt].getOccurrence() > ct.elements[max].getOccurrence())
                    max = cpt;
                cpt++;
            }
            assert ct.elements[max] != null;
            ct.elements[max].affiche();
            ct.elements[max].setOccurence(-1);
        }
    }
}
