package interpreter;

import java.util.Stack;
import interpreter.ByteCode.*;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;      //--push/pop when call/return functions
    private Program program;        //--bytecode program
    private int pc;                 //--the program counter
    private boolean isRunning;      //--true while VM is running
    private String dumpMode = "ON"; //default is OFF

    protected VirtualMachine(Program program) {
        this.program = program;
    }
    
    public void setIsRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
    
    public boolean getIsRunning(){
        return isRunning;
    }
    
    public void setDumpMode(String dumpMode){
        this.dumpMode = dumpMode;
    }
    
    public String getDumpMode(){
        return dumpMode;
    }
    
    public void setPC(int pc){
        this.pc = pc;
    }
    
    public int getPC(){
        return pc;
    }
    
    public int returnAddrsPush(int pc){
        return (int) returnAddrs.push(pc);
    }
    
    public int returnAddrsPop(){
        return (int) returnAddrs.pop();
    }
    
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;  
        while(isRunning){  
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if("ON".equals(dumpMode)){  
                runStack.dump();
            }         
            pc++;
        }
    }
    
    public int peek()
    {
        return runStack.peek();
    }

    public int pop()
    {
        return runStack.pop();
    }

    public int push(int i)
    {
        return runStack.push(i);
    }

    public void newFrameAt(int offset)
    {
        runStack.newFrameAt(offset);
    }

    public void popFrame()
    {
        runStack.popFrame();
    }
    
    public int store(int offset)
    {
        return runStack.store(offset);
    }

    public int load(int offset)
    {
        return runStack.load(offset);
    }
      
    public int getRunStackSize()
    {
        return runStack.getRunStackSize();
    }
}
