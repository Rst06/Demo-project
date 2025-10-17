import java.util.Scanner;

// Generic Functional Interface
@FunctionalInterface
interface DataProcessor<T, R> {
    R process(T a, T b);
}

public class ECommerceDataProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n------- E-commerce Data Processing -------");
            System.out.println("1. Find Maximum of Two Product Quantities");
            System.out.println("2. Apply Discount on Product Price");
            System.out.println("3. Concatenate Customer Names");
            System.out.println("4. Count Words in a Customer Review");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Find maximum of two integers
                    System.out.print("Enter first quantity: ");
                    int q1 = sc.nextInt();
                    System.out.print("Enter second quantity: ");
                    int q2 = sc.nextInt();

                    DataProcessor<Integer, Integer> maxFinder = (a, b) -> (a > b) ? a : b;
                    System.out.println("Maximum Quantity: " + maxFinder.process(q1, q2));
                    break;

                case 2:
                    // Apply discount on price
                    System.out.print("Enter product price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter discount percentage: ");
                    double discount = sc.nextDouble();

                    DataProcessor<Double, Double> applyDiscount = (p, d) -> p - (p * d / 100);
                    System.out.println("Final Price after Discount: " + applyDiscount.process(price, discount));
                    break;

                case 3:
                    // Concatenate customer names
                    System.out.print("Enter first name: ");
                    String first = sc.nextLine();
                    System.out.print("Enter last name: ");
                    String last = sc.nextLine();

                    DataProcessor<String, String> concatNames = (a, b) -> a + " " + b;
                    System.out.println("Full Name: " + concatNames.process(first, last));
                    break;

                case 4:
                    // Count words in customer review
                    System.out.print("Enter customer review: ");
                    String review = sc.nextLine();

                    DataProcessor<String, Integer> wordCounter = (a, b) -> a.trim().split("\\s+").length;
                    System.out.println("Word Count: " + wordCounter.process(review, null));
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
