public class MotArbre extends Mot{
    private MotArbre gauche;
    private MotArbre droite;

    public MotArbre(String m, MotArbre g, MotArbre d){
        super(m);
        gauche = g;
        droite = d;
    }
    public MotArbre(String m){
        this(m, null, null);
    }

    public int cle() {
        return hashCode();
    }

    public MotArbre getGauche() {
        return gauche;
    }

    public MotArbre getDroite() {
        return droite;
    }

    public vois setDroite(MotArbre d){
        droite=d;
    }
    public vois setGauche(MotArbre g){
        gauche=g;
    }
    // + d’autre méthodes à implémenter
}
