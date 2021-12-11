package com.example.piaoduoduo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.nio.charset.StandardCharsets;

@SpringBootTest
class PiaoduoduoApplicationTests {

    @Test
    void contextLoads() {
        try {
            File f = new File("C:\\Users\\delicious jiayao\\Desktop\\giao.txt");
            OutputStream os = new FileOutputStream(f,false);
            os.write("cao".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            System.out.print("Exception");
        }
    }

}
