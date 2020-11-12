package test.com.solutions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class TestPrint {

    private static final List<Map<String, String>> existingMandtelines  = new ArrayList<>();
    private static final List< Map<String, String> > nonExistingMandtelines  = new ArrayList<>();

    public static void main(String[] a) throws JsonProcessingException {

        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.print(Character.valueOf((char)i).charValue()+" ");

        }

        System.out.println("");
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) System.out.println("");
            System.out.print(i +" ");
        }

        System.out.println(UUID.randomUUID().toString());


        Map<String, String> existingMandteline1 = new HashMap<>();
        existingMandteline1.put("line", "existing some line");

        Map<String, String> existingMandteline2 = new HashMap<>();
        existingMandteline2.put("line", "existing some other line ");

        existingMandtelines.add( existingMandteline1);
        existingMandtelines.add( existingMandteline2);





        Map<String, String> nonExistingMandteline1 = new HashMap<>();
        nonExistingMandteline1.put("line", "non-existing some line");

        Map<String, String> nonExistingMandteline2 = new HashMap<>();
        nonExistingMandteline2.put("line", "non-existing some other line ");

        nonExistingMandtelines.add( nonExistingMandteline1 );
        nonExistingMandtelines.add( nonExistingMandteline2 );

        EmailAction action = new EmailAction();
        action.addTemplateVariable( "mandateText", existingMandtelines );

        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println( objectMapper.writeValueAsString( action ));

        /**
         * {
         *   "templateVariables": {
         *     "mandateText": [
         *       {
         *         "line": "existing some line"
         *       },
         *       {
         *         "line": "existing some other line "
         *       }
         *     ]
         *   }
         * }
         */



    }

    private static class EmailAction {
        private Map<String, Object> templateVariables;

        public Map<String, Object> getTemplateVariables() {
            return templateVariables;
        }

        public void addTemplateVariable(String key, Object object) {
            if (this.templateVariables == null) {
                this.templateVariables = new HashMap();
            }

            this.templateVariables.put(key, object);
        }
    }
}
