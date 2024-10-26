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

   void fillTypesDishesMyself() {  // Автозаполнение
        String[] arrayTypes = {"Первое", "Гарнир", "Напиток", "Мясо", "Курица", "Рыба", "Салат"};
        String[] arrayTypesPervoe = {"Щи", "Солянка", "Окрошка", "Рассольник", "Борщ", "Куриный суп с лапшой", "Уха",
                "Суп с фрикадельками", "Грибной суп", "Гороховый суп", "Томатный суп"};
        String[] arrayTypesGarnir = {"Гречка", "Пюре", "Рис", "Овощи", "Лапша", "Перловка"};
        String[] arrayTypesNapitok = {"Молоко", "Чай", "Кофе", "Сок", "Газировка", "Вода", "Фанта", "Кола"};
        String[] arrayTypesMyaso = {"Котлета домашняя", "Поджарка свиная", "Тефтели", "Говядина тушёная", "Бифштекс", "Шашлык"};
        String[] arrayTypesKurica = {"Куриные крылышки", "Куриные наггетсы", "Запечённая курица", "Куриные голени",
                "Куриное филе на гриле", "Курица в соусе"};
        String[] arrayTypesRiba = {"Жареная рыба", "Рыба на пару", "Запечённая рыба", "Сёмга в соусе", "Судак жареный", "Филе трески"};
        String[] arrayTypesSalat = {"Оливье", "Салат Цезарь", "Винегрет", "Греческий салат", "Салат с крабовыми палочками",
                "Салат с тунцом", "Селедка под шубой", "Салат из свежих овощей", "Мимоза", "Салат с курицей и грибами"};

        for (String Type : arrayTypes) {
            dishMap.put(Type, new ArrayList<>());
        }
        for (String key : dishMap.keySet()) {
            switch (key) {
                case "Первое":
                    for (String s : arrayTypesPervoe) {
                        dishMap.get(key).add(s);
                    }
                    break;
                case "Гарнир":
                    for (String s : arrayTypesGarnir) {
                        dishMap.get(key).add(s);
                    }
                    break;
                case "Напиток":
                    for (String s : arrayTypesNapitok) {
                        dishMap.get(key).add(s);
                    }
                    break;
                case "Мясо":
                    for (String s : arrayTypesMyaso) {
                        dishMap.get(key).add(s);
                    }
                    break;
                case "Курица":
                    for (String s : arrayTypesKurica) {
                        dishMap.get(key).add(s);
                    }
                    break;
                case "Рыба":
                    for (String s : arrayTypesRiba) {
                        dishMap.get(key).add(s);
                    }
                    break;
                case "Салат":
                    for (String s : arrayTypesSalat) {
                        dishMap.get(key).add(s);
                    }
                    break;
                default:
            }
        }
        printDish();
    }

    void printDish() {
        for (String key : dishMap.keySet()) {
            System.out.println(key);
            System.out.println(dishMap.get(key).toString());
        }
    }
}
