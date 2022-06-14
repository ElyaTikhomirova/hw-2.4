package ru.skypro;

public class Main {

    public static void main(String[] args) {
        boolean result = Checkup.check ("tikhomirova", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        if(result){
            System.out.println("Все корректно");
        }else {
            System.out.println("Логин и/или пароль некорретны");
        }
    }

}
