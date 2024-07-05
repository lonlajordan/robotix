package repository;

import model.Robot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RobotRepository {
    public static List<Robot> ROBOTS = new ArrayList<>(
        Arrays.asList(
            new Robot()
        )
    );

    void createRobot(){
        String response;
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom : ");
        response = scanner.nextLine();
        robot.setName(response);
        System.out.println("Entrez le numéro de série : ");
        response = scanner.nextLine();
        robot.setSerialNumber(response);
        robot.setType(response);
    }
}
