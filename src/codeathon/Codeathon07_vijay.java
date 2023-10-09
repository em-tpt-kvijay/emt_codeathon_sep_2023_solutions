package codeathon;

import java.io.File;
import java.util.*;

public class Codeathon07_vijay {
    public static Map<String, List<String>> traverseAndCollectFiles(String directoryPath) {
        Map<String, List<String>> filesMap = new HashMap<>();
        traverseDirectory(directoryPath, filesMap);
        return filesMap;
    }
    private static void traverseDirectory(String directoryPath, Map<String, List<String>> filesMap) {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory Not Found on the Filesystem");
            return;
        }
        File[] files = directory.listFiles();
        List<String> txtFiles = new ArrayList<>();
        List<String> exeFiles = new ArrayList<>();
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.endsWith(".txt")) {
                    txtFiles.add(fileName);
                } else if (fileName.endsWith(".exe")) {
                    exeFiles.add(fileName);
                }
            }
        }
        String fullPath = directory.getAbsolutePath();
        if (!txtFiles.isEmpty() || !exeFiles.isEmpty()) {
            List<String> fileList = new ArrayList<>();
            fileList.addAll(txtFiles);
            fileList.addAll(exeFiles);
            filesMap.put(fullPath, fileList);
        }
        for (File file : files) {
            if (file.isDirectory()) {
                traverseDirectory(file.getAbsolutePath(), filesMap);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        Map<String, List<String>> filesMap = traverseAndCollectFiles(directoryPath);
        for (Map.Entry<String, List<String>> entry : filesMap.entrySet()) {
            System.out.print(entry.getKey());
            List<String> filesList = entry.getValue();
            if (!filesList.isEmpty()) {
                System.out.print("\t");
                for (String file : filesList) {
                    System.out.print(file + ", ");
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
        scanner.close();
    }
}

