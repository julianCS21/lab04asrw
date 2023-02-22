import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);


        Point[] pts=new Point[]{new Point(10, 10),new Point(10, 10), new Point(10,10)};
        Point[] pts2=new Point[]{new Point(20, 20),new Point(20, 20), new Point(20,20)};
        Point[] pts3=new Point[]{new Point(30, 30),new Point(30, 30), new Point(30,30)};
        Point[] pts4=new Point[]{new Point(40, 40),new Point(40, 40), new Point(40,40)};

        Blueprint bp=new Blueprint("julian", "plano 1",pts);
        Blueprint bp2=new Blueprint("camilo", "plano 2",pts2);
        Blueprint bp3=new Blueprint("david", "plano 3",pts3);
        Blueprint bp4=new Blueprint("julian", "plano 4",pts4);


        //agregar planos
        bps.addNewBlueprint(bp);
        bps.addNewBlueprint(bp2);
        bps.addNewBlueprint(bp3);
        bps.addNewBlueprint(bp4);



        //consultar planos por autor y nombre del plano

        Blueprint result = bps.getBlueprint(bp.getAuthor(),bp.getName());
        Blueprint result2 = bps.getBlueprint(bp2.getAuthor(),bp2.getName());
        Blueprint result3 = bps.getBlueprint(bp3.getAuthor(),bp3.getName());
        Blueprint result4 = bps.getBlueprint(bp4.getAuthor(),bp4.getName());

        System.out.println("PLANO : " + result.toString());

        System.out.println("PLANO : " + result2.toString());

        System.out.println("PLANO : " + result3.toString());

        System.out.println("PLANO : " + result4.toString());






        //consultar todos los planos de un autor

        Set<Blueprint> result5 = bps.getBlueprintsByAuthor("julian");

        for(Blueprint bpr : result5){
            System.out.println("PLANO : " + bpr.toString() );
        }









    }
}
