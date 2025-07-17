package valeriapagliarini.u5d4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "pizzas")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double prezzoBase;

    @ManyToMany
    @JoinTable(
            name = "pizza_topping",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id")
    )
    private List<Topping> toppings;

    public Pizza(String nome, double prezzoBase, List<Topping> toppings) {
        this.nome = nome;
        this.prezzoBase = prezzoBase;
        this.toppings = toppings;
    }
}
