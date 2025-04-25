import java.util.ArrayList;
import java.util.Scanner;

class Resume {
    private final String name;
    private String email;
    private String phone;
    private ArrayList<String> skills;

    public Resume(String name, String email, String phone, ArrayList<String> skills) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
    }

    public Resume(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayResume() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("--------------------------");
    }
}

public class ResumeManager {
    private static final ArrayList<Resume> resumes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Resume Manager ===");
            System.out.println("1. Add Resume");
            System.out.println("2. View Resumes");
            System.out.println("3. Delete Resume");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addResume();
                case 2 -> viewResumes();
                case 3 -> deleteResume();
                case 4 -> System.out.println("Exiting Resume Manager.");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    private static void addResume() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        ArrayList<String> skills = new ArrayList<>();
        System.out.print("Enter number of skills: ");
        int numSkills = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numSkills; i++) {
            System.out.print("Enter skill " + (i + 1) + ": ");
            skills.add(scanner.nextLine());
        }

        Resume resume = new Resume(name, email, phone, skills);
        resumes.add(resume);
        System.out.println("Resume added successfully!");
    }

    private static void viewResumes() {
        if (resumes.isEmpty()) {
            System.out.println("No resumes to display.");
            return;
        }

        System.out.println("\n--- All Resumes ---");
        for (Resume resume : resumes) {
            resume.displayResume();
        }
    }

    private static void deleteResume() {
        System.out.print("Enter name of resume to delete: ");
        String nameToDelete = scanner.nextLine();

        boolean removed = resumes.removeIf(resume -> resume.getName().equalsIgnoreCase(nameToDelete));

        if (removed) {
            System.out.println("Resume deleted successfully.");
        } else {
            System.out.println("Resume not found.");
        }
    }
}