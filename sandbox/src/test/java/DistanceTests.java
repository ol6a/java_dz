import org.testng.Assert;
import org.testng.annotations.Test;
public class DistanceTests {
    @Test
    public void testRasstoyanie (){
        Point p1=new Point();
        p1.x=4;
        p1.y=3;
        Point p2=new Point();
        p2.x=2;
        p2.y=2;
       Assert.assertEquals((p2.rasstoyanie(p1)), 2.23606797749979);

    }


    }
