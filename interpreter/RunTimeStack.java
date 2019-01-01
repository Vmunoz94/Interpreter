package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    
    public void dump(){
           
        if(framePointer.size() == 1){
            System.out.print("[");
            for(int i = 0; i <= runTimeStack.size()-1; i++){
                if(i == runTimeStack.size() - 1)
                    System.out.print(runTimeStack.get(i));
                else
                    System.out.print(runTimeStack.get(i) + ",");       
            }
            System.out.print("]");
        }
        else if (framePointer.size() == 2){
            System.out.print("[");
            System.out.print("]");
        
            System.out.print("[");
            for(int i = 0; i <= runTimeStack.size()-1; i++){
                if(i == runTimeStack.size() - 1)
                    System.out.print(runTimeStack.get(i));
                else
                    System.out.print(runTimeStack.get(i) + ",");
            }
            System.out.print("]");        
            
        }
        else if (framePointer.size() == 3){
            System.out.print("[");
            System.out.print("]");
        
            System.out.print("[");
            for(int i = 0; i <= 1; i++){
                if(i == 1)
                    System.out.print(runTimeStack.get(i));
                else
                    System.out.print(runTimeStack.get(i) + ",");
            }
            System.out.print("]");    
            System.out.print("[");
            for(int i = 2; i <= runTimeStack.size()-1; i++){
                if(i == runTimeStack.size() - 1)
                    System.out.print(runTimeStack.get(i));
                else
                    System.out.print(runTimeStack.get(i) + ",");
            }
            System.out.print("]");  
        }
        else if (framePointer.size() == 4){
            System.out.print("[");
            System.out.print("]");
        
            System.out.print("[");
            for(int i = 0; i <= 1; i++){
                if(i == 1)
                    System.out.print(runTimeStack.get(i));
                else
                    System.out.print(runTimeStack.get(i) + ",");
            }
            System.out.print("]");    
            System.out.print("[");
            for(int i = 2; i <= 3; i++){
                if(i == 3)
                    System.out.print(runTimeStack.get(i));
                else
                    System.out.print(runTimeStack.get(i) + ",");
            }
            System.out.print("]");  
            System.out.print("[");
            for(int i = 4; i <= runTimeStack.size()-1; i++){
                if(i == runTimeStack.size() - 1)
                    System.out.print(runTimeStack.get(i));
                else
                    System.out.print(runTimeStack.get(i) + ",");
            }
            System.out.print("]");
        }
        System.out.println();
        for(int i = 0; i <= framePointer.size()-1; i++){
            System.out.print("[");
            for(int j = framePointer.get(i); j <= runTimeStack.size()-1; j++){
                if(j == runTimeStack.size() - 1)
                    System.out.print(runTimeStack.get(j));
                else
                    System.out.print(runTimeStack.get(j) + ",");
            }
            System.out.print("]");
        }
        System.out.println();
    }
    
    //return the top of the runTimeStack
    public int peek(){
        
        return (int)runTimeStack.get(runTimeStack.size() - 1);
    }
    
    //pop the item from the runTimeStack
    //return the item
    public int pop(){
        
        return (int)runTimeStack.remove(runTimeStack.size() - 1);
    }
    
    //push item onto the runTimeStack
    //return the item
    public int push(int i){
        
        runTimeStack.add(i);
        return i;
    }
    
    //start a new frame
    //offset - indicates the number of slots down from the top of the runTimeStack
    //for starting a new frame
    public void newFrameAt(int offset){
        
        framePointer.push(runTimeStack.size()-offset);
    }
    
    //the functions return value is on top of the frame 
    //pop the top frame only
    //push the funtions return value on top of the old frame
    public void popFrame(){
      
        int returnValue = (int) runTimeStack.get(runTimeStack.size()-1);

        while(runTimeStack.size() != framePointer.peek())
            runTimeStack.remove(runTimeStack.size()-1);
        
        if(framePointer.size() > 1)
            framePointer.pop();
        
        runTimeStack.add(returnValue);
    }
    
    //used to store into variables
    public int store(int offset){
        
        int topValue = framePointer.peek();
        runTimeStack.set(framePointer.peek() + offset, topValue);  
        return topValue;       
    }
    
    //used to load variables onto the stack
    public int load (int offset){
        
        int variable = (int) runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(variable);
        return variable;
    }
    
    //used to load literals onto the stack  - e.g. for lit 5 we'll call push with 5
    public Integer push (Integer i){
        
        runTimeStack.add(i);
        return i;
    }
    
    public int getRunStackSize(){
        
        return runTimeStack.size();
    } 
}
