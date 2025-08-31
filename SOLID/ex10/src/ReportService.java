public class ReportService {
    IConsoleLogger logger;
    ReportService(IConsoleLogger logger){
        this.logger = logger;
    }
    void generate(){
        logger.log("Generating daily report...");
        System.out.println("Report contents...");
    }
}