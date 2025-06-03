package it.epicode.u5_w1_d1_d2pratica;

import it.epicode.u5_w1_d1_d2pratica.bean.*;
import it.epicode.u5_w1_d1_d2pratica.bean.Drink;
import it.epicode.u5_w1_d1_d2pratica.bean.Pizza;
import it.epicode.u5_w1_d1_d2pratica.bean.Topping;
import it.epicode.u5_w1_d1_d2pratica.enumeration.StatoOrdine;
import it.epicode.u5_w1_d1_d2pratica.enumeration.StatoTavolo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

@Component
public class Runner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(U5W1D1D2praticaApplication.class);


        Menu menu = ctx.getBean(Menu.class);

        System.out.println("Menù:");
        menu.getProdotti().forEach(prodotto -> {
            System.out.printf("- %s | Calorie: %d | Prezzo: €%.2f\n",
                    prodotto.getNome(), prodotto.getCalorie(), prodotto.getPrezzo());
        });

        Pizza margherita = ctx.getBean("pizzaMargherita", Pizza.class);
        Drink water = ctx.getBean("water", Drink.class);

        Tavolo tavolo = ctx.getBean("tavolo1", Tavolo.class);
        tavolo.setStato(StatoTavolo.OCCUPATO);

        Ordine ordine = new Ordine();
        ordine.setNumero(1);
        ordine.setStato(StatoOrdine.IN_CORSO);
        ordine.setProdotti(List.of(margherita, water));
        ordine.setTavolo(tavolo);
        ordine.setNumeroCoperti(2);
        ordine.setOraAcquisizione(LocalTime.now());

        System.out.println("Ordine #" + ordine.getNumero());
        System.out.println("Tavolo: " + ordine.getTavolo().getNumero());
        ordine.getProdotti().forEach(p -> System.out.printf("- %s: €%.2f\n", p.getNome(), p.getPrezzo()));
        System.out.println("Totale (inclusi coperti): €" + ordine.getTotale());

        ctx.close();


    }
}
