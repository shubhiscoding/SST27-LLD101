public class Cache implements ICache{
    private IFrame last;
    Cache(IFrame last){
        this.last = last;
    }
    public void cache(){
        System.out.println("Cached last frame? " + (last!=null));
    }
}
