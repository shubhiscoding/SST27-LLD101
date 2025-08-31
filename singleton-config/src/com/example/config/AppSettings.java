package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private final Properties props = new Properties();
    private static volatile boolean instanceCreated = false;

    private AppSettings() {
        if (instanceCreated) {
            throw new RuntimeException("Use getInstance()");
        }
        instanceCreated = true;
    }

    public static AppSettings getInstance() {
        return SingletonHelper.getInstance();
    }

    private static class SingletonHelper {
        private static volatile AppSettings INSTANCE;

        static AppSettings getInstance() {

            if(INSTANCE == null){
                synchronized (AppSettings.class) {
                    if (INSTANCE == null) {
                        INSTANCE = new AppSettings();
                    }
                }
            }
            return INSTANCE;
        }
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    private Object readResolve() {
        return getInstance();
    }
}
