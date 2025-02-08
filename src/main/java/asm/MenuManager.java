package asm;
import static asm.Validate.checkInputLimited;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuManager {
    public static final String product_list = "Products.txt";
    public static final String customer_list = "Customers.txt";
    public static final String order_list = "Orders.txt";
     //----- product -----
    public static void loadFromFileProducts(BSTree <Product> p) throws Exception{
        try {    
            File f = new File(product_list);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                String[] detailPro = line.split("//:");                
                p.insertTo(new Product(detailPro[0],
                                          detailPro[1],
                                          Integer.parseInt(detailPro[2]),
                                          Integer.parseInt(detailPro[3]), 
                                          Double.parseDouble(detailPro[4])));
            }
            br.close();
            System.out.println("Load successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static void inputProduct(BSTree<Product> p){
        System.out.print("Enter code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Enter name: ");
        String pName = Validate.checkInputString();
        System.out.print("Enter quantity: ");
        int pQuan = Validate.checkInputInt();
        System.out.print("Enter sale: ");
        int pSale = Validate.checkInputSaled(pQuan);
        System.out.print("Enter price: ");
        double pPrice = Validate.checkInputDouble();
        p.insertTo(new Product(pCode, pName, pQuan, pSale, pPrice));        
        System.err.println("Add succcessfully!");
    }
        public static void inOrderTraverse(BSTree<Product> p){
        p.inOrder(p.root);
    }
        public static void breadthFirstTraverse(BSTree<Product> p){
        p.breadthTravel();
    }
        private static void visit(Node<Product> p, FileWriter fw) throws IOException {
        fw.write(p.getInfo().getPcode() + " | " + p.getInfo().getPro_name() + " | " + p.getInfo().getQuantity() + " | " + p.getInfo().getSaled() + " | " + p.getInfo().getPrice() + "\n");  
    }
    public static void inOrderTraverseToFile(BSTree <Product> p,FileWriter writer) throws IOException {
    writer = new FileWriter(new File(product_list));
    p.traveseToFile(p.root, writer);
    writer.close();
}

        public static void searchByPcode(BSTree<Product> p){
        System.out.print("Enter code want to find: ");
        String code = Validate.checkInputString();
        Node<Product> found = p.search(p.root, new Product(code, "", 0, 0, 0));
        if (found != null){
            System.out.println(found.getInfo());
        }else{
            System.out.println("Not found.");
        }
    }
        public static void deleteByPcode(BSTree<Product> p){
        System.out.print("Enter code want to delete: ");
        String code = Validate.checkInputString();
        Node<Product> found = p.search(p.root, new Product(code, "", 0, 0, 0));
        if (found != null){
            p.delete(found.getInfo());
            System.out.println("Delete sucessfull.");
        }else{
            System.out.println("Not found this code.");
        }
    }
        public static void balance(BSTree<Product> p){
            p.getBalance(p.root);
        }
        public static void countNode(BSTree<Product> p){
        int node = p.countNode();
        System.out.println("Number of Product: " + node);
    }
      //----- customer ----- 
            public static void loadFromFileCustomers(BSTree<Customer> c) throws Exception{
        try {    
            File f = new File(customer_list);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){  
                String[] detailCus = line.split("//:");                
                c.insertTo(new Customer(detailCus[0], detailCus[1], detailCus[2]));
            }
            System.err.println("Load successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
            public  static void inputCustomerToEnd(BSTree<Customer> c){
        System.out.print("Input code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Enter name: ");
        String cName = Validate.checkInputString();
        System.out.print("Enter phone number: ");
        String cPhone =Validate.checkInputString();
        c.insertTo(new Customer(cCode, cName, cPhone)); 
        System.err.println("Add successfully!");
    }
    public static void displayCustomer(BSTree<Customer> c){
       c.visit(c.root);
    }
    public static void saveToFile(BSTree <Customer> c) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customer_list))) {
            c.inOrderTraversal(c.root, writer);
            writer.close();
          System.out.println("Saved successfully!");
        } catch (IOException e) {
            System.out.println("Error.");
        }
    }
        public static void searchByCcode(BSTree<Customer> c){
        System.out.print("Enter code want to find: ");
        String code = Validate.checkInputString();
        Node<Customer> found = c.search(c.root, new Customer(code,"",""));
        if (found != null){
            System.out.println(found.getInfo());
        }else{
            System.out.println("Not found.");
        }
    }
            public static void deleteByCcode(BSTree<Customer> c){
        System.out.print("Enter code want to delete: ");
        String code = Validate.checkInputString();
        Node<Customer> found = c.search(c.root, new Customer(code,"",""));
        if (found != null){
            c.delete(found.getInfo());
            System.out.println("Delete sucessfull.");
        }else{
            System.out.println("Not found this code.");
        }
    }
        //----- order -----
    public static void addOrder(BSTree<Ordering> o){
        System.out.print("Input customer's code: ");
        String cCode = Validate.checkInputString();
        System.out.print("Input product's code: ");
        String pCode = Validate.checkInputString();
        System.out.print("Input product's quantity: ");
        int pQuantity = Validate.checkInputInt();
        o.insertTo(new Ordering(pCode, cCode, pQuantity));
        System.err.println("Add successful!");
    }
    public static void displayOrder(BSTree<Ordering> o){
        o.visit(o.root);
    }
    public static void sortOrder(BSTree<Ordering> o){
        o.preOrder(o.root); //chua check
    }   
        public static int menu(){
        System.out.print("\nMain menu:");
        System.out.println("\n1. Product list");
        System.out.println("2. Customer list");
        System.out.println("3. Order list");
        System.out.println("0. Exit program");
        
        int choice = checkInputLimited(0, 3);
        return choice;
    }
}


