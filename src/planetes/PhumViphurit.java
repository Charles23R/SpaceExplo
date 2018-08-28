package planetes;

import vaisseau.Vaisseau;

public class PhumViphurit extends Planete {

    public PhumViphurit() {
        setNom("PhumViphurit");
        setDistance(((int)(Math.random()*30)+10));
        setExplore(false);
    }

}
