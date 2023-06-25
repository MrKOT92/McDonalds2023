package ait.tr.repositories;

import ait.tr.models.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private final String fileName;

    public OrderRepositoryImpl(String fileName) {
        this.fileName = fileName;
    }

    public void save(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(order.getId() + "|" +
                    order.getNumber() + "|" +
                    order.isPayed());
            writer.newLine();
        } catch (IOException e) {
            throw new IllegalStateException("File Error" + e.getMessage());
        }


    }

    public Order findById(String id) {
        return null;
    }

    public Order findByIdFile(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split("\\|"))
                    .filter(parsed -> parsed[0].equals(id))
                    .map(order -> new Order(order[0],
                            Integer.parseInt(order[1]),    ///order[2],
                            Boolean.parseBoolean(order[2])))
                    .findFirst().orElse(null);
        } catch (IOException e) {
            throw new IllegalStateException("File error" + e.getMessage());
        }

    }

    @Override
    public void remove(String id) {
        List<Order> orders = findAllOrders();
        List <Order> newOrders = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
           if(!orders.get(i).getId().equals(id)){
               newOrders.add(orders.get(i));
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Order orderNew:newOrders
            ) { writer.write(orderNew.getId() + "|" +
                    orderNew.getNumber() + "|" +
                    orderNew.isPayed());
                writer.newLine();
            }

            } catch (IOException e) {
            throw new IllegalStateException("File error" + e.getMessage());
        }
        System.out.println("ORDER with id " + id + " deleted successfully");
    }
    public   List<Order> findAllOrders() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.lines()
                    .map(line -> line.split("\\|"))
                    .map(array -> new Order(array[0],
                            Integer.parseInt(array[1]),
                            Boolean.parseBoolean(array[2])))
                    .toList();

        } catch (IOException e) {
            throw new IllegalStateException("File error" + e.getMessage());
        }
    }



}





