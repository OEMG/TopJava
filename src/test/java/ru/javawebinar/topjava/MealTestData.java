package ru.javawebinar.topjava;


import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.of;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {
    public static final int MEAL_ID_1 = START_SEQ + 3;
    public static final int TEST_ID = 123;
    public static final LocalDate start = LocalDate.of(2024, 10, 20);
    public static final LocalDate end = LocalDate.of(2024, 10, 21);

    public static final Meal userMeal1 = new Meal(MEAL_ID_1, of(2024, 10, 20, 9, 0), "Завтрак", 1001);
    public static final Meal userMeal2 = new Meal(MEAL_ID_1 + 1, of(2024, 10, 20, 14, 0), "Обед", 1002);
    public static final Meal userMeal3 = new Meal(MEAL_ID_1 + 2, of(2024, 10, 21, 21, 0), "Ужин", 1003);
    public static final Meal userMeal4 = new Meal(MEAL_ID_1 + 3, of(2024, 10, 22, 9, 0), "Завтрак", 2004);

    public static final Meal adminMeal5 = new Meal(MEAL_ID_1 + 4, of(2024, 10, 20, 14, 0), "Обед Админ", 2005);
    public static final Meal adminMeal6 = new Meal(MEAL_ID_1 + 5, of(2024, 10, 21, 10, 0), "Завтрак Админ", 506);
    public static final Meal adminMeal7 = new Meal(MEAL_ID_1 + 6, of(2024, 10, 21, 13, 0), "Обед Админ", 507);
    public static final Meal adminMeal8 = new Meal(MEAL_ID_1 + 7, of(2024, 10, 22, 20, 0), "Ужин Админ", 2008);

    public static final List<Meal> userMeals = Arrays.asList(userMeal4, userMeal3, userMeal2, userMeal1);
    public static final List<Meal> userMealsBetween = Arrays.asList(userMeal3, userMeal2, userMeal1);

    public static Meal getNew() {
        return new Meal(null, of(2025, 10, 10, 10, 10), "Created meal", 666);
    }

    public static Meal getDuplicate() {
        return new Meal(null, userMeal1.getDateTime(), "Duplicate meal", 666);
    }

    public static Meal getUpdated() {
        return new Meal(MEAL_ID_1, userMeal1.getDateTime(), "Update meal", 777);
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);
    }
}