public class ConsoleLogger implements IConsoleLogger{
    public void log(String msg){ 
        System.out.println("[LOG] " + msg); 
    }
}