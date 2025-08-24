public class Demo09 {
    public static void main(String[] args) {
        SqlOrderRepository db = new SqlOrderRepository();
        new OrderController(db).create("ORD-1");
    }
}
