import java.io.*;
import java.util.*;

public class FileManagementSystem {
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nFile Management System Menu:");
            System.out.println("1. Read/Write Text File");
            System.out.println("2. Read/Write Binary File");
            System.out.println("3. Use Random Access on File");
            System.out.println("4. List and Manage Directory");
            System.out.println("5. Manage Names in Collection");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> handleTextFile();
                case 2 -> handleBinaryFile();
                case 3 -> randomAccessFile();
                case 4 -> manageDirectory();
                case 5 -> manageNamesCollection();
                case 6 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }

    // 1. Read/Write Text File
    public static void handleTextFile() {
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter 'r' to read or 'w' to write: ");
        char operation = scanner.next().charAt(0);
        
        if (operation == 'r') {
            try (FileReader reader = new FileReader(filePath)) {
                int ch;
                while ((ch = reader.read()) != -1) System.out.print((char) ch);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        } else if (operation == 'w') {
            System.out.print("Enter text to write to file: ");
            scanner.nextLine(); // consume newline
            String content = scanner.nextLine();
            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write(content);
                System.out.println("Content written to file.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }
    }

    // 2. Read/Write Binary File
    public static void handleBinaryFile() {
        System.out.print("Enter binary file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter 'r' to read or 'w' to write: ");
        char operation = scanner.next().charAt(0);
        
        if (operation == 'r') {
            try (FileInputStream in = new FileInputStream(filePath)) {
                int byteData;
                while ((byteData = in.read()) != -1) System.out.print((char) byteData);
            } catch (IOException e) {
                System.err.println("Error reading binary file: " + e.getMessage());
            }
        } else if (operation == 'w') {
            System.out.print("Enter data to write to binary file: ");
            scanner.nextLine(); // consume newline
            String data = scanner.nextLine();
            try (FileOutputStream out = new FileOutputStream(filePath, true)) {
                out.write(data.getBytes());
                System.out.println("Data written to binary file.");
            } catch (IOException e) {
                System.err.println("Error writing to binary file: " + e.getMessage());
            }
        }
    }

    // 3. Random Access File
    public static void randomAccessFile() {
        System.out.print("Enter file path for random access: ");
        String filePath = scanner.nextLine();

        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            System.out.print("Enter position to seek: ");
            long position = scanner.nextLong();
            raf.seek(position);

            System.out.print("Enter 'r' to read or 'w' to write: ");
            char operation = scanner.next().charAt(0);

            if (operation == 'r') {
                System.out.println("Read data: " + (char) raf.read());
            } else if (operation == 'w') {
                System.out.print("Enter character to write: ");
                char ch = scanner.next().charAt(0);
                raf.write(ch);
                System.out.println("Data written at position " + position);
            }
        } catch (IOException e) {
            System.err.println("Random access error: " + e.getMessage());
        }
    }

    // 4. Directory Management
    public static void manageDirectory() {
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();
        
        File dir = new File(dirPath);
        if (!dir.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        System.out.println("Files in " + dirPath + ":");
        for (String file : dir.list()) System.out.println(file);

        System.out.print("Enter 'c' to create or 'd' to delete a file: ");
        char operation = scanner.next().charAt(0);
        
        System.out.print("Enter file name: ");
        scanner.nextLine(); // consume newline
        String fileName = scanner.nextLine();
        File file = new File(dirPath, fileName);

        if (operation == 'c') {
            try {
                if (file.createNewFile()) System.out.println("File created: " + fileName);
                else System.out.println("File already exists.");
            } catch (IOException e) {
                System.err.println("File creation error: " + e.getMessage());
            }
        } else if (operation == 'd') {
            if (file.delete()) System.out.println("File deleted: " + fileName);
            else System.out.println("File not found or cannot be deleted.");
        }
    }

    // 5. Manage Names in Collection
    public static void manageNamesCollection() {
        String filePath = "names.txt";
        List<String> names = new ArrayList<>();
        
        // Load names from file into collection
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) names.add(line);
        } catch (IOException e) {
            System.err.println("Error loading names: " + e.getMessage());
        }

        while (true) {
            System.out.println("\nNames: " + names);
            System.out.println("1. Add Name\n2. Remove Name\n3. Update Name\n4. Save and Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter name to add: ");
                names.add(scanner.nextLine());
            } else if (choice == 2) {
                System.out.print("Enter name to remove: ");
                names.remove(scanner.nextLine());
            } else if (choice == 3) {
                System.out.print("Enter name to update: ");
                String oldName = scanner.nextLine();
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                if (names.contains(oldName)) {
                    names.set(names.indexOf(oldName), newName);
                } else {
                    System.out.println("Name not found.");
                }
            } else if (choice == 4) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                    for (String name : names) bw.write(name + "\n");
                } catch (IOException e) {
                    System.err.println("Error saving names: " + e.getMessage());
                }
                System.out.println("Changes saved. Exiting...");
                break;
            }
        }
    }
}
