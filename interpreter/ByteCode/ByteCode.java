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
public abstract class ByteCode{
    
    //abstract method init
    public abstract void init(ArrayList<String> argument);
    //abstract method execute
    public abstract void execute(VirtualMachine virtualMachine);
    
}
