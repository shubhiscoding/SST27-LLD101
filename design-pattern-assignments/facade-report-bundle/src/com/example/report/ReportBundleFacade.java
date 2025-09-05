package com.example.report;

import java.nio.file.Path;
import java.util.Map;

public class ReportBundleFacade {    
    static JsonWriter jw = new JsonWriter(); 
    static Zipper z = new Zipper(); 
    static AuditLog log = new AuditLog();

    public static Path export(Map<String, Object> data, Path outDir, String name) {
        Path json = jw.write(data, outDir, name);
        Path zip = z.zip(json, Path.of("out", "report.zip"));
        log.log("exported " + zip);
        return zip;
    }
}
