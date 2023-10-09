package codeathon;
import java.util.Scanner;
class Rectangle{
    int width;
    int height;
    void display() {
        System.out.println(width + " " + height);
    }
}
class RectangleArea extends Rectangle {
    void read_input() {
        Scanner scanner = new Scanner(System.in);
        width = scanner.nextInt();
        height = scanner.nextInt();
        scanner.close();
    }
    @Override
    void display() {
        super.display();// get the information from parent class
        int area = width * height;
        System.out.println(area);   // prints the area of a rectangle
    }
}
    public class Codeathon05A_vijay {
        public static void main(String[] args) {
            RectangleArea rectangleArea =new RectangleArea();
            rectangleArea.read_input();
            rectangleArea.display();

        }
    }



