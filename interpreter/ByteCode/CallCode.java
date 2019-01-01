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
public class CallCode extends ByteCode{
    
    private String label;
    private String args;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
        this.args = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        
        virtualMachine.returnAddrsPush(virtualMachine.getPC());
        virtualMachine.setPC(Integer.parseInt(label));
        
        if("ON".equals(virtualMachine.getDumpMode())){
            System.out.println("CALL " + args );  
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String string) {
        this.label = string;
    } 
    
}
