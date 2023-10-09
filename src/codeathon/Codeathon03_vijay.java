package codeathon;



import java.util.Scanner;

    public class Codeathon03_vijay {
        public static void main(String[] args) {

            Scanner sc = new Scanner (System.in);
            int clockwise=0;
            int anticlockwise=0;
            int lenght=0;
            int total=0;
            System.out.println("Enter no of trees");
            int n = sc.nextInt();

            int height[] = new int[n];
            int max=0;
            System.out.println("Enter their respective heights of the tree");
            for(int i=0;i<n;i++) {
                height[i] = sc.nextInt();
            }
            max=height[0];

            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    clockwise=Math.abs(((n-j)+i));//find the distance between trees Clockwise
                    anticlockwise=Math.abs((j-i));//find the distance between trees Anticlockwise
                    if(clockwise<=anticlockwise) {
                        lenght=clockwise;
                    }
                    else{
                        lenght=anticlockwise;
                    }
                    total=lenght+height[i]+height[j];
                    if(total>max)
                        max=total;
                }
            }

            System.out.println("maximum time travel between trees :"+max);
        }
    }

