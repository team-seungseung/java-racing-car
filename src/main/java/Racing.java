import java.util.Scanner;
import java.util.Random;

public class Racing {

    public static void runCar(int[] carPositions, int trying) {
        for (int carnum = 0; carnum < carPositions.length; carnum++) {
            tryingTurn(carPositions, trying, carnum);
        }
    }

    public static void tryingTurn(int[] carPositions, int trying, int carnum){
        for (int chance = 0; chance < trying; chance++) {
            comparingValue(carPositions, carnum);
        }
    }

    public static void comparingValue(int[] carPositions, int carnum){
        Random random = new Random();
        if (random.nextInt(10) >= 4)
            carPositions[carnum]++;
    }

    public static void printCar(int[] carPositions) {
        System.out.println("실행 결과");
        for (int car = 0; car < carPositions.length; car++) {
            printDash(carPositions, car);
            System.out.println();
        }
    }

    public static void printDash(int[] carPositions, int car){
        for (int position = 0; position < carPositions[car]; position++) {
            System.out.print('-');
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int car;
        int trying;

        System.out.println("자동차 대수는 몇 대 인가요?");
        car = sc.nextInt();
        int[] carPositions = new int[car];
        //배열 초기화 상태로 생성(모든 자동차들 초기 위치 0)

        System.out.println("시도할 회수는 몇 회 인가요?");
        trying = sc.nextInt();

        runCar(carPositions, trying);
        printCar(carPositions);

    }
}