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


        //Esercizio #1 u5-w1-d1
        Menu menu = ctx.getBean(Menu.class);

        System.out.println(String.format("%-40s %-10s %-10s", "Pizzas", "Calories", "Price"));

        menu.getProdotti().stream()
                .filter(p -> p instanceof Pizza)
                .forEach(p -> System.out.printf("%-40s %-10d €%.2f\n", p.getNome(), p.getCalorie(), p.getPrezzo()));

        System.out.println("\n" + String.format("%-40s %-10s %-10s", "Toppings", "Calories", "Price"));

        menu.getProdotti().stream()
                .filter(p -> p instanceof Topping)
                .forEach(p -> System.out.printf("%-40s %-10d €%.2f\n", p.getNome(), p.getCalorie(), p.getPrezzo()));

        System.out.println("\n" + String.format("%-40s %-10s %-10s", "Drinks", "Calories", "Price"));

        menu.getProdotti().stream()
                .filter(p -> p instanceof Drink)
                .forEach(p -> System.out.printf("%-40s %-10d €%.2f\n", p.getNome(), p.getCalorie(), p.getPrezzo()));


        //Esercizio #1 u5-w1-d2
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

        System.out.println("\nOrdine #" + ordine.getNumero());
        System.out.println("Tavolo: " + ordine.getTavolo().getNumero());
        ordine.getProdotti().forEach(p -> System.out.printf("- %s: €%.2f\n", p.getNome(), p.getPrezzo()));
        System.out.println("Totale (inclusi coperti): €" + ordine.getTotale());

        ctx.close();


    }
}
