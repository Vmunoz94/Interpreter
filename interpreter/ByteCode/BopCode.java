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
public class BopCode extends ByteCode{
    
    private String op;
    
    @Override
    public void init(ArrayList<String> args) {
        op = args.get(0); 
    }

    @Override
    public void execute(VirtualMachine virtualMachine) {
        int topLevel = virtualMachine.pop();
        int secondLevel = virtualMachine.pop();
        
        switch(op){
            
            case "+":
                virtualMachine.push(secondLevel + topLevel);
                break;
                
            case "-":
                virtualMachine.push(secondLevel - topLevel);
                break;
                
            case "/":
                virtualMachine.push(secondLevel / topLevel);
                break;
                
            case "*":
                virtualMachine.push(secondLevel * topLevel);
                break;
                
            case "==":
                if(secondLevel == topLevel)
                    virtualMachine.push(1);
                else
                    virtualMachine.push(0);
                break;
                
            case "!=":
                if(secondLevel != topLevel)
                    virtualMachine.push(1);
                else
                    virtualMachine.push(0);
                break;
                
            case "<=":  
                if(secondLevel <= topLevel)
                    virtualMachine.push(1);
                else
                    virtualMachine.push(0);
                break;
                
            case ">":
                if(secondLevel > topLevel)
                    virtualMachine.push(1);
                else
                    virtualMachine.push(0);
                break;
                
            case ">=":
                if(secondLevel >= topLevel)
                    virtualMachine.push(1);
                else
                    virtualMachine.push(0);
                break;
                
            case "<":
                if(secondLevel < topLevel)
                    virtualMachine.push(1);
                else
                    virtualMachine.push(0);
                break;
                
            case "|":
                if(secondLevel == 1 ||  topLevel == 1) {
                    virtualMachine.push(1);
                } else {
                    virtualMachine.push(0);
                }
                break;
                
            case "&":
                if(secondLevel == 1 &&  topLevel == 1) {
                    virtualMachine.push(1);
                } else {
                    virtualMachine.push(0);
                }
                break;             
        }
        
        if("ON".equals(virtualMachine.getDumpMode())){
            System.out.println("BOP " + op); 
        }
    } 
    
}
