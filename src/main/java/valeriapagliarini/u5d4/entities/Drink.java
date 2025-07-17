package valeriapagliarini.u5d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "drinks")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Drink {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double prezzo;


    public Drink(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }
}
