
public class Demo05 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        Square sqr = new Square();
        System.out.println(rect.areaAfterResize(5, 4)); // 20
        System.out.println(sqr.areaAfterResize(4));    // 16 (!) violates expectation
    }
}
