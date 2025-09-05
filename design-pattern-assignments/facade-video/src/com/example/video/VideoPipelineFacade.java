package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
    static Decoder dec = new Decoder();
    static FilterEngine fe = new FilterEngine();
    static Encoder enc = new Encoder();

    public static Path process(Path in, Path out, double factor) {
        Frame[] frames = dec.decode(in);
        frames = fe.grayscale(frames);
        frames = fe.scale(frames, factor);
        return enc.encode(frames, out);
    }
}
