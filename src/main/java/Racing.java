import java.util.Scanner;
import java.util.Random;

public class Racing {

    public static int[] run(int[] carPositions, int trying) {
        Random random = new Random();

        for(int i=0; i<carPositions.length; i++) {
            carPositions[i] = 1;
            for (int chance = 0; chance < trying; chance++){
                if(random.nextInt(10) >= 4)
                    carPositions[i]++;
            }
        }
        return carPositions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int car;
        int trying;

        System.out.println("자동차 대수는 몇 대 인가요?");
        car = sc.nextInt();
        int[] carPositions = new int[car];

        System.out.println("시도할 회수는 몇 회 인가요?");
        trying = sc.nextInt();

        run(carPositions,trying);

        System.out.println("실행 결과");
        for(int i=0; i<carPositions.length; i++) {
            for(int j=0; j < carPositions[i]; j++){
                System.out.print('-');
            }
            System.out.println();
        }
    }
}