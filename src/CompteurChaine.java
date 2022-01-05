public class CompteurChaine extends Compteur{
    private MotChaine elements;

    public MotChaine getLast() {
        MotChaine suivant = elements;
        if (elements == null)
        	return null;
        while(suivant.getNext() != null) {
        	suivant = suivant.getNext();
        }
        return suivant;
    }

    public void addOccurrence(String mot) {
        if(elements == null) {
            elements = new MotChaine(mot);
            return;
        }
        MotChaine suivant = elements;
        while(suivant!=null) {
            if (suivant.getMot().equals(mot)){
                suivant.nouvelleOccurrence();
                return;
            }
            suivant = suivant.getNext();
        }
        getLast().setNext(new MotChaine(mot));
    }

    public CompteurChaine(String fichierTexte) {
        super(fichierTexte);
    }

    public static void main(String[] args){
        CompteurChaine ct = new CompteurChaine(args[0]);
        System.out.println("Fichier : " + ct.getNomFichier());
        System.out.println("Nombre de mots : " + ct.getNbMots());
        System.out.println("Nombre de mots de taille > 4: " + ct.getNbMots5());
        System.out.println("----------");
        System.out.println("Mots les plus fréquents : ");
        for (int i =0; i<10; i++){
            MotChaine suivant = ct.elements;
            int max = 0;
            while(suivant!=null) {
                if (suivant.getOccurrence() > max)
                    max = suivant.getOccurrence();
                suivant = suivant.getNext();
            }
            suivant = ct.elements;
            while (suivant.getOccurrence()!=max){
                suivant = suivant.getNext();
            }
            suivant.affiche();
            suivant.setOccurence(-1);
        }
    }
}
