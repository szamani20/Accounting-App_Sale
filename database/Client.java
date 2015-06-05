package database;

import gui.Products;

import java.io.Serializable;
import java.util.List;

public class Client implements Serializable {
    private static final long serialVersionUID = -418745565;

    private String name;
    private String lastName;
    private String phone;
    private String password;
    private List<Products> product;
    private List<Integer> price;
    private List<Integer> amount;
    private List<Integer> total;
    private List<Integer> payment;
    private List<Integer> debt;
    private List<Boolean> noDebt;
    private List<Integer> year;
    private List<Integer> month;
    private List<Integer> day;

    private Products productI;
    private Integer priceI;
    private Integer amountI;
    private Integer totalI;
    private Integer paymentI;
    private Integer debtI;
    private Boolean noDebtI;
    private Integer yearI;
    private Integer monthI;
    private Integer dayI;

    public Client(String name, String lastName, String phone,
                  String password, List<Products> product,
                  List<Integer> price, List<Integer> amount, List<Integer> total,
                  List<Integer> payment, List<Integer> debt,List<Boolean> noDebt,
                  List<Integer> year, List<Integer> month, List<Integer> day) {
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

    public Client(String name, String lastName, String phone, String password,
                  Products productI, Integer priceI, Integer amountI,
                  Integer totalI, Integer paymentI, Integer debtI, Boolean noDebtI,
                  Integer yearI, Integer monthI, Integer dayI) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.password = password;
        this.productI = productI;
        this.priceI = priceI;
        this.amountI = amountI;
        this.totalI = totalI;
        this.paymentI = paymentI;
        this.debtI = debtI;
        this.noDebtI = noDebtI;
        this.yearI = yearI;
        this.monthI = monthI;
        this.dayI = dayI;
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

    public List<Products> getProduct() {
        return product;
    }

    public void setProduct(List<Products> product) {
        this.product = product;
    }

    public List<Integer> getPrice() {
        return price;
    }

    public void setPrice(List<Integer> price) {
        this.price = price;
    }

    public List<Integer> getAmount() {
        return amount;
    }

    public void setAmount(List<Integer> amount) {
        this.amount = amount;
    }

    public List<Integer> getTotal() {
        return total;
    }

    public void setTotal(List<Integer> total) {
        this.total = total;
    }

    public List<Integer> getPayment() {
        return payment;
    }

    public void setPayment(List<Integer> payment) {
        this.payment = payment;
    }

    public List<Integer> getDebt() {
        return debt;
    }

    public void setDebt(List<Integer> debt) {
        this.debt = debt;
    }

    public List<Boolean> getNoDebt() {
        return noDebt;
    }

    public void setNoDebt(List<Boolean> noDebt) {
        this.noDebt = noDebt;
    }

    public List<Integer> getYear() {
        return year;
    }

    public void setYear(List<Integer> year) {
        this.year = year;
    }

    public List<Integer> getMonth() {
        return month;
    }

    public void setMonth(List<Integer> month) {
        this.month = month;
    }

    public List<Integer> getDay() {
        return day;
    }

    public void setDay(List<Integer> day) {
        this.day = day;
    }

    public Products getProductI() {
        return productI;
    }

    public void setProductI(Products productI) {
        this.productI = productI;
    }

    public Integer getPriceI() {
        return priceI;
    }

    public void setPriceI(Integer priceI) {
        this.priceI = priceI;
    }

    public Integer getAmountI() {
        return amountI;
    }

    public void setAmountI(Integer amountI) {
        this.amountI = amountI;
    }

    public Integer getTotalI() {
        return totalI;
    }

    public void setTotalI(Integer totalI) {
        this.totalI = totalI;
    }

    public Integer getPaymentI() {
        return paymentI;
    }

    public void setPaymentI(Integer paymentI) {
        this.paymentI = paymentI;
    }

    public Integer getDebtI() {
        return debtI;
    }

    public void setDebtI(Integer debtI) {
        this.debtI = debtI;
    }

    public Boolean getNoDebtI() {
        return noDebtI;
    }

    public void setNoDebtI(Boolean noDebtI) {
        this.noDebtI = noDebtI;
    }

    public Integer getYearI() {
        return yearI;
    }

    public void setYearI(Integer yearI) {
        this.yearI = yearI;
    }

    public Integer getMonthI() {
        return monthI;
    }

    public void setMonthI(Integer monthI) {
        this.monthI = monthI;
    }

    public Integer getDayI() {
        return dayI;
    }

    public void setDayI(Integer dayI) {
        this.dayI = dayI;
    }
}
