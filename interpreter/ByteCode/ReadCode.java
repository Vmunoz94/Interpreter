/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * @author munoz
 */
public class ReadCode extends ByteCode{

    @Override
    public void init(ArrayList<String> args) {
        
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        
        if("ON".equals(virtualMachine.getDumpMode())){
            System.out.println("READ");  
        }
        
        int userInput;
        userInput = getInt("Please enter an integer: ");
        virtualMachine.push(userInput);
     
    }
    
    private int getInt(String prompt) {
        
        System.out.print(prompt);
        while(true){
            try {
                return Integer.parseInt(new Scanner(System.in).next());
            } catch(NumberFormatException ne) {
                System.out.print("That's not a valid integer\n"+prompt);
            }
        }
    } 
    
}
