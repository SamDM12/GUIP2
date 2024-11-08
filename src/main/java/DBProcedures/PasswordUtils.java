/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBProcedures;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author chedr
 */
public class PasswordUtils {
    public static String hashPassword(char[] password) {
        
        String passwordString = new String(password);
        String salt = BCrypt.gensalt(12);  // 12 es el número de "work factor" (puedes ajustarlo)
        return BCrypt.hashpw(passwordString, salt);
    }
    public static boolean checkPassword(String enteredPassword, String storedHash) {
        return BCrypt.checkpw(enteredPassword, storedHash);
    }
}
