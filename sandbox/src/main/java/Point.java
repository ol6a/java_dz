public class Point {
public double x;
public double y;

public double rasstoyanie(Point p1){
    return Math.sqrt((this.x-p1.x)*(this.x-p1.x)+(this.y-p1.y)*(this.y-p1.y));
}
}
