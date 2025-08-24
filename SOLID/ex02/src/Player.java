public class Player {
    private Frame last;
    Player(Frame frm){
        this.last = frm;
    }
    void play(){
        // draw UI
        System.out.println("\u25B6 Playing " + last.data.length + " bytes");
        // cache
        System.out.println("Cached last frame? " + (last!=null));
    }
}