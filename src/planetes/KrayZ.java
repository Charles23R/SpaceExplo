package planetes;

import vaisseau.Vaisseau;

public class KrayZ extends Planete {

    public KrayZ() {
        setNom("KrayZ");
        setDistance(((int)(Math.random()*30)+10));
        setExplore(false);
    }

}
