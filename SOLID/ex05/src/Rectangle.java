public class Rectangle extends Shape implements ResizeRectangle{
    protected int w,h;
    void setWidth(int w){ this.w = w; }
    void setHeight(int h){ this.h = h; }
    @Override
    int area() {
        return this.w * this.h;
    }
    @Override
    public int areaAfterResize(int l, int w) {
        setHeight(l);
        setWidth(w);
        return this.area();
    }
}