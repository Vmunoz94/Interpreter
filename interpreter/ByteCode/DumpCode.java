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
public class DumpCode extends ByteCode{
    
    private String dumpMode;
    
    @Override
    public void init(ArrayList<String> args) {
        dumpMode = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        virtualMachine.setDumpMode(dumpMode);
    }  
    
}
