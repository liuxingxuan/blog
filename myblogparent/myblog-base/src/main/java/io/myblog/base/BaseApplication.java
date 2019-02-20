package io.myblog.base;

import com.tensquare.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

    //对象放入容器
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
