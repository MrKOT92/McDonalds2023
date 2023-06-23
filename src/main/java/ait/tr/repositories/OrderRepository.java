package ait.tr.repositories;

import ait.tr.models.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRepository implements IOrderRepository{

    private List<Order> dayOrders = new ArrayList<>();

    private final String fileName;

    public OrderRepository(String fileName) {
        this.fileName = fileName;
    }

    //TODO realise + order.getOrderList() change to method Arrays.tostring
    public void save(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(order.getId() + "|" +
                    order.getNumber() + "|" + order.getOrderlist() ////Method
                    + "|" + order.isPayed());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("File Error" + e.getMessage());
        }
        dayOrders.add(order);


        //TODO with file
    }
    public Order findById(String id) {
        for (Order order: dayOrders
        ) {
            if(order.getId().equals(id)){
                return order;
            }
        }
        throw new NullPointerException("Order is not found");


        }

        public  Order findByIdFile(String id) {

//        if(id == null){
//            throw new NullPointerException("Order is not found");
//    }

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){

//                return reader.lines()
//                        .map(line ->line.split("\\|"))
//                        .filter(parsed -> parsed[0].equals(id))
//                        .map()
//                        .findFirst().orElse(null);



            } catch (IOException e) { System.out.println("File error" + e.getMessage()); }


           return null;

        }




    //TODO file
    @Override
    public void remove(Order order) {
        findById(order.getId());



    }


}
//    public void removeExpense(String expenseToRemove) {
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(fileName));
//            List<Expense> expenses = new ArrayList<>();
//            String line = reader.readLine();
//            while ((line != null)) {
//                Expense expense = parseLine(line);
//                expenses.add(expense);
//                line = reader.readLine();
//            }
//            for (int i = 0; i<expenses.size();i++){
//                if (expenses.get(i).getTitle().equals(expenseToRemove)) {
//                    expenses.remove(i);
//                }
//            }
//            reader.close();
//            try {
//                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
//                for (Expense expense:expenses){
//                    writer.write(expense.getTitle() + "|" +
//                            expense.getCategory() + "|" +
//                            expense.getSumExpenses() + "|" +
//                            (new SimpleDateFormat("dd.MM.yyyy").format(expense.getDate())));
//                    writer.newLine();
//                }
//                writer.close();
//            }catch (Exception e){
//                System.err.println("Ошибка записи файла");
//            }
//            System.out.println("Расход успешно удален");
//        } catch (Exception e) {
//            System.out.println("Произошла ошибка работы с файлом");
//        }
//    }














