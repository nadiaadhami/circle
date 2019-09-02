package nadiatests;


public class CenterCircle {
    public static void main(String[] args) {
        pt pt1 = new pt(1, 5);
        pt pt2 = new pt(2, 5);
        pt pt3 = new pt(3, 5);
        pt center = circleCenter(pt1, pt2, pt3);
        System.out.println("center: "+center.toString());
    }
    public static class pt {
        float x;
        float y;

        public pt(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(x="+x+",y="+y+")";
        }
    }
    public static pt circleCenter(pt A, pt B, pt C) {

        float yDelta_a = B.y - A.y;
        float xDelta_a = B.x - A.x;
        float yDelta_b = C.y - B.y;
        float xDelta_b = C.x - B.x;
        pt center = new pt(0,0);

        float aSlope = yDelta_a/xDelta_a;
        float bSlope = yDelta_b/xDelta_b;
        center.x = (aSlope*bSlope*(A.y - C.y) + bSlope*(A.x + B.x)
                - aSlope*(B.x+C.x) )/(2* (bSlope-aSlope) );
        center.y = -1*(center.x - (A.x+B.x)/2)/aSlope +  (A.y+B.y)/2;

        return center;
    }
}
