package valeriapagliarini.u5d4.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import valeriapagliarini.u5d4.entities.Topping;
import valeriapagliarini.u5d4.services.PizzaService;
import valeriapagliarini.u5d4.services.ToppingService;

@Component
public class Runner implements CommandLineRunner {

    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private ToppingService toppingService;


    @Override
    public void run(String... args) throws Exception {

        Topping topping1 = new Topping("ham", 2.5, 4);
        //toppingService.saveTopping(topping1);
        Topping topping2 = new Topping("mushrooms", 2.3, 7);
        toppingService.saveTopping(topping2);
        Topping topping3 = new Topping("cheese", 3.2, 5);
        toppingService.saveTopping(topping3);


    }
}
