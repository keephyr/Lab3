package services;
import objects.Manager;
import objects.Member;
import objects.Coach;
import objects.Player;

import java.util.*;

public class ClubService {
    private final List<Member> list = new ArrayList<>();

    public void ShowAll(){
        if (list.isEmpty()){
            System.out.println("Список пуст");
            return;
        }
        for(Member member: list){
            System.out.println(member);
        }
    }

    public void addMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите кого добавить (member, coach, player, manager): ");
        String member = scanner.nextLine();
        if (member.equals("1")) {
            list.add(new Member("1", "2", 3, 45));
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
        switch (member.toLowerCase()){
            case "member":
                list.add(new Member(name, team, exp, age));
                break;
            case "coach":
                System.out.print("Введите тип тренировок команды: ");
                String type = scanner.nextLine();
                System.out.print("Введите количество учеников: ");
                int amountOP = scanner.nextInt();
                list.add(new Coach(name, team, exp, age, amountOP, type));
                break;
            case "player":
                System.out.print("Введите позицию игрока: ");
                String position = scanner.nextLine();
                System.out.print("Введите номер игрока: ");
                int number = scanner.nextInt();
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
}