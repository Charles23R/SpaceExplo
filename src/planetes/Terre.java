package planetes;

import vaisseau.Vaisseau;

public class Terre extends Planete {

    public Terre() {
        setNom("Terre");
        setDistance(((int)(Math.random()*30)+20));
        setExplore(true);
    }
}
