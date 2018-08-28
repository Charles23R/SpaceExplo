package objets;

import vaisseau.Vaisseau;

public abstract class Objet {

    private String nom;
    private int quantite;

    public abstract void utiliser(Vaisseau vaisseau);

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
