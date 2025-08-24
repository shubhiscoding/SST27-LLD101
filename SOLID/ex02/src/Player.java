public class Player {
    private ICache cache;
    private IRender renderManager;
    Player(ICache cache, IRender render){
        this.cache = cache;
        this.renderManager = render;
    }
    void play(){
        // draw UI
        this.renderManager.draw();
        // cache
        this.cache.cache();
    }
}