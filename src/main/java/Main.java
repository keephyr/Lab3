import objects.Member;
import services.ClubService;


import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final ClubService service = new ClubService();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer;
        do {
            System.out.print("1)Добавить мембера;\n2)Показать всех;\n3)Поиск мембера;\n4)Сортировка мемберов;\n6)Удалить мембера;\n7)Сохранить/получить данные;\n");
            System.out.print("Выберите действие: ");
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
                case 7:
                    if (service.isEmpty()){
                        service.GetFromFile();
                        System.out.println("Данные получены из файла");
                    } else {
                        service.PutIntoFile();
                        System.out.println("Данные выгружены в файл");
                    }
                    break;
                case 9:
                    service.ManageMember();
                default:
                    System.out.println("Ошибка ввода, повторите попытку");
                case 0:
                    break;

            }
        } while (answer != 0);

    }
}
