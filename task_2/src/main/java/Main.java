import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести размер списка");
        int listSize = inputInt("Введите размер списка: ");

        logger.log("Просим пользователя ввести верхнюю границу для значений");
        int upperLimit = inputInt("Введите верхнюю границу для значений: ");

        logger.log("Создаём и наполняем список");
        ArrayList<Integer> list = randomList(listSize, upperLimit);

        logger.log("Выводим созданный список для пользователя");
        System.out.println("Вот случайный список: " + list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int treshold = inputInt("Введите порог для фильтра: ");

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(treshold);
        ArrayList<Integer> filterlist = (ArrayList<Integer>) filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filterlist);

        logger.log("Завершаем программу");
    }


    public static ArrayList<Integer> randomList(int listSize, int upperLimit) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            list.add(random.nextInt(upperLimit));
        }
        return list;
    }


    public static int inputInt(String msg) {
        while (true) {
            System.out.print(msg);
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                Logger logger = Logger.getInstance();
                if (number >= 0) {
                    logger.log("Пользователь указал корректное число");
                    return number;
                } else {
                    logger.log("Пользователь указал число меньше нуля, просим повторить ввод");
                    System.out.println("Введено отрицательное число. Повторите ввод!");
                }
            } else {
                Logger logger = Logger.getInstance();
                logger.log("Пользователь указал НЕ корректное число, просим повторить ввод");
                System.out.println("Введено не целое число. Повторите ввод!");
            }
        }
    }
}