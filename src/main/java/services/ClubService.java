package services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import objects.Manager;
import objects.Member;
import objects.Coach;
import objects.Player;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ClubService {
    private final List<Member> list = new ArrayList<>();
    private static HashMap<Member, TrainingRecords> TrainRecordMap = new HashMap<>();
    private static HashMap<Member, PayingRecords> PaymentRecordMap = new HashMap<>();
    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void ShowAll(){
        if (list.isEmpty()){
            System.out.println("Список мемберов пуст");
        } else {
            System.out.println("Все мемберы: ");
            for(Member member: list){
                System.out.println(member);
            }
        }
        if (TrainRecordMap.isEmpty()){
            System.out.println("Список тренировок пуст");
        } else {
            System.out.println("Все тренировки: ");
            System.out.println(TrainRecordMap);
        }
        if (PaymentRecordMap.isEmpty()){
            System.out.println("Список платежей пуст");
        } else {
            System.out.println("Все платежи: ");
            System.out.println(PaymentRecordMap);
        }

    }

    public void addMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кого добавить (coach, player, manager): ");
        String member = scanner.nextLine();
        if (member.equals("1")) {
            list.add(new Coach("11", "22", 33, 33, 55, "66"));
            return;
        } else if (member.equals("0")){
            return;
        }
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите название команды: ");
        String team = scanner.nextLine();
        System.out.print("Введите опыт: ");
        int exp = scanner.nextInt();
        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        switch (member.toLowerCase()){
            case "coach":
                System.out.print("Введите тип тренировок команды: ");
                String type = scanner.nextLine();
                System.out.print("Введите количество учеников: ");
                int amountOP = scanner.nextInt();
                scanner.nextLine();
                list.add(new Coach(name, team, exp, age, amountOP, type));
                break;
            case "player":
                System.out.print("Введите позицию игрока: ");
                String position = scanner.nextLine();
                System.out.print("Введите номер игрока: ");
                int number = scanner.nextInt();
                scanner.nextLine();
                list.add(new Player(name, team, exp, age, position, number));
                break;
            case "manager":
                System.out.print("Введите контактный номер: ");
                String contact = scanner.nextLine();
                list.add(new Manager(name, team, exp, age, contact));
                break;
        }
    }

    public void EditMember(){
        if (list.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID: ");
        int ID = scanner.nextInt();
        for(Member member:list){
            if (member.getId() == ID){
                System.out.print("(role,exp)\nВведите что изменить: ");
                String answer = scanner.nextLine();
                switch(answer){
                    case "role":
                        System.out.print("Введите новую роль: ");
                        String newRole = scanner.nextLine();
                        member.setRole(newRole);
                        return;
                    case "exp":
                        System.out.print("Измените опыт: ");
                        int newExp = scanner.nextInt();
                        member.setExp(newExp);
                        return;
                    default:
                        System.out.println("Ошибка");
                        return;
                }
            }
        }
        System.out.println("Такого пользователя нет");
    }

    public void SearchMember(){
        if (list.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("(name,team)\nВведите параметр поиска: ");
        String search = scanner.nextLine();
        switch (search){
            case "name":
                System.out.println("Введите имя: ");
                search = scanner.nextLine();
                for (Member member: list){
                    if (member.getName().equals(search)){
                        System.out.println(member);
                    }
                }
                break;
            case "team":
                System.out.println("Введите команду: ");
                search = scanner.nextLine();
                for (Member member: list){
                    if (member.getTeam().equals(search)){
                        System.out.println(member);
                    }
                }
                break;
        }

    }

    public void DeleteMember(){
        if (list.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ID пользователя которого надо удалить: ");
        int ID = scanner.nextInt();
        for(Member member:list){
            if (member.getId() == ID){
                list.remove(member);
                return;
            }
        }
        System.out.println("Такого пользователя нет");
    }

    public void SortMembers(){
        if (list.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        List<Member> sortedList = list;
        Scanner scanner = new Scanner(System.in);
        System.out.print("(age,role,exp)\nВведите параметр сортировки: ");
        String sortTypes = scanner.nextLine();

        switch (sortTypes.toLowerCase()){
            case "name":
                sortedList.sort(Comparator.comparing(Member::getName));
                break;
            case "role":
                sortedList.sort(Comparator.comparing(Member::getRole));
                break;
            case "exp":
                sortedList.sort(Comparator.comparing(Member::getExp));
                break;
        }
        for (Member member: sortedList){
            System.out.println(member);
        }
    }

    public void FilterMembers(){
        if (list.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите параметр фильтра: ");
        String filterTypes = scanner.nextLine();
        switch (filterTypes.toLowerCase()){
            case "role":
                System.out.print("Введите роль которую желаете увидеть: ");
                String roles = scanner.nextLine();
                for (Member member:list){
                    if (member.getRole().equals(roles)){
                        System.out.println(member);
                    }
                }
                break;
            case "exp":
                System.out.print("Введите какой минимальный опыт желаете видеть: ");
                int exp = scanner.nextInt();
                for (Member member:list){
                    if (member.getExp() >= exp){
                        System.out.println(member);
                    }
                }
                break;
        }

    }

    public void PutIntoFile(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("Members.json");
        try {
            mapper.writeValue(file,list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void GetFromFile(){
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("Members.json");
        try {
            JsonNode rootNode = mapper.readTree(file);
            if (rootNode.isArray()){
                for (JsonNode node : rootNode) {
                    String type = node.get("role").asText();
                    if (type.equals("Member")){
                        list.add(mapper.treeToValue(node, Member.class));
                    } else if (type.equals("Coach")){
                        list.add(mapper.treeToValue(node, Coach.class));
                    }
                    else if (type.equals("Player")){
                        list.add(mapper.treeToValue(node, Player.class));
                    }
                    else if (type.equals("Manager")){
                        list.add(mapper.treeToValue(node, Manager.class));
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addTrainingRecord(Member member){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату тренировки:");
        System.out.print("День: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Месяц: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Год: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите уровень тренировки: ");
        int lvl =  scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите название тренировки");
        String name = scanner.nextLine();
        scanner.nextLine();
        TrainRecordMap.put(member,new TrainingRecords(lvl,name,day,month,year));
        System.out.println(TrainRecordMap);
    }
    public void addPayRecord(Member member){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату платежа:");
        System.out.print("День: ");
        int day = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Месяц: ");
        int month = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Год: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите сумму транзакции: ");
        int sum = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите название платежа");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Введите тип платежа");
        String type = scanner.nextLine();
        PaymentRecordMap.put(member,new PayingRecords(sum,name,type,day,month,year));
    }

    public void ManageMember(){
        ShowAll();
        System.out.println("Введите ID человека у кого хотите изменить данные");
        Scanner scanner = new Scanner(System.in);
        int ID = scanner.nextInt();
        for (Member member: list){
            if (member.getId() == ID){
                System.out.println("Введите что хотите сделать:");
                if (member.isPayable()){
                    System.out.println("1)Добавить оплату");
                }
                if (member.isTrainable()){
                    System.out.println("2)Добавить тренировку");
                }
                int answer =  scanner.nextInt();
                switch (answer){
                    case 1:
                        if (member.isPayable()){
                            addPayRecord(member);
                        }
                        return;
                    case 2:
                        if (member.isTrainable()){
                            addTrainingRecord(member);
                        }
                }
            }
        }
    }


}