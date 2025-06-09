package main.java.com.praktikum.data;

import main.java.com.praktikum.users.*;
import main.java.com.praktikum.data.Item;

import java.util.ArrayList;

public class DataStore {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItem = new ArrayList<>();

    public static void intiData(){
        userList.add(new Admin("Admin441", "Password441", "Bagas Dewantara", "202410370110441"));
        userList.add(new Mahasiswa("Bagas Dewantara", "202410370110441"));
    }

    public static User login(String NameOrUsername, String PasswordOrNim){
        for (User user : userList){
            if (user instanceof Admin admin){
                if (admin.login(NameOrUsername, PasswordOrNim)){
                    return admin;
                }
            } else if (user instanceof Mahasiswa mahasiswa) {
                if (mahasiswa.login(NameOrUsername, PasswordOrNim)){
                    return mahasiswa;
                }
            }
        }
        return null;
    }
}
