import java.util.*;

public class BankingSystem {

  static HashMap<String, String> userCredentials = new HashMap<String, String>(); //username, password
  static double[] balances = new double[100] ; //balance array

  public static void main(String[] args) {
    int accountNum = 0001;
    Arrays.fill(balances, 0.0); 
    
    Scanner input = new Scanner(System.in);

    System.out.println("    ____              __            ____       __                 ");
    System.out.println("   / __ )____ _____  / /__   ____  / __/      / /___ __   ______ _");
    System.out.println("  / __  / __ `/ __ \\/ //_/  / __ \\/ /_   __  / / __ `/ | / / __ `/");
    System.out.println(" / /_/ / /_/ / / / / ,<    / /_/ / __/  / /_/ / /_/ /| |/ / /_/ / ");
    System.out.println("/_____/\\__,_/_/ /_/_/|_|   \\____/_/     \\____/\\__,_/ |___/\\__,_/ \n ");

    int option;
    do {
      //Home Page
      System.out.println("1. Login");
      System.out.println("2. Create New Account");
      System.out.println("3. Exit");
      option = input.nextInt();
      if (option == 1) {
        login();
      } else if (option == 2) {
        newAccount(accountNum);
        accountNum++;
        System.out.println("Login Again:");
        login();
      }else if(option == 3) {
    	  break; //Exit
      } 
      int num;
      do {
        //Banking Page
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Logout");
        num = input.nextInt();
        if (num == 1) {
          System.out.println("Your current balance is $" + balances[accountNum-1]);
        } else if (num == 2) { 
          System.out.print("Enter amount to deposit: $");
          double deposit = input.nextDouble();
          balances[accountNum-1] += deposit;
          System.out.println("$" + deposit + " has been deposited to your account. ");
          System.out.println("Your current balance is $" + balances[accountNum-1]);
        } else if (num == 3) {
          System.out.print("Enter the amount to withdraw: $");
          double withdraw = input.nextDouble();
          if (withdraw > balances[accountNum-1]) {
            System.out.println("Insufficient funds.");
          } else {
        	  balances[accountNum-1] -= withdraw;
            System.out.println("$" + withdraw + " has been withdrawn from your account. ");
          }
          System.out.println("Your current balance is $" + balances[accountNum-1]);
        }
      } while (num != 4);
      System.out.println("Thank you for banking at the Bank of Java. Have a great day!");
    } while (option != 3);
  }

  // Method to make new account
  public static void newAccount(int accountNum) {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    //Asks info
    System.out.print("Name: ");
    String name = input.nextLine();
    System.out.print("Username: ");
    String username = input.next();
    System.out.print("Password: ");
    String password = input.next();

    // Store user credentials in the hashmap
    userCredentials.put(username, password);

    System.out.println("Congratulations! Your account has been created.");
    System.out.println("Your Account Number is: " + accountNum);
    System.out.println("Please Log in Again.\n");
  }

  //Method to allow user to login
  public static void login() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter Username: ");
    String username = input.next();
    System.out.print("Enter Password: ");
    String password = input.next();

    // Check if the provided credentials match the stored credentials
    if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
      System.out.println("\nLogin successful. Welcome, " + username + "!");
    } else {
      System.out.println("Invalid credentials. Please try again.");
      login(); // Recursive call to allow the user to try logging in again
    }
  }
}
}
