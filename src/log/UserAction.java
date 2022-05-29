package log;

import employees.HRPerson;
import employees.Person;

import java.time.LocalDate;

public class UserAction {
    public static int CREATE_PERSON = 0;
    public static int CHANGE_VALUE = 1;
    public static int SET_ASSIGNMENT = 2;
    public static int DELETE_PERSON = 3;
    private String[] actionDescription = {"CREATE_PERSON", "CHANGE_VALUE", "SET_ASSIGNMENT", "DELETE_PERSON"};
    private String entry;

    /**
     * Constructor
     * @param hrPerson
     * @param person
     * @param action
     */
    public UserAction(HRPerson hrPerson, Person person, int action){
        entry = LocalDate.now()+": ";
        entry += hrPerson.getFirstName()+" ";
        entry += hrPerson.getLastName()+";";

        if (action >= 0 && action < actionDescription.length){
            entry += actionDescription[action]+": ";
            entry += person.getFirstName()+" ";
            entry += person.getLastName()+";";
        }else{
            entry+="unknown action";
        }
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }
}
