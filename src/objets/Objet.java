package objets;

import vaisseau.Vaisseau;

public abstract class Objet {

    private String nom;

    public abstract void utiliser(Vaisseau vaisseau);

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
