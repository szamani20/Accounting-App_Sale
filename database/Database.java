package database;

import gui.Products;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Database {

    List<Client> clientList = new LinkedList<>();

    public void loadFromFile(Client client) {
        String fileName = "database.cli";
        File file = new File(fileName);

        FileInputStream fis;
        ObjectInputStream ois;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            Client[] clients = (Client[])ois.readObject();

            clientList.clear();

            clientList.addAll(Arrays.asList(clients));

            for (int i=0; i<clientList.size(); ++i) {
                if(clientList.get(i).getName().equals(client.getName())&&
                        clientList.get(i).getLastName().equals(client.getLastName())&&
                        clientList.get(i).getPhone().equals(client.getPhone())&&
                        clientList.get(i).getPassword().equals(client.getPassword())) {

                    Client clientTemp = clientList.get(i);

                    List<Products> product;
                    if(clientList.get(i).getProduct() != null)
                        product = clientList.get(i).getProduct();
                    else
                        product = new LinkedList<>();
                    product.add(client.getProductI());

                    List<Integer> price;
                    if(clientList.get(i).getPrice() != null)
                        price = clientList.get(i).getPrice();
                    else
                        price = new LinkedList<>();
                    price.add(client.getPriceI());

                    List<Integer> amount;
                    if(clientList.get(i).getAmount() != null)
                        amount= clientList.get(i).getAmount();
                    else
                        amount = new LinkedList<>();
                    amount.add(client.getAmountI());

                    List<Integer> total;
                    if(clientList.get(i).getTotal() != null)
                        total= clientList.get(i).getTotal();
                    else
                        total = new LinkedList<>();
                    total.add(client.getTotalI());

                    List<Integer> payment;
                    if(clientList.get(i).getPayment() != null)
                        payment= clientList.get(i).getPayment();
                    else
                        payment = new LinkedList<>();
                    payment.add(client.getPaymentI());

                    List<Integer> debt;
                    if(clientList.get(i).getPayment() != null)
                        debt = clientList.get(i).getDebt();
                    else
                        debt = new LinkedList<>();
                    debt.add(client.getDebtI());

                    List<Integer> year;
                    if(clientList.get(i).getYear() != null)
                        year = clientList.get(i).getYear();
                    else
                        year = new LinkedList<>();
                    year.add(client.getYearI());

                    List<Integer> month;
                    if(clientList.get(i).getMonth() != null)
                        month = clientList.get(i).getMonth();
                    else
                        month = new LinkedList<>();
                    month.add(client.getMonthI());

                    List<Integer> day;
                    if(clientList.get(i).getMonth() != null)
                        day = clientList.get(i).getDay();
                    else
                        day = new LinkedList<>();
                    day.add(client.getDayI());

                    List<Boolean> noDebt;
                    if (clientList.get(i).getNoDebt() != null)
                        noDebt = clientList.get(i).getNoDebt();
                    else
                        noDebt = new LinkedList<>();
                    noDebt.add(client.getNoDebtI());

                    clientTemp.setProduct(product);
                    clientTemp.setPrice(price);
                    clientTemp.setAmount(amount);
                    clientTemp.setTotal(total);
                    clientTemp.setPayment(payment);
                    clientTemp.setDebt(debt);
                    clientTemp.setNoDebt(noDebt);
                    clientTemp.setYear(year);
                    clientTemp.setMonth(month);
                    clientTemp.setDay(day);

                    clientList.set(i, clientTemp);

                    break;

                }
            }

            saveToFile();

            ois.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        String fileName = "database.cli";
        File file = new File(fileName);

        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            Client[] clients = clientList.toArray(new Client[clientList.size()]);

            oos.writeObject(clients);

            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
