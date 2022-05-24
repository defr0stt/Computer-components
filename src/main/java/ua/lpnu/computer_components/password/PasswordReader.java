package ua.lpnu.computer_components.password;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class PasswordReader {

    public static List<String> getPasswords() {
        return passwords;
    }

    private static List<String> passwords = new ArrayList<>();

    public static List<String> writeInFile(String password){
        passwords.clear();
        File file1 = new File("D:\\Dima\\Programming\\java\\other\\components\\RandomPasswords.txt");
        try {
            if(!file1.exists()) {
                file1.createNewFile();
                PrintWriter obj1 = new PrintWriter(file1);
                obj1.write(password);              // writing an information
                obj1.close();
            } else {
                if(!checkIfExists(password)) {
                    password += '\n';
                    Files.write(Paths.get("D:\\Dima\\Programming\\java\\other\\components\\RandomPasswords.txt"), password.getBytes(), StandardOpenOption.APPEND);    // adding in existing file
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return passwords;
    }

    public static boolean checkIfExists(String password){
        String line;
        passwords.clear();
        int idx = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Dima\\Programming\\java\\other\\components\\RandomPasswords.txt"));
            while((line = br.readLine())!=null)
            {
                if(line.contains("\n")){
                    for(int i=0;i<line.length();i++){
                        if (line.charAt(i) == '\n'){
                            idx = i+1;
                        }
                    }
                    line = line.substring(0,idx);
                }
                if(line.equals(password)){
                    return true;
                }
                passwords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
