package no.kino.spring;

import com.sun.corba.se.impl.activation.CommandHandler;
import no.kino.command.KinoCommandHandler;
import no.kino.command.OpprettNyForestilling;
import no.kino.web.Filmprogram;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"no.kino.projections","no.kino.web"})
public class SpringConfig {
    SpringConfig(){
        System.out.println("SpringConfig OK!");


        //KinoCommandHandler kinoCommandHandler = new KinoCommandHandler();
        //kinoCommandHandler.handle(new OpprettNyForestilling("bullshit", 10));
    }
}
