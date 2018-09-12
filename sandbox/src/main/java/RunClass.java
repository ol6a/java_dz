public class RunClass {
        public static void main (String[] args){
            Point p1=new Point();
            p1.x=4;
            p1.y=3;
            Point p2=new Point();
            p2.x=2;
            p2.y=2;
            System.out.println("Расстояние между точкой p2 c координатами ("+p2.x+","+p2.y+")" +
                    " и точкой p1 с координатами ("+p1.x+','+p1.y+")"+" = "+ distance(p1,p2));
            double d;
            d=p2.rasstoyanie(p1);
            System.out.println("Расстояние между точкой p2 c координатами ("+p2.x+","+p2.y+")" +
                    " и точкой p1 с координатами ("+p1.x+','+p1.y+")"+" = "+ d);
        }
        public static double distance(Point p1, Point p2){
            double r;
            r=Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
            return r;
        }
}
