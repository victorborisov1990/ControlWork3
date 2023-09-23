import java.sql.Date;
import java.util.List;

public abstract class Animal { //
    private static int counter;
    private String name;
    private Date dateOfBirth;
    private PetCommands petCommands;


    public Animal (String name, String date){//date format: "yyyy-mm-dd"
        counter++;
        this.name = name;
        dateOfBirth = Date.valueOf(date);
        petCommands = new PetCommands();
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(String date){//date format: "yyyy-mm-dd"
        dateOfBirth = Date.valueOf(date);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

        public PetCommands getPetCommands(){
        return petCommands;
    }

    public void addCommand(Commands command){
        petCommands.addCommand(command);
    }

    public static int getNumberOfAnimals(){
        return counter;
    }

    public static String showAviableComands(){
        return PetCommands.showAviableCommands();
    }

    public static List<Commands> getAviableComandsList(){
        return PetCommands.getAviableCommandsList();
    }

}
