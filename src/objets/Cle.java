package objets;

import vaisseau.Vaisseau;

public class Cle extends Objet {

    public Cle() {
        setNom("clé à molette");
    }

    @Override
    public void utiliser(Vaisseau vaisseau) {
        vaisseau.setPv(vaisseau.getPv()+50);
        if (vaisseau.getPv()>100){
            vaisseau.setPv(100);
        }
        System.out.println("Clé à molette utilisée. Votre vaisseau a repris 50pv.");
    }
}
