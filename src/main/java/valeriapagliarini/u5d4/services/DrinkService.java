package valeriapagliarini.u5d4.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d4.entities.Drink;
import valeriapagliarini.u5d4.exceptions.NotFoundException;
import valeriapagliarini.u5d4.exceptions.ValidationException;
import valeriapagliarini.u5d4.repositories.DrinkRepository;

import java.util.List;

@Service
@Slf4j
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;


    // salvo i drink
    public void saveDrink(Drink newDrink) {
        if (newDrink.getNome().length() < 2)
            throw new ValidationException("Il nome del drink deve essere più lungo di 2 caratteri");
        drinkRepository.save(newDrink);
        log.info("Il drink {} è stato salvato correttamente", newDrink.getNome());
    }

    // lista drink
    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    // trovo drink
    public Drink findById(long drinkId) {
        return drinkRepository.findById(drinkId)
                .orElseThrow(() -> new NotFoundException(drinkId));
    }

    // modifico drink
    public void findByIdAndUpdateDrink(long id, Drink updatedDrink) {
        Drink existingDrink = findById(id);
        existingDrink.setNome(updatedDrink.getNome());
        existingDrink.setPrezzo(updatedDrink.getPrezzo());

        drinkRepository.save(existingDrink);
        log.info("Il drink con ID {} è stato aggiornato con successo!", id);
    }
}


