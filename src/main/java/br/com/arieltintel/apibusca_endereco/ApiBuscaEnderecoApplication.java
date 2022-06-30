package br.com.arieltintel.apibusca_endereco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiBuscaEnderecoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBuscaEnderecoApplication.class, args);
    }

}
