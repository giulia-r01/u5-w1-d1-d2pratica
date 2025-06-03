package it.epicode.u5_w1_d1_d2pratica.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Component
public class Menu {
    @Autowired
    private List<Prodotto> prodotti;


}
