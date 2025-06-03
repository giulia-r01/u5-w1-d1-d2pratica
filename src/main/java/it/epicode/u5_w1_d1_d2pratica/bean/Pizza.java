package it.epicode.u5_w1_d1_d2pratica.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class Pizza extends Prodotto{
    private List<Topping> toppings;
}
