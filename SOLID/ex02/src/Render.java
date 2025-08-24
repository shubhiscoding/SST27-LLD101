public class Render implements IRender{
    private IFrame last;
    Render(IFrame last){
        this.last = last;
    }
    public void draw(){
        System.out.println("\u25B6 Playing " + last.getData().length + " bytes");
    }
}
