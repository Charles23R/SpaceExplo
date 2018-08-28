package planetes;

import vaisseau.Vaisseau;

public class ValNature extends Planete {

    public ValNature() {
        setNom("ValNature");
        setDistance(((int)(Math.random()*30)+10));
        setExplore(false);
    }
}
