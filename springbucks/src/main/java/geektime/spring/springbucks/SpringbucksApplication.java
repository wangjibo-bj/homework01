package geektime.spring.springbucks;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
@MapperScan("geektime.spring.springbucks")
public class SpringbucksApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}

}
