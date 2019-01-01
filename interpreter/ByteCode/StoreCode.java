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
public class StoreCode extends ByteCode{

    private int n;
    private String id;
    
    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {

        virtualMachine.store(n);

        if("ON".equals(virtualMachine.getDumpMode())){
            System.out.println("STORE " + n + " " + id);
        }
    }
    
}
