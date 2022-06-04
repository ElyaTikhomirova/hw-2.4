package ru.skypro;

import java.util.Objects;

public class Checkup{
    private static final String SYMBOLS = "abcdefghijgklmnoprstvqwxuzABCDEFGHJIGKLMNOPRSTQWVXUZ0123456789_";

    private Checkup(){
    }
    public static boolean check (String login, String password, String confirmPassword) {
        try {
            checkup(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    private static void checkup (String login,
                                String password,
                                String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20){
         throw new WrongLoginException("Слишком длинный логин");
        }
        if (!incorrectSymbols(login)){
            throw new WrongLoginException("Логин содержит некорретные символы");
        }
        if (Objects.isNull(password) || password.length() >= 20){
            throw new WrongPasswordException("Пароль слишком длинный");
        }
        if (!incorrectSymbols(password)) {
            throw new WrongPasswordException("Пароль содержит некорретные символы");
        }
        if (!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
    private static boolean incorrectSymbols(String s){
        char[] symbols = s.toCharArray();
        for (char symbol : symbols){
            if (!SYMBOLS.contains(String.valueOf(symbol))) {
                    return false;
                }
            }
        return true;
    }
    }

