package codeathon;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Codeathon01_vijay{
    public static List<String> findModifyUserName(String[] customers) {
        List<String> result = new ArrayList<>();
        for (String str : customers) {
            String lowerCaseString = str.toLowerCase();
            int stringLen =lowerCaseString.length();
            boolean flag=false;
            for(int i=0;i < stringLen;i++){
                int a=lowerCaseString.charAt(i);
                for(int j=i+1;j< stringLen;j++){
                    int b=lowerCaseString.charAt(j);
                    if(a>b){
                        flag=true;
                    }
                }
            }
            if(flag==true){
                result.add("YES");
            }
            else {
                result.add("NO");
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of userNames to add: ");
        int numUserNames = scanner.nextInt();
        scanner.nextLine();
        String[] user = new String[numUserNames];
        System.out.println("Enter the userName (one on each line):");
        for (int i = 0; i < numUserNames; i++) {
            user[i] = scanner.nextLine();
        }
        System.out.println("OUTPUT:");
        List<String> modifyUserName = findModifyUserName(user);
             for (String userName : modifyUserName) {
                System.out.println(userName);
            }
        }
    }

