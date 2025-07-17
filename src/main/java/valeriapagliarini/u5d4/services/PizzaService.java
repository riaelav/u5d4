package valeriapagliarini.u5d4.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d4.entities.Pizza;
import valeriapagliarini.u5d4.exceptions.NotFoundException;
import valeriapagliarini.u5d4.exceptions.ValidationException;
import valeriapagliarini.u5d4.repositories.PizzaRepository;
import valeriapagliarini.u5d4.repositories.ToppingRepository;

import java.util.List;

@Service
@Slf4j

public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private ToppingRepository toppingRepository;


    //salvataggio pizza
    public void savePizza(Pizza newPizza) {
        if (newPizza.getNome().length() < 2)
            throw new ValidationException("Il nome deve essere più lungo di 2 caratteri");
        pizzaRepository.save(newPizza);

        log.info("La pizza" + newPizza.getNome() + "è stata salvata correttamente");
    }

    //ritorno lista pizze
    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }


    //trovo pizza per id
    public Pizza findById(long pizzaId) {

        return pizzaRepository.findById(pizzaId).orElseThrow(() -> new NotFoundException(pizzaId));
    }

    //modifico pizza per id
    public void findByIdAndUpdatePizza(long id, Pizza updatedPizza) {
        Pizza existingPizza = findById(id);


        existingPizza.setNome(updatedPizza.getNome());
        existingPizza.setPrezzoBase(updatedPizza.getPrezzoBase());
        existingPizza.setToppings(updatedPizza.getToppings());


        pizzaRepository.save(existingPizza);


        log.info("La pizza con ID" + id + "è stata aggiornata con successo!");
    }
}


