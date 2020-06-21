import jdk.internal.dynalink.linker.LinkerServices;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;

public class Racing {

    // 소유한 모든 차 차례대로 돌리기 - Racing 01
    public static void runCar(int[] carPositions, int trying) {
        for (int carnum = 0; carnum < carPositions.length; carnum++) {
            tryingTurn(carPositions, trying, carnum);
        }
    }

    // 각 차마다 시도횟수 만큼 돌리기 - Racing 02
    public static void tryingTurn(int[] carPositions, int trying, int carnum){
        for (int chance = 0; chance < trying; chance++) {
            comparingValue(carPositions, carnum);
        }
    }

    // random 추출하여 차 진도빼기 - Racing 03
    public static void comparingValue(int[] carPositions, int carnum){
        Random random = new Random();
        if (random.nextInt(10) >= 4)
            carPositions[carnum]++;
    }

    // 레이싱 현황 출력하는 함수 01
    public static void printCar(int[] carPositions, String[] names) {
        System.out.println("실행 결과");
        for (int i = 0; i < carPositions.length; i++) {
            System.out.print(names[i]);
            System.out.print(": ");
            printDash(carPositions, i);
            System.out.println();
        }
    }

    // 레이싱 현황 출력하는 함수 02 (Dash)
    public static void printDash(int[] carPositions, int car){
        for (int position = 0; position < carPositions[car]; position++) {
            System.out.print('-');
        }
    }

    // 우승자 출력하는 함수
    public static void whoIsWinner01(int[] carPositions, String[] names){
        LinkedList maxList = new LinkedList();
        whoIsWinner02(carPositions, names, maxList);
        int cnt = maxList.size();
        for (int i = 0; i < maxList.size();i++){
            int index = (int) maxList.get(i);
            System.out.print(names[index]);
            if(cnt != 1)
                System.out.print(", ");
            cnt--;
        }
        System.out.println("가 최종 우승했습니다.");
    }

    // 우승자 정하여 우승자 index(LinkedList) 솎아내는 함수
    public static void whoIsWinner02(int[] carPositions, String[] names, LinkedList maxList){
        int max = carPositions[0];
        int maxValue = 0;
        for (int i = 0; i < carPositions.length; i++) {
            if (max < carPositions[i])
                maxValue = carPositions[i];
        }
        for (int j = 0; j < carPositions.length; j++) {
            if (carPositions[j] == maxValue)
                maxList.add(j);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputName;
        int trying;
        int car;

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        inputName = sc.nextLine();
        String[] names = inputName.split(",");

        car = names.length;
        int[] carPositions = new int[car];
        //배열 초기화 상태로 생성(모든 자동차들 초기 위치 0)

        System.out.println("시도할 회수는 몇 회 인가요?");
        trying = sc.nextInt();

        runCar(carPositions, trying);
        printCar(carPositions, names);
        whoIsWinner01(carPositions, names);

    }
}