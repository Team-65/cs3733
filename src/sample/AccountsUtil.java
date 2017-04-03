package sample;

import java.io.*;
import java.util.HashMap;

public class AccountsUtil {

    public HashMap usernameMap = new HashMap<Integer, String>();
    private String saveFileName = "testFile";

    public void saveFile(HashMap<Integer, String> lockedApps){

        FileOutputStream fileOutputStream;

        try {
            File file = new File(saveFileName);
            fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(lockedApps);
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
            usernameMap = (HashMap<Integer, String>) is.readObject();
            is.close();
            fileInputStream.close();
        }catch(Exception e){
            usernameMap = new HashMap<Integer, String>();
            saveFile(usernameMap);
        }
    }
}
