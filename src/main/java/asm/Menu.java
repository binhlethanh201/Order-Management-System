package asm;
public class Menu {

    public static int menuP() {
        System.out.println("Product menu:");
        System.out.println("""
                           1. Load data from file
                           2. Input & insert data
                           3. In-order traverse
                           4. Breadth-first traverse
                           5. In-order traverse to file
                           6. Search by pcode
                           7. Delete by pcode by copying
                           8. Simply balancing
                           9. Count number of products
                           0. Exit to main menu
                           """);

        int choice = Validate.checkInputLimited(0, 9);
        return choice;
    }
    public static int menuC() {
        System.out.println("Customer menu:");
        System.out.println("""
                           1. Load data from file
                           2. Input & add to the end
                           3. Display data
                           4. Save customer list to file
                           5. Search by ccode
                           6. Delete by ccode
                           0. Exit to main menu
                           """);
        
        int choice = Validate.checkInputLimited(0, 6);
        return choice;
    }
    public static int menuO() {
        System.out.println("Order menu:");
        System.out.println("""
                           1. Input data
                           2. Display ordering data
                           3. Sort by pcode + ccode
                           0. Exit to main menu
                           """);

        int choice = Validate.checkInputLimited(0, 3);
        return choice;
    }



}

