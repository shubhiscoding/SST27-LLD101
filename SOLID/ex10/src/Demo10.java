public class Demo10 {
    public static void main(String[] args) {
        ConsoleLogger logger = new ConsoleLogger();
        new ReportService(logger).generate();
    }
}
