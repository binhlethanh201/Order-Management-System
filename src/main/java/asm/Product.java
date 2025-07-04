package asm;
import java.util.Objects;

public class Product implements Comparable<Product>{
    private String pcode;
    private String pro_name;
    private int quantity;
    private int saled;
    private double price;

    public Product(String string, String a, String string1, String string2, int par) {
    }

    public Product(String pcode, String pro_name, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.saled = saled;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPcode() {
        return pcode;
    }

    public String getPro_name() {
        return pro_name;
    }

    public int getSaled() {
        return saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return pcode + " | " +pro_name +" | " + quantity + " | " + saled +" | " +price;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.pcode, other.pcode)) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.pcode);
        return hash;
    }

    @Override
    public int compareTo(Product t) {
        return t.getPcode().compareTo(pcode);
    }
}

