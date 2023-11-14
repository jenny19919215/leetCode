package hsbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaShop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numofOrders = scanner.nextInt();
        int size = scanner.nextInt();

        List<Integer> ordersNum = new ArrayList<>();
        for (int i = 0; i < numofOrders; i++) {
            int orderNum = scanner.nextInt();
            ordersNum.add(orderNum);
        }

        List<Integer> meatOrderList = findFirstMeatOrders(ordersNum, size);

        for (int meatOrder : meatOrderList) {
            System.out.print(meatOrder + " ");
        }
    }

    public static List<Integer> findFirstMeatOrders(List<Integer> ordersNum, int size) {
        List<Integer> meatOrderList = new ArrayList<>();

        for (int i = 0; i + size <= ordersNum.size(); i++) {
            List<Integer> displayedOrders = ordersNum.subList(i, Math.min(i + size, ordersNum.size()));
            int firstMeatOrder = 0;
            for (int order : displayedOrders) {
                if (order < 0) {
                    firstMeatOrder = order;
                    break;
                }
            }

            meatOrderList.add(firstMeatOrder);
        }

        return meatOrderList;
    }
}
