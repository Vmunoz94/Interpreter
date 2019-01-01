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
public class ReturnCode extends ByteCode{
       
    private String label;
    private int returnValue;
    private String args;
    
    @Override
    public void init(ArrayList<String> args) {

       if(args.size() > 0){
           label = args.get(0);
           this.args = args.get(0);
       }           
       else
           label = "";
     
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        
        returnValue = virtualMachine.returnAddrsPop();
        virtualMachine.popFrame();
        virtualMachine.setPC(returnValue);
        
        if("ON".equals(virtualMachine.getDumpMode())){
            if("".equals(label))         
                System.out.println("Return ");  
            else
                System.out.println("Return " + args);  
        }
    }
    
}
