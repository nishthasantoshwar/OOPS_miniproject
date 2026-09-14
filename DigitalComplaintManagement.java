import java.util.*;

class Complaint {
    int id;
    String name;
    String title;
    String category;
    String priority;
    String description;
    String status;

    Complaint(int id, String name, String title, String category,
              String priority, String description) {

        this.id = id;
        this.name = name;
        this.title = title;
        this.category = category;
        this.priority = priority;
        this.description = description;
        this.status = "Pending";
    }

    void display() {
        System.out.println("-----------------------------------------------");
        System.out.println("Complaint ID  : CMP" + id);
        System.out.println("Name          : " + name);
        System.out.println("Title         : " + title);
        System.out.println("Category      : " + category);
        System.out.println("Priority      : " + priority);
        System.out.println("Description   : " + description);
        System.out.println("Status        : " + status);
        System.out.println("-----------------------------------------------");
    }
}

public class DigitalComplaintManagement {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Complaint> complaints = new ArrayList<>();

    static int complaintCounter = 1001;

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println();
            System.out.println("======================================================");
            System.out.println("       DIGITAL COMPLAINT MANAGEMENT SYSTEM");
            System.out.println("======================================================");
            System.out.println("        Welcome to ResolveIQ Portal");
            System.out.println("======================================================");

            System.out.println();
            System.out.println("1. Submit Complaint");
            System.out.println("2. View All Complaints");
            System.out.println("3. Search Complaint");
            System.out.println("4. Update Complaint Status");
            System.out.println("5. Dashboard");
            System.out.println("6. Submit Feedback");
            System.out.println("7. Exit");

            System.out.println();
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    submitComplaint();
                    break;

                case 2:
                    viewComplaints();
                    break;

                case 3:
                    searchComplaint();
                    break;

                case 4:
                    updateStatus();
                    break;

                case 5:
                    dashboard();
                    break;

                case 6:
                    feedback();
                    break;

                case 7:
                    System.out.println();
                    System.out.println("======================================================");
                    System.out.println("       Thank you for using ResolveIQ!");
                    System.out.println("======================================================");
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }

    // SUBMIT COMPLAINT
    static void submitComplaint() {

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                SUBMIT COMPLAINT");
        System.out.println("======================================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter complaint title: ");
        String title = sc.nextLine();

        System.out.println();
        System.out.println("Select Category:");
        System.out.println("1. Electricity");
        System.out.println("2. Water Supply");
        System.out.println("3. Road & Transport");
        System.out.println("4. Healthcare");
        System.out.println("5. Education");
        System.out.println("6. Waste Management");
        System.out.println("7. Other");

        System.out.print("Enter category number: ");
        int categoryChoice = sc.nextInt();
        sc.nextLine();

        String category;

        switch (categoryChoice) {

            case 1:
                category = "Electricity";
                break;

            case 2:
                category = "Water Supply";
                break;

            case 3:
                category = "Road & Transport";
                break;

            case 4:
                category = "Healthcare";
                break;

            case 5:
                category = "Education";
                break;

            case 6:
                category = "Waste Management";
                break;

            default:
                category = "Other";
        }

        System.out.println();
        System.out.println("Select Priority:");
        System.out.println("1. Low");
        System.out.println("2. Medium");
        System.out.println("3. High");
        System.out.println("4. Critical");

        System.out.print("Enter priority number: ");
        int priorityChoice = sc.nextInt();
        sc.nextLine();

        String priority;

        switch (priorityChoice) {

            case 1:
                priority = "Low";
                break;

            case 2:
                priority = "Medium";
                break;

            case 3:
                priority = "High";
                break;

            case 4:
                priority = "Critical";
                break;

            default:
                priority = "Medium";
        }

        System.out.print("Enter complaint description: ");
        String description = sc.nextLine();

        Complaint complaint = new Complaint(
                complaintCounter,
                name,
                title,
                category,
                priority,
                description
        );

        complaints.add(complaint);

        System.out.println();
        System.out.println("======================================================");
        System.out.println("          COMPLAINT SUBMITTED SUCCESSFULLY!");
        System.out.println("======================================================");

        System.out.println("Complaint ID : CMP" + complaintCounter);
        System.out.println("Status       : Pending");

        System.out.println("======================================================");

        complaintCounter++;
    }

    // VIEW COMPLAINTS
    static void viewComplaints() {

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                 ALL COMPLAINTS");
        System.out.println("======================================================");

        if (complaints.isEmpty()) {

            System.out.println("No complaints found.");

            return;
        }

        for (Complaint c : complaints) {
            c.display();
        }
    }

    // SEARCH
    static void searchComplaint() {

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                 SEARCH COMPLAINT");
        System.out.println("======================================================");

        System.out.print("Enter Complaint ID: CMP");

        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Complaint c : complaints) {

            if (c.id == id) {

                c.display();

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println();
            System.out.println("Complaint not found.");
        }
    }

    // UPDATE STATUS
    static void updateStatus() {

        System.out.println();
        System.out.println("======================================================");
        System.out.println("              UPDATE COMPLAINT STATUS");
        System.out.println("======================================================");

        System.out.print("Enter Complaint ID: CMP");

        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Complaint c : complaints) {

            if (c.id == id) {

                System.out.println();
                System.out.println("Current Status: " + c.status);

                System.out.println();
                System.out.println("1. Pending");
                System.out.println("2. In Progress");
                System.out.println("3. Resolved");

                System.out.print("Select new status: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        c.status = "Pending";
                        break;

                    case 2:
                        c.status = "In Progress";
                        break;

                    case 3:
                        c.status = "Resolved";
                        break;

                    default:
                        System.out.println("Invalid status.");
                        return;
                }

                System.out.println();
                System.out.println("Status updated successfully!");
                System.out.println("New Status: " + c.status);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Complaint not found.");
        }
    }

    // DASHBOARD
    static void dashboard() {

        int pending = 0;
        int progress = 0;
        int resolved = 0;

        for (Complaint c : complaints) {

            if (c.status.equals("Pending")) {
                pending++;
            }

            else if (c.status.equals("In Progress")) {
                progress++;
            }

            else if (c.status.equals("Resolved")) {
                resolved++;
            }
        }

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                 COMPLAINT DASHBOARD");
        System.out.println("======================================================");

        System.out.println();
        System.out.println("Total Complaints : " + complaints.size());
        System.out.println("Pending          : " + pending);
        System.out.println("In Progress      : " + progress);
        System.out.println("Resolved         : " + resolved);

        System.out.println();
        System.out.println("======================================================");
    }

    // FEEDBACK
    static void feedback() {

        System.out.println();
        System.out.println("======================================================");
        System.out.println("                 FEEDBACK & RATING");
        System.out.println("======================================================");

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println();
        System.out.println("Rate our service:");
        System.out.println("1. ⭐");
        System.out.println("2. ⭐⭐");
        System.out.println("3. ⭐⭐⭐");
        System.out.println("4. ⭐⭐⭐⭐");
        System.out.println("5. ⭐⭐⭐⭐⭐");

        System.out.print("Enter rating: ");
        int rating = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter feedback: ");
        String message = sc.nextLine();

        System.out.println();
        System.out.println("======================================================");
        System.out.println("             FEEDBACK SUBMITTED!");
        System.out.println("======================================================");

        System.out.println("Name     : " + name);
        System.out.println("Rating   : " + rating + "/5");
        System.out.println("Feedback : " + message);

        System.out.println();
        System.out.println("Thank you for your valuable feedback!");

        System.out.println("======================================================");
    }
}
