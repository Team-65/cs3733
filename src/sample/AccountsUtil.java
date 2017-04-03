package sample;

import java.io.*;
import java.util.HashMap;

public class AccountsUtil {

    private static HashMap usernameMap = new HashMap<String, Integer>();
    private String saveFileName = "usernameHash";

    public static String getUser_id() {
        return user_id;
    }

    public static void setUser_id(String user_id) {
        AccountsUtil.user_id = user_id;
    }

    private static String user_id;

    AccountsUtil(){
        loadFile();
    }

    public void saveFile(){

        FileOutputStream fileOutputStream;

        try {
            File file = new File(saveFileName);
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(usernameMap);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void loadFile(){

        FileInputStream fileInputStream;

        try{
            File file = new File(saveFileName);
            fileInputStream = new FileInputStream(file);
            ObjectInputStream is = new ObjectInputStream(fileInputStream);
            usernameMap = (HashMap<String, Integer>) is.readObject();
            is.close();
            fileInputStream.close();
        }catch(Exception e){
            usernameMap = new HashMap<String, Integer>();
            saveFile();
        }
    }

    public boolean contains(String username){
        return usernameMap.containsKey(username);
    }

    public void put(String username, Integer id){
        usernameMap.put(username, id);
        saveFile();
    }
}
