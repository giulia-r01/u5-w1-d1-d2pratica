package it.epicode.u5_w1_d1_d2pratica.bean;

import it.epicode.u5_w1_d1_d2pratica.enumeration.TipoDrink;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Drink extends Prodotto{
    private TipoDrink tipoDrink;
}
