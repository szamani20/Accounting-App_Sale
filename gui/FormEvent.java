package gui;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String lastName;
    private String phone;
    private String password;
    private Products product;
    private Integer price;
    private Integer amount;
    private Integer total;
    private Integer payment;
    private Integer debt;
    private Boolean noDebt;
    private Integer year;
    private Integer month;
    private Integer day;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String lastName,
                     String phone, String password, Products product,
                     Integer price, Integer amount, Integer total,
                     Integer payment, Integer debt, Boolean noDebt,
                     Integer year, Integer month, Integer day) {
        super(source);
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.product = product;
        this.price = price;
        this.amount = amount;
        this.total = total;
        this.payment = payment;
        this.debt = debt;
        this.noDebt = noDebt;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public Products getProduct() {
        return product;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getPayment() {
        return payment;
    }

    public Integer getDebt() {
        return debt;
    }

    public Boolean getNoDebt() {
        return noDebt;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getTotal() {
        return total;
    }
}
