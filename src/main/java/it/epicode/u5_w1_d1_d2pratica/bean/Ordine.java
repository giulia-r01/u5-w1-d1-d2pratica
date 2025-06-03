package it.epicode.u5_w1_d1_d2pratica.bean;

import it.epicode.u5_w1_d1_d2pratica.enumeration.StatoOrdine;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
public class Ordine {
    private int numero;
    private StatoOrdine stato;
    private List<Prodotto> prodotti;
    private Tavolo tavolo;
    private int numeroCoperti;
    private LocalTime oraAcquisizione;
    private double costoCoperto = 2.0;

    public double getTotale(){
        double somma = prodotti.stream().mapToDouble(Prodotto::getPrezzo).sum();
        return somma + (numeroCoperti*costoCoperto);
    }
}
