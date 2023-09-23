import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        //предзаполненный список животных для тестов
        Cat barsik = new Cat("Barsik", "2020-02-15");
        animals.add(barsik);
        Dog goodboy = new Dog("Goodboy", "2015-07-31");
        animals.add(goodboy);
        Horse shugar = new Horse("Shugar","2008-01-12");
        animals.add(shugar);

        Scanner scan = new Scanner(System.in);
        System.out.print("Выберете действие: \n 1 Добавить животное \n 2 Показать список животных \n q (выход) \n Введите команду: ");
        String cmd = scan.nextLine();
        while (!cmd.equals("q")){//////////////////////////////////////////////////////пока не введена команда выход
            switch(cmd){
                case "1"://////////////////добавление животного//////////////////////
                    System.out.print("Введите имя: ");
                    String name = scan.nextLine();
                    System.out.print("Дату рождения в формате 'ГГГГ-ММ-ДД': ");
                    String dob = scan.nextLine();
                    System.out.print("Вид: \n 1 Кошка \n 2 Собака \n 3 Лошадь \n 4 Осел \n 5 Верблюд \n q (назад) \n Введите команду: ");
                    String cmd1 = scan.nextLine();
                    switch(cmd1){
                        case "1":
                            animals.add(new Cat(name, dob));
                            System.out.println("Кошка успешно добавлена ");
                            break;
                        case "2":
                            animals.add(new Dog(name, dob));
                            System.out.println("Собака успешно добавлена ");
                            break;
                        case "3":
                            animals.add(new Horse(name, dob));
                            System.out.println("Лошадь успешно добавлена ");
                            break;
                        case "4":
                            animals.add(new Donkey(name, dob));
                            System.out.println("Осел успешно добавлен ");
                            break;
                        case "5":
                            animals.add(new Camel(name, dob));
                            System.out.println("Верблюд успешно добавлен ");
                            break;
                        default:
                            System.out.println("Неизвестная команда");
                            break;            
                    }
                    break;
                case "2": /////////////////Показать список животных/////////////////////
                    if(animals.isEmpty())
                        System.out.println("Список пуст");
                    else{//если в списке есть животные
                        System.out.print("Всего животных: ");
                        System.out.println(Animal.getNumberOfAnimals());
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i< animals.size(); i++ ){
                            sb.setLength(0);
                            sb.append(i).append(". ").
                            append(animals.get(i).getClass().toString().split(" ")[1]).
                            append(" ").
                            append(animals.get(i).getName()).
                            append(" ").
                            append(animals.get(i).getDateOfBirth());
                            System.out.println(sb.toString());
                        }
                        System.out.print("Введите номер животного для доп действий: ");
                        Animal current_animal;
                        int index = scan.nextInt();//вводим индекс нужного животного
                        scan.nextLine();
                        if (index >= 0 && index < animals.size()){//если индекс в пределах списка
                            current_animal = animals.get(index);
                            System.out.print("Выберете действие: \n 1 посмотреть команды животного \n 2 Изучить новые команды \n q (назад)\n Введите команду: ");
                            String cmd2 = scan.nextLine();
                            while(!cmd2.equals("q")){//Зациклить здесь, чтобы можно было изучать несколько команд подряд
                                switch(cmd2){
                                    case "1":
                                        if(!current_animal.getPetCommands().getCommandsList().isEmpty())//проверка, если животное не знает команд. 
                                            System.out.println(current_animal.getPetCommands());//выводит список команд, известных животному
                                        else
                                            System.out.println("Животное не знает ни одной команды");
                                        break;
                                    case "2":
                                        if(current_animal.getPetCommands().getCommandsList().size() != Animal.getAviableComandsList().size()){//сравнение количества изученых команд и всего команд, если не равно, значит есть что изучать
                                            List<Commands> aviableCommands = new ArrayList<>();
                                            for(Commands command : Animal.getAviableComandsList()){//перебираем все возможные команды
                                                if(!current_animal.getPetCommands().getCommandsList().contains(command)){
                                                    aviableCommands.add(command);
                                                }
                                            }
                                            // System.out.println(aviableCommands);//выводит список команд, доступных для изучения (неизвестных животному)
                                            System.out.println("Доступные для изучения команды: ");
                                            for (int i = 0; i< aviableCommands.size(); i++ ){
                                                sb.setLength(0);//очистка 
                                                sb.append(i).append(". ").
                                                append(aviableCommands.get(i));
                                                System.out.println(sb.toString());
                                            }
                                            System.out.print("Введите номер команды для изучения: ");
                                            int j = scan.nextInt();//вводим индекс нужного животного
                                            scan.nextLine();
                                            if (j >= 0 && j < aviableCommands.size()){//если индекс в пределах списка
                                                current_animal.addCommand(aviableCommands.get(j));//изучаем новую команду
                                                System.out.println("Команда успешно изучена");
                                            }
                                        }else{
                                            System.out.println("Все команды изучены");
                                        }
                                        break;
                                    default:
                                        System.out.println("Неизвестная команда");
                                        break;    
                                            
                                } 
                                System.out.println("****************************************************");
                                System.out.print("Выберете действие: \n 1 посмотреть команды животного \n 2 Изучить новые команды \n q (назад)\n Введите команду: ");
                                cmd2 = scan.nextLine();

                            }      
                        }
                    }    
                    break;
                default:
                    System.out.println("Неизвестная команда");
                    break;        
            }
            System.out.println("****************************************************"); 
            System.out.print("Выберете действие: \n 1 Добавить животное \n 2 Показать список животных \n q (выход) \n Введите команду: ");
            cmd = scan.nextLine();
        }
        scan.close();

    
        // for (Animal animal : animals){
        //     System.out.println(animal.getName());
        // }
        // for (Animal animal : animals){
        //     System.out.println(animal.getClass());
        // }
        // for (Animal animal : animals){
        //     for (Commands command: animal.getPetCommands().getCommands()){//перебор комманд в списке комманд
        //         System.out.println(command);
        //     }
        // }



    }

}
