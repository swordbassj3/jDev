package org.hdcd.board;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Mapper Interface Scan Active
//@MapperScan(basePackages="org.hdcd.board")
public class BoardApplication {
	public static void main(String[] args) {
		System.out.print("Hellow Board");
		SpringApplication.run(BoardApplication.class, args);
	}
}
