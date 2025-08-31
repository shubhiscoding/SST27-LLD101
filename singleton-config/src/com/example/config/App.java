// package com.example.config;

// import java.nio.file.Path;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Set;
// import java.util.concurrent.ConcurrentSkipListSet;

// public class App {
//     public static void main(String[] args) throws Exception {
//         String path = args.length > 0 ? args[0] : "app.properties";
//         AppSettings.getInstance().loadFromFile(Path.of(path));

//         int threadCount = 10;
//         Set<Integer> instanceIds = new ConcurrentSkipListSet<>();
//         List<Thread> threads = new ArrayList<>(threadCount);
        
//         for (int i = 0; i < threadCount; i++) {
//             Thread t = new Thread(() -> {
//                 AppSettings instance = AppSettings.getInstance();
//                 int id = System.identityHashCode(AppSettings.getInstance());
//                 instanceIds.add(id);
//                 System.out.println("Thread: " + Thread.currentThread().getName() +
//                         ", instance=" + id +
//                         ", app.name=" + instance.get("app.name"));
//             });
//             threads.add(t);
//             t.start();
//         }

//         // Wait for all threads to finish
//         for (Thread t : threads) {
//             t.join();
//         }

//         System.out.println("Unique instance hash codes: " + instanceIds.size());
//         System.out.println("Instance hash codes: " + instanceIds);
//     }
// }

package com.example.config;

import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) throws Exception {
        String path = args.length > 0 ? args[0] : "app.properties";
        AppSettings.getInstance().loadFromFile(Path.of(path));

        int threadCount = 10;
        CountDownLatch latch = new CountDownLatch(threadCount);
        Set<Integer> instanceIds = new ConcurrentSkipListSet<>();

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                AppSettings instance = AppSettings.getInstance();
                int id = System.identityHashCode(instance);
                instanceIds.add(id);
                System.out.println("Thread: " + Thread.currentThread().getName() +
                        ", instance=" + id +
                        ", app.name=" + instance.get("app.name"));
                latch.countDown();
            }).start();
        }

        latch.await(); // Wait for all threads to finish

        System.out.println("Unique instance hash codes: " + instanceIds.size());
        System.out.println("Instance hash codes: " + instanceIds);
    }
}
