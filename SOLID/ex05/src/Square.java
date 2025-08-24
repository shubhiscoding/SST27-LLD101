
public class Square extends Shape implements ResizeSquare{
    int length;
    
    void setLenght(int w){ this.length = w; }

    @Override
    int area() {
        return length * length;
    }

    @Override
    public int areaAfterResize(int s) {
        setLenght(s);
        return this.area();
    }
}