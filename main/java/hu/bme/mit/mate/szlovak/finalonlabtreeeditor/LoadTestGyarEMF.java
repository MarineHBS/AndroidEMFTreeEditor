package hu.bme.mit.mate.szlovak.finalonlabtreeeditor;


import java.util.Iterator;

import hu.bme.mit.mate.szlovak.okosgyar.Alkatresz;
import hu.bme.mit.mate.szlovak.okosgyar.Hordozo;
import hu.bme.mit.mate.szlovak.okosgyar.OkosGyar;
import hu.bme.mit.mate.szlovak.okosgyar.Robot;

public class LoadTestGyarEMF {
    public static void main(String[] args) {
        LoadGyarEMF loader = new LoadGyarEMF();
        OkosGyar ogy = loader.load();
        System.out.println(ogy.getNev());

        for (Iterator<Robot> iterator = ogy.getRobot().iterator(); iterator.hasNext(); ) {
            Robot r = iterator.next();
            System.out.println("Id of robot: " + r.getId());
            for (Iterator<Hordozo> iterator1 = r.getHordozo().iterator(); iterator1.hasNext(); ) {
                Hordozo h = iterator1.next();
                System.out.println("Id of robot: " + r.getId() + " Id of Hordozo: " + h.getId());
                for (Iterator<Alkatresz> iterator2 = h.getAlkatresz().iterator(); iterator2.hasNext(); ) {
                    Alkatresz a = iterator2.next();
                    System.out.println("Id of robot: " + r.getId() + " Id of Hordozo: " + h.getId() + " Alkatresz sulya: "
                            + a.getSuly() + "kg Alkatresz neve: " + a.getNev());
                }
            }
        }
    }
}
