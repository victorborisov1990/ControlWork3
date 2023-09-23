import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PetCommands {
    
    private List <Commands> commands;
    // commands.get()
    public PetCommands(){
        commands = new ArrayList<>();
        //предзаполненных список команд для тестов
        commands.add(Commands.WALK);
        commands.add(Commands.DRINK);
        commands.add(Commands.EAT);
        commands.add(Commands.SLEEP);
    }

    public List<Commands> getCommandsList() {
        return commands;
    }

    public static String showAviableCommands() {
        return Arrays.toString(Commands.values());
    }

    public static List<Commands> getAviableCommandsList() {
        return Arrays.asList(Commands.values());
    }

    public void addCommand(Commands command){
        commands.add(command);
    }

    @Override
    public String toString(){
        return commands.toString();
    }
}
