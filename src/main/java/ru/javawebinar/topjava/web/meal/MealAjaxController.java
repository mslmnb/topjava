package ru.javawebinar.topjava.web.meal;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import javax.print.attribute.standard.Media;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Created by Mussulmanbekova_GE on 26.05.2017.
 */
@RestController
@RequestMapping(value="/ajax/profile/meals")
public class MealAjaxController extends AbstractMealController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        super.delete(id);
    }


    @PostMapping
    public Meal create(@RequestParam("id") Integer id,
//                       @RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
                       @RequestParam("description") String description,
                       @RequestParam("calories") Integer calories
                       ) {
        Meal meal = new Meal(id, LocalDateTime.now(), description, calories);
        return super.create(meal);
    }
}
