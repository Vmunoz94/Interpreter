/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


/**
 *
 * @author munoz
 */
public class HaltCode extends ByteCode{

    @Override
    public void init(ArrayList<String> args) {
        
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setIsRunning(false);
        
        if("ON".equals(virtualMachine.getDumpMode())){
            System.out.println("HALT");
        }
    }   
    
}
