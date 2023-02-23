package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.redundancyFilter;
import edu.eci.arsw.blueprints.persistence.subsamplingFilter;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class filterTest {

    @Test
    public void GivenABlueprintsThenShouldApplyFilterByRedundancy(){
        //Arrange
        Point[] pts=new Point[]{new Point(10, 10),new Point(10, 10), new Point(10,10)};
        Point[] pts2=new Point[]{new Point(20, 20),new Point(20, 20), new Point(20,20)};

        Blueprint bp=new Blueprint("julian", "plano 1",pts);
        Blueprint bp2=new Blueprint("camilo", "plano 2",pts2);

        Set<Blueprint> bps = new HashSet<>();
        bps.add(bp);
        bps.add(bp2);
        redundancyFilter rf = new redundancyFilter();


        //Act
        rf.filter(bps);

        //Assert
        boolean validate = true;
        for(Blueprint results : bps){
            List<Point> partial = results.getPoints();
            for(int i = 1; i < partial.size(); i++){
                if(partial.get(i).getX() == partial.get(i-1).getX() && partial.get(i).getY() == partial.get(i-1).getY()){
                    validate = false;
                }
            }
        }
        Assert.assertTrue(validate);

    }


    @Test
    public void GivenABluePrintsThenShouldApplyFilterBySubsampling(){
        //Arrange
        Point[] pts=new Point[]{new Point(10, 10),new Point(20, 10), new Point(30,20),new Point(40,30)};
        Point[] ptsAssert =new Point[]{new Point(10, 10),new Point(40, 30)};


        Blueprint bp=new Blueprint("julian", "plano 1",pts);


        Set<Blueprint> bps = new HashSet<>();
        bps.add(bp);
        subsamplingFilter sf = new subsamplingFilter();


        //act
        sf.filter(bps);

        //Assert
        boolean validate = true;
        for(Blueprint results : bps){
            List<Point> partial = results.getPoints();
            for(int i = 0; i < partial.size(); i++){
                if(partial.get(i).getX() != ptsAssert[i].getX() || partial.get(i).getY() != ptsAssert[i].getY()){
                    validate = false;
                }

            }
        }

        Assert.assertTrue(validate);

    }

}
