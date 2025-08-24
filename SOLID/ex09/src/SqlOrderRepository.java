public class SqlOrderRepository implements DbQuery{
    public void save(String id){ 
        System.out.println("Saved order " + id + " to SQL"); 
    }
}
