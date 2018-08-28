package vaisseau;

import objets.Objet;
import planetes.Planete;
import planetes.Terre;

import java.util.ArrayList;
import java.util.Stack;

public class Vaisseau {

    private int carburant;
    private int pv;
    private ArrayList<Objet> inventaire;
    private Stack<Planete> trajet;

    public Vaisseau() {
        this.carburant = 100;
        this.pv = 100;
        this.inventaire = new ArrayList<Objet>();
        this.trajet = new Stack<Planete>();
        trajet.push(new Terre());
    }

    public int getCarburant() {
        return carburant;
    }

    public void setCarburant(int carburant) {
        this.carburant = carburant;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public ArrayList<Objet> getInventaire() {
        return inventaire;
    }

    public void setInventaire(ArrayList<Objet> inventaire) {
        this.inventaire = inventaire;
    }

    public Stack<Planete> getTrajet() {
        return trajet;
    }

    public void setTrajet(Stack<Planete> trajet) {
        this.trajet = trajet;
    }
}