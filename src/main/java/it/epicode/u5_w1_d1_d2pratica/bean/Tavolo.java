package it.epicode.u5_w1_d1_d2pratica.bean;

import it.epicode.u5_w1_d1_d2pratica.enumeration.StatoTavolo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tavolo {
    private int numero;
    private int copertiMax;
    private StatoTavolo stato;
}
