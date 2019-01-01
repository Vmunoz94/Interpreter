package interpreter;

import java.util.ArrayList;
import interpreter.ByteCode.*;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    
    public void add(ByteCode byteCode){
        program.add(byteCode);
    }
    
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs(Program program) {
    
        for(int i = 0; i < this.program.size(); i++){
            
            if(this.program.get(i) instanceof GotoCode ||
               this.program.get(i) instanceof FalseBranchCode ||
               this.program.get(i) instanceof CallCode){
                
                String label = null;
                
                if(this.program.get(i) instanceof GotoCode){
                    label = ((GotoCode)(this.program.get(i))).getLabel();
                    //System.out.println(((GotoCode) this.program.get(i)).getLabel());
                }
                else if (this.program.get(i) instanceof FalseBranchCode){
                    label = ((FalseBranchCode)(this.program.get(i))).getLabel();
                    //System.out.println(((FalseBranchCode) this.program.get(i)).getLabel());
                }
                else if (this.program.get(i) instanceof CallCode){
                    label = ((CallCode)(this.program.get(i))).getLabel();
                    //System.out.println(((CallCode) this.program.get(i)).getLabel());
                }
                
                for(int j = 1; j < this.program.size(); j++){
                    
                    if(this.program.get(j) instanceof LabelCode){
                        
                        String labelCodeLabel = ((LabelCode)(this.program.get(j))).getLabel();
                        
                        if(label.equals(labelCodeLabel)){
                            
                            if(this.program.get(i) instanceof GotoCode){
                                //System.out.println("GotoCode");
                                ((GotoCode)(this.program.get(i))).setLabel((String.valueOf(j-1)));
                            }
                            else if (this.program.get(i) instanceof FalseBranchCode){
                                //System.out.println("FalseBranchCode");
                                ((FalseBranchCode)(this.program.get(i))).setLabel((String.valueOf(j-1)));
                            }
                            else if (this.program.get(i) instanceof CallCode){
                                //System.out.println("CallCode");
                                ((CallCode)(this.program.get(i))).setLabel((String.valueOf(j-1)));    
                            }
                        }
                    }
                    
                }            
//                if(this.program.get(i) instanceof GotoCode)
//                    System.out.println(((GotoCode)(this.program.get(i))).getLabel());
//                else if (this.program.get(i) instanceof FalseBranchCode)
//                    System.out.println(((FalseBranchCode)(this.program.get(i))).getLabel());
//                else if (this.program.get(i) instanceof CallCode)
//                    System.out.println(((CallCode)(this.program.get(i))).getLabel());               
            }
        }               
    }  
}
