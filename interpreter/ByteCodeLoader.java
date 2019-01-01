
package interpreter;

import interpreter.ByteCode.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     * @return 
     */
    public Program loadCodes()   {
        
        this.program = new Program();
        ArrayList<String> args = new ArrayList<>();
       
        try {
            //read line of code from "  ".x.cod
            String readLine = byteSource.readLine();
                   
            while(readLine != null){

                //tokenize the string
                StringTokenizer token = new StringTokenizer(readLine);
               
                //code contains the ByteCode class
                String code = token.nextToken();
               
                //codeClass contains the key to the byteCode in CodeTable
                String codeClass = CodeTable.getClassName(code);
                
                try{
                    //try to create an instance of the byteCode class
                    ByteCode bytecode = (ByteCode) (Class.forName("interpreter.ByteCode."+codeClass).newInstance());
                    
                    while(token.hasMoreTokens()){
                        //ByteCode.init only takes ArrayList<String> arguments
                        //pass remaining tokens into ArrayList
                        args.add(token.nextToken());
                    }

                    //pass ArrayList into ByteCode.init
                    bytecode.init(args);
                    program.add(bytecode);
                    //System.out.println(readLine);
                    
                } 
                catch(ClassNotFoundException | IllegalAccessException | InstantiationException e){
                    System.out.println(e);
                }
                
                //Get next line
                readLine = byteSource.readLine();
                args.clear();
            }

        } catch (IOException ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        program.resolveAddrs(program);
        return program;
    }
}
