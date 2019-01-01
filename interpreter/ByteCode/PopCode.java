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
public class PopCode extends ByteCode{
    
    private int n;
    
    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int timesPopped = n;
        
        if(timesPopped > virtualMachine.getRunStackSize())
            timesPopped = virtualMachine.getRunStackSize();
        for(int i = 0; i < timesPopped; i++)
            virtualMachine.pop();
        
        if("ON".equals(virtualMachine.getDumpMode())){
            System.out.println("POP " + n);
        }
    }
    
}
