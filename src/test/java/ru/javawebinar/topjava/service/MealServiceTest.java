package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    static {
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(MEAL_ID_1, USER_ID);
        assertMatch(meal, userMeal1);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(NOT_FOUND, USER_ID));
    }

    @Test
    public void delete() {
        service.delete(MEAL_ID_1, USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(MEAL_ID_1, USER_ID));
    }

    @Test
    public void deleteNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(NOT_FOUND, ADMIN_ID));
    }

    @Test
    public void getBetweenInclusive() {
        assertMatch(service.getBetweenInclusive(START, END, USER_ID), userMealsBetween);
    }

    public void getBetweenWithNullDates() {
        assertMatch(service.getBetweenInclusive(null, null, USER_ID), userMeals);
    }

    @Test
    public void getAll() {
        assertMatch(service.getAll(USER_ID), userMeals);
    }

    @Test
    public void update() {
        Meal updated = getUpdated();
        service.update(updated, USER_ID);
        assertMatch(service.get(updated.getId(), USER_ID), updated);
    }

    @Test
    public void updateNotFound() {
        assertThrows(NotFoundException.class, () -> service.update(userMeal1, ADMIN_ID));
    }

    @Test
    public void create() {
        Meal created = service.create(getNew(), USER_ID);
        Meal newMeal = getNew();
        newMeal.setId(created.getId());
        assertMatch(newMeal, created);
        assertMatch(service.getAll(USER_ID), newMeal, userMeal4, userMeal3, userMeal2, userMeal1);
    }

    @Test
    public void duplicateDateTimeCreate() {
        assertThrows(DataAccessException.class, () -> service.create(getDuplicate(), USER_ID));
    }
}