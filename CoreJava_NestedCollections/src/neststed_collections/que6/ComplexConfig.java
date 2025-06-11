package neststed_collections.que6;

import java.io.Flushable;
import java.util.*;

/***
 List<Map<String, List<String>>> — Complex Configurations
 Deeply nested configurations (e.g. multiple configs per module)
 Problem:
 Add modules with their supported environments
 e.g., { "auth": { "env": ["dev", "prod"] } }
 Print all environments across all modules
 */
public class ComplexConfig {
    public static void main(String[] args) {
        List<Map<String, List<String>>>modules=new ArrayList<>();
        Map<String,List<String>>authModule=new HashMap<>();
        authModule.put("auth",List.of("dev","prod"));

        Map<String,List<String>>paymentModule=new HashMap<>();
        paymentModule.put("payment",List.of("test","prod"));

        modules.add(authModule);
        modules.add(paymentModule);

        System.out.println("Supported environment per module");
        for (Map<String,List<String>>module:modules) {
            for (Map.Entry<String, List<String>> entry : module.entrySet()) {
                String moduleName = entry.getKey();
                List<String> envs = entry.getValue();
                System.out.println(" " + moduleName + " " + envs);

            }
        }

            Set<String>allEnvs=new HashSet<>();
            for (Map<String,List<String>>module:modules){
                for (List<String>envs:module.values()){
                    allEnvs.addAll(envs);
                }
            }
        System.out.println("\n all unique enviornment "+allEnvs);
        }





    }

