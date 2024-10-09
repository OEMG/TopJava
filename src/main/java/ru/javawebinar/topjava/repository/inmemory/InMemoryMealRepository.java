package ru.javawebinar.topjava.repository.inmemory;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryMealRepository implements Repository<Meal> {
    public static ConcurrentHashMap<Integer, Meal> meals = new ConcurrentHashMap<>();
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    {
        meals.put(AUTO_ID.incrementAndGet(), new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        meals.put(AUTO_ID.incrementAndGet(), new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        meals.put(AUTO_ID.incrementAndGet(), new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        meals.put(AUTO_ID.incrementAndGet(), new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        meals.put(AUTO_ID.incrementAndGet(), new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        meals.put(AUTO_ID.incrementAndGet(), new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        meals.put(AUTO_ID.incrementAndGet(), new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }

    @Override
    public void save(Meal meal) {
        meal.setId(AUTO_ID.incrementAndGet());
        meals.put(meal.getId(), meal);
    }

    @Override
    public Meal get(Integer id) {
        return meals.get(id);
    }

    @Override
    public void delete(Integer id) {
        meals.remove(id);
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(meals.values());
    }
}
