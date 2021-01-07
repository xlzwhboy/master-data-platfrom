package custom.master.server;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "custom.master.*")
@EntityScan(basePackages = "custom.master.entity")   //model模型扫描
@EnableJpaRepositories(basePackages = "custom.master.repository") //jpa包
@Slf4j
@EnableScheduling  //定时任务
public class MasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(MasterApplication.class);
    }
}
