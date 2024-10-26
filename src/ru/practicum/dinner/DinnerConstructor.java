package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dishMap = new HashMap<>();
    ArrayList<String> inputTypesArray = new ArrayList<>();
    Random random = new Random();

    boolean checkType(String type) {
        return dishMap.containsKey(type);
    }

    boolean checkDishName(String type, String dishName) {
        return dishMap.get(type).contains(dishName);
    }

    void addingDish(String dishType, String dishName) {  //добавление блюда
        if (checkType(dishType)) {
            if (!checkDishName(dishType, dishName)) {
                dishMap.get(dishType).add(dishName);
            }

        } else {
            dishMap.put(dishType, new ArrayList<>());
            dishMap.get(dishType).add(dishName);
        }
    }

    void DishCombo(int numberOfCombos) {
        for (int j = 0; j < numberOfCombos; j++) {
            HashMap<Integer, ArrayList<String>> combos = new HashMap<>();
            ArrayList<String> forCombosArray = new ArrayList<>();
            for (String key : inputTypesArray) {
                int maxsize = dishMap.get(key).size();  // размер массива имен блюд. выбранного типа.
                int randomSelect = random.nextInt(maxsize);  //выбираем случайны номер блюда
                String choyse = dishMap.get(key).get(randomSelect);
                forCombosArray.add(choyse);
            }
            combos.put(j + 1, forCombosArray);
            System.out.println("Комбо " + (j + 1));
            System.out.println(combos.get(j + 1).toString());
        }
        inputTypesArray.clear();
    }
}
