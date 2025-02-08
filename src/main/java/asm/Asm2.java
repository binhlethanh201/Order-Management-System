package asm;

import java.io.FileWriter;

public class Asm2 {
    public static void main(String[] args) throws Exception {
        BSTree <Product> p = new BSTree <Product> ();
        BSTree <Customer> c = new BSTree <Customer> ();
        BSTree <Ordering> o = new BSTree <Ordering> ();
        MenuManager m = new MenuManager();
        FileWriter fw = null;
        MainMenu(c, o, p, m,fw);
    }
    public static void MainMenu(BSTree <Customer> c, BSTree <Ordering> o, BSTree<Product> p, MenuManager m, FileWriter fw) throws Exception{
        while (true) {
            int choice;
            choice = MenuManager.menu();
            if (choice == 0) {
                break;
            }
             switch (choice) {
                case 1:
                    while (true) {
                        int choiceP = Menu.menuP();

                        if (choiceP == 0) {
                            break;
                        }
                        switch (choiceP) {
                            case 1:
                                MenuManager.loadFromFileProducts(p);
                                break;
                            case 2:
                                MenuManager.inputProduct(p);
                                break;
                            case 3:
                                MenuManager.inOrderTraverse(p);
                                break;
                            case 4:
                                 MenuManager.breadthFirstTraverse(p);
                                break;
                                case 5:
                                MenuManager.inOrderTraverseToFile(p, fw);
                                break;
                            
                            case 6:
                                MenuManager.searchByPcode(p);
                                break;
                            case 7:
                                MenuManager.deleteByPcode(p);
                                break;
                            case 8:
                                MenuManager.balance(p);
                                break;
                            case 9:
                                MenuManager.countNode(p);
                                break;                     
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        int choiceC = Menu.menuC();

                        if (choiceC == 0) {
                            break;
                        }
                        switch (choiceC) {
                            case 1:
                                MenuManager.loadFromFileCustomers(c);
                                break;
                            case 2:
                                MenuManager.inputCustomerToEnd(c); 
                                break;
                            case 3:
                                MenuManager.displayCustomer(c);
                                break;              
                            case 4:
                                MenuManager.saveToFile(c);
                                break;
                            case 5:
                                MenuManager.searchByCcode(c);    
                                break;
                            case 6: 
                                MenuManager.deleteByCcode(c);
                                break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        int choiceO = Menu.menuO();

                        if (choiceO == 0) {
                            break;
                        }
                        switch (choiceO) {
                            case 1:
                                MenuManager.addOrder(o);
                                break;
                            case 2:
                                MenuManager.displayOrder(o);
                                break;
                            case 3:
                                MenuManager.sortOrder(o);
                                break;
                        }
                    }
                    break;
            }
        }
    }
}
