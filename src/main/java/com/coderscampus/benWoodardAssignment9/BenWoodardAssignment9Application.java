package com.coderscampus.benWoodardAssignment9;
import com.coderscampus.benWoodardAssignment9.domain.Recipe;
import com.coderscampus.benWoodardAssignment9.service.FileService;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.util.List;

@SpringBootApplication
public class BenWoodardAssignment9Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BenWoodardAssignment9Application.class, args);

	}

}
