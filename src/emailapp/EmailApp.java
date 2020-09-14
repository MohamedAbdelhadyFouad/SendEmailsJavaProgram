/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapp;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Mohamed Abdelhady
 */
public class EmailApp {

    /**
     * @param args the command line arguments
    
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Please write the reciver Email: ");
        String x= sc.nextLine();
        try {
            EmailSend.sendEmail(x);
        } catch (MessagingException ex) {
            Logger.getLogger(EmailApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
