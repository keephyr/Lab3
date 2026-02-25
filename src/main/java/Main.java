import services.ClubService;

import java.util.Scanner;

public class Main {
    private static final ClubService service = new ClubService();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        do {
            System.out.print("1)Add Member;\n2)Show All;\n3)Search Member;\n4)Sort members;\n6)Delete members;\nВыберите действие: ");
            answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    service.addMember();
                    break;

                case 2:
                    service.ShowAll();
                    break;
                case 3:
                    service.SearchMember();
                    break;
                case 4:
                    service.SortMembers();
                    break;
                case 6:
                    System.out.print("Введите пароль: ");
                    int password = scanner.nextInt();
                    if (password == 1111){
                        service.DeleteMember();
                    } else {
                        System.out.println("Доступ запрещен");
                    }
                    break;
                default:
                    System.out.println("Ошибка ввода, повторите попытку");
                case 0:
                    break;

            }
        } while (answer != 0);

    }
}
