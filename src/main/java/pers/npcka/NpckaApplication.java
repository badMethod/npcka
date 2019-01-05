package pers.npcka;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "pers.npcka.dao")
public class NpckaApplication {

    public static void main(String[] args) {
        SpringApplication.run(NpckaApplication.class, args);
    }
}













