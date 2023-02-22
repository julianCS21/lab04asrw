import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.services.BlueprintsServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws BlueprintPersistenceException, BlueprintNotFoundException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bps = ac.getBean(BlueprintsServices.class);


        //agregar planos


        Point[] pts=new Point[]{new Point(10, 10),new Point(10, 10), new Point(10,10)};
        Point[] pts2=new Point[]{new Point(20, 20),new Point(20, 20), new Point(20,20)};
        Point[] pts3=new Point[]{new Point(30, 30),new Point(30, 30), new Point(30,30)};

        Blueprint bp=new Blueprint("julian", "plano 1",pts);
        Blueprint bp2=new Blueprint("camilo", "plano 2",pts2);
        Blueprint bp3=new Blueprint("david", "plano 3",pts3);
        Blueprint bp4=new Blueprint("julian", "plano 4",pts);
    }
}
