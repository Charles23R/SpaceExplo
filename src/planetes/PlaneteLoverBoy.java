package planetes;

import vaisseau.Vaisseau;

public class PlaneteLoverBoy extends Planete {

    public PlaneteLoverBoy() {
        setNom("Lover Boy");
        setDistance(((int)(Math.random()*30)+10));
        setExplore(false);
    }
}
