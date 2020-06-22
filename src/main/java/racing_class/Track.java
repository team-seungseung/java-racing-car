package racing_class;

import java.util.Scanner;

public class Track {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] names = sc.nextLine().split(",");
        Car[] cars = new Car[names.length];

        for(int i=0; i< names.length;i++){
            cars[i] = new Car(names[i]);
        }

        System.out.println("시도할 회수는 몇 회 인가요?");
        int trying = sc.nextInt();

        int[] carPositions = new int[names.length];
        //배열 초기화 상태로 생성(모든 자동차들 초기 위치 0)

    }
}
