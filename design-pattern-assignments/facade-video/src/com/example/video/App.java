package com.example.video;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        Path out = VideoPipelineFacade.process(Path.of("in.mp4").toAbsolutePath(), Path.of("out.mp4").toAbsolutePath(), 0.5);
        System.out.println("Wrote " + out);
    }
}
