package valeriapagliarini.u5d4.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d4.entities.Topping;
import valeriapagliarini.u5d4.exceptions.NotFoundException;
import valeriapagliarini.u5d4.exceptions.ValidationException;
import valeriapagliarini.u5d4.repositories.ToppingRepository;

import java.util.List;

@Service
@Slf4j
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;

    // salvo topping
    public void saveTopping(Topping newTopping) {
        if (newTopping.getNome() == null || newTopping.getNome().length() < 2) {
            throw new ValidationException("Il nome del topping deve essere più lungo di 2 caratteri");
        }

        toppingRepository.save(newTopping);
        log.info("Il topping '{}' è stato salvato correttamente", newTopping.getNome());
    }

    // lista topping
    public List<Topping> findAll() {
        return toppingRepository.findAll();
    }

    // trovo un topping
    public Topping findById(long toppingId) {
        return toppingRepository.findById(toppingId)
                .orElseThrow(() -> new NotFoundException(toppingId));
    }

    //modifico un topping
    public void findByIdAndUpdateTopping(long id, Topping updatedTopping) {
        Topping existing = findById(id);

        if (updatedTopping.getNome() == null || updatedTopping.getNome().length() < 2) {
            throw new ValidationException("Il nome del topping deve essere più lungo di 2 caratteri");
        }

        existing.setNome(updatedTopping.getNome());
        existing.setPrezzo(updatedTopping.getPrezzo());
        existing.setCalorie(updatedTopping.getCalorie());

        toppingRepository.save(existing);
        log.info("Il topping con ID {} è stato aggiornato con successo!", id);
    }

    // elimino toppomg
    public void deleteById(long id) {
        if (!toppingRepository.existsById(id)) {
            throw new NotFoundException(id);
        }

        toppingRepository.deleteById(id);
        log.info("Il topping con ID" + id + " è stato eliminato con successo!");
    }
}
