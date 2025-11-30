import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerDAO dao = new CustomerDAO();

        while (true) {
            System.out.println("\n=== Customer Management ===");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. View Customer by ID");
            System.out.println("5. View All Customers");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("City: ");
                    String city = sc.nextLine();
                    Customer c1 = new Customer(id, name, email, phone, city);
                    System.out.println(dao.addCustomer(c1) ? "Inserted." : "Insert failed.");
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    Customer existing = dao.getCustomer(uid);
                    if (existing == null) {
                        System.out.println("No customer with that ID.");
                        break;
                    }
                    System.out.println("Current: " + existing);
                    System.out.print("New Name: ");
                    String nname = sc.nextLine();
                    System.out.print("New Email: ");
                    String nemail = sc.nextLine();
                    System.out.print("New Phone: ");
                    String nphone = sc.nextLine();
                    System.out.print("New City: ");
                    String ncity = sc.nextLine();
                    Customer cupd = new Customer(uid, nname, nemail, nphone, ncity);
                    System.out.println(dao.updateCustomer(cupd) ? "Updated." : "Update failed.");
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt(); sc.nextLine();
                    System.out.println(dao.deleteCustomer(did) ? "Deleted." : "Delete failed.");
                    break;

                case 4:
                    System.out.print("Enter ID to view: ");
                    int vid = sc.nextInt(); sc.nextLine();
                    Customer c = dao.getCustomer(vid);
                    System.out.println(c != null ? c : "No customer found.");
                    break;

                case 5:
                    List<Customer> all = dao.getAllCustomers();
                    if (all.isEmpty()) {
                        System.out.println("No customers.");
                    } else {
                        for (Customer cx : all) {
                            System.out.println(cx);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
