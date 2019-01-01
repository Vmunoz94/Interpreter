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
public class LitCode extends ByteCode{
  
    private int n;
    private String i;
    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
        
        if(args.size() > 1)
            i = args.get(1);
        else
            i = "";
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        if("".equals(i)) 
            virtualMachine.push(n);
        else 
            virtualMachine.push(0);
        
        if("ON".equals(virtualMachine.getDumpMode())){
            if(i.length() > 0)
                System.out.println("LIT " + n + " " + i );
            else
                System.out.println("LIT " + n);
        }       
    }
    
}
