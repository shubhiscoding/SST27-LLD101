public class OrderController {
    private DbQuery db;
    OrderController(DbQuery db){
        this.db = db;
    }
    void create(String id){
        db.save(id);
        System.out.println("Created order: " + id);
    }
}