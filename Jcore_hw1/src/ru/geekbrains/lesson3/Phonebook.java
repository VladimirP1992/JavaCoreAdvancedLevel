package ru.geekbrains.lesson3;

import java.util.TreeMap;
import java.util.TreeSet;

public class Phonebook {
    private TreeMap<String , TreeSet<String>> phonebook; //second name, phone number set

    public Phonebook() {
        phonebook = new TreeMap<>();
    }

    public void add(String secondName, String phoneNumber){
        if(!phonebook.containsKey(secondName)){
            TreeSet<String> phonesSet = new TreeSet<>();
            phonesSet.add(phoneNumber);
            phonebook.put(secondName, phonesSet);
        }
        else {
            //Дубликаты номеров не сохраняются
            if(!phonebook.get(secondName).contains(phoneNumber))
                phonebook.get(secondName).add(phoneNumber);
        }
    }

    public void get(String seconName){
        TreeSet<String> phoneList = phonebook.get(seconName);
        if(phoneList == null)
            System.out.println("Фамилии " + seconName + " нет в телефонном справочнике!");
        else{
            System.out.println("Найденные телефонные номера гражданина " + seconName + ":");
            System.out.println(phoneList);
        }
    }
}
