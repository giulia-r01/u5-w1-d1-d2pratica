package it.epicode.u5_w1_d1_d2pratica.configuration;

import it.epicode.u5_w1_d1_d2pratica.bean.*;
import it.epicode.u5_w1_d1_d2pratica.enumeration.StatoOrdine;
import it.epicode.u5_w1_d1_d2pratica.enumeration.StatoTavolo;
import it.epicode.u5_w1_d1_d2pratica.enumeration.TipoDrink;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Configuration
public class AppConfig {

    @Primary
    @Bean(name = "water")
    public Drink getWater(){
        Drink water = new Drink();
        water.setTipoDrink(TipoDrink.ANALCOLICO);
        water.setCalorie(0);
        water.setPrezzo(1);
        water.setNome("Water");
        return water;
    }

    @Bean(name = "beer")
    public Drink getBeer(){
        Drink beer = new Drink();
        beer.setTipoDrink(TipoDrink.ALCOLICO);
        beer.setCalorie(0);
        beer.setPrezzo(1);
        beer.setNome("Beer");
        return beer;
    }

    @Bean(name = "cocaCola")
    public Drink getCocaCola(){
        Drink cocaCola = new Drink();
        cocaCola.setTipoDrink(TipoDrink.ANALCOLICO);
        cocaCola.setCalorie(0);
        cocaCola.setPrezzo(1);
        cocaCola.setNome("Coca-Cola");
        return cocaCola;
    }

    @Bean(name = "wine")
    public Drink getWine(){
        Drink wine = new Drink();
        wine.setTipoDrink(TipoDrink.ALCOLICO);
        wine.setCalorie(0);
        wine.setPrezzo(1);
        wine.setNome("Wine");
        return wine;
    }



    @Bean(name = "tomato")
    @Primary
    public Topping getTomato(){
        Topping tomato = new Topping();
        tomato.setNome("Tomato");
        tomato.setPrezzo(1);
        tomato.setCalorie(100);
        tomato.setGlutenFree(true);
        return tomato;
    }

    @Bean(name = "mozzarella")
    public Topping getMozzarella(){
        Topping mozzarella = new Topping();
        mozzarella.setNome("Mozzarella");
        mozzarella.setPrezzo(1);
        mozzarella.setCalorie(200);
        mozzarella.setGlutenFree(true);
        return mozzarella;
    }

    @Bean(name = "mushrooms")
    public Topping getuMshrooms(){
        Topping mushrooms = new Topping();
        mushrooms.setNome("Mushrooms");
        mushrooms.setPrezzo(1.50);
        mushrooms.setCalorie(80);
        mushrooms.setGlutenFree(true);
        return mushrooms;
    }

    @Bean(name = "peperoni")
    public Topping getPeperoni(){
        Topping peperoni = new Topping();
        peperoni.setNome("Peperoni");
        peperoni.setPrezzo(1.20);
        peperoni.setCalorie(300);
        peperoni.setGlutenFree(true);
        return peperoni;
    }

    @Primary
    @Bean(name = "pizzaMargherita")
    public Pizza pizzaMargherita(Topping tomato, Topping mozzarella) {
        Pizza margherita = new Pizza();
        margherita.setNome("Pizza Margherita (tomato, cheese)");
        margherita.setToppings(List.of(tomato, mozzarella));
        margherita.setCalorie(tomato.getCalorie() + mozzarella.getCalorie());
        margherita.setPrezzo(tomato.getPrezzo() + mozzarella.getPrezzo());
        return margherita;
    }

    @Bean(name = "peperoniPizza")
    public Pizza salamiPizza(Topping tomato, Topping mozzarella,
                             Topping peperoni) {
        Pizza peperoniPizza = new Pizza();
        peperoniPizza.setNome("Peperoni Pizza (tomato, cheese, peperoni)");
        peperoniPizza.setToppings(List.of(tomato, mozzarella, peperoni));
        peperoniPizza.setCalorie(tomato.getCalorie() + mozzarella.getCalorie()
                + peperoni.getCalorie());
        peperoniPizza.setPrezzo(tomato.getPrezzo() + mozzarella.getPrezzo()
                + peperoni.getPrezzo());
        return peperoniPizza;
    }

    @Bean(name = "mushroomPizza")
    public Pizza mushroomPizza(Topping tomato, Topping mozzarella,
                             Topping mushroom) {
        Pizza mushroomPizza = new Pizza();
        mushroomPizza.setNome("Mushroom Pizza (tomato, cheese, mushroom)");
        mushroomPizza.setToppings(List.of(tomato, mozzarella, mushroom));
        mushroomPizza.setCalorie(tomato.getCalorie() + mozzarella.getCalorie()
                + mushroom.getCalorie());
        mushroomPizza.setPrezzo(tomato.getPrezzo() + mozzarella.getPrezzo()
                + mushroom.getPrezzo());
        return mushroomPizza;
    }

    @Bean
    public Menu menu(List<Prodotto> prodotti) {
        Menu menu = new Menu();
        menu.setProdotti(prodotti);
        return menu;
    }

    @Bean
    public Tavolo tavolo1(){
        Tavolo t = new Tavolo();
        t.setNumero(1);
        t.setCopertiMax(4);
        t.setStato(StatoTavolo.LIBERO);
        return t;
    }

}
