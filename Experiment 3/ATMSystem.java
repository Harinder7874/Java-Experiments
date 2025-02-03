import java.util.Scanner;

public class ATMSystem {
    static class InvalidPINException extends Exception {}
    static class InsufficientBalanceException extends Exception {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String correctPIN = "1234";
        double balance = 10000;

        try {
            System.out.print("Enter PIN: ");
            String enteredPIN = scanner.nextLine();
            if (!enteredPIN.equals(correctPIN)) {
                throw new InvalidPINException();
            }

            System.out.print("Withdraw Amount: ");
            double withdrawAmount = scanner.nextDouble();
            if (withdrawAmount > balance) {
                throw new InsufficientBalanceException();
            }

            balance -= withdrawAmount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
        } catch (InvalidPINException e) {
            System.out.println("Error: Invalid PIN.");
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: Insufficient balance. Current Balance: " + balance);
        }
    }
}
