package week3.exam;

import java.util.Date;

public class Order {
    private static int count = 1;
    /**
     * 訂單編號
     */
    private int orderNum;
    private String customer;
    private Cloth[] clothArray;
    private boolean isPaid;
    private Date pickUpTime;

    /**
     * 建構子
     * @param customer
     * @param clothArray
     */
    public Order(String customer, Cloth[] clothArray) {
        this.orderNum = count;
        count++;
        this.customer = customer;
        this.clothArray = clothArray;
        this.isPaid = false;
        this.pickUpTime = new Date(System.currentTimeMillis());;
    }

    public String getCustomer() {
        return customer;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public int clothAmount() {
        return clothArray.length;
    }

    public Cloth getCloth(int index) {
        return clothArray[index];
    }

    /**
     * 計算此帳單金額
     *
     * @return
     */
    public int getOrderBill() {
        int totalBill = 0;
        for (Cloth singleCloth : clothArray) {
            if (!singleCloth.isClean()) {
                continue;
            }
            switch (singleCloth.getType()) {
                case TShirt:
                    totalBill += 20;
                    totalBill += 2 * (singleCloth.getSize().getInput() - 1);
                    break;
                case Jacket:
                    totalBill += 50;
                    totalBill += 5 * (singleCloth.getSize().getInput() - 1);
                    break;
                case PoloShirt:
                    totalBill += 10;
                    totalBill += 2 * (singleCloth.getSize().getInput() - 1);
                    break;
                default:
                    totalBill += 0;
                    break;
            }
        }
        return totalBill;
    }
}
