package br.ufc.quixada.npi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class AutoEstudoApplication {
    public static final Logger log = LoggerFactory.getLogger(AutoEstudoApplication.class);

    @RequestMapping(path="/ola")
    @ResponseBody
    public String ola() {
        return "Ola";
    }


	public static void main(String[] args) {
		SpringApplication.run(AutoEstudoApplication.class, args);
	}
}
