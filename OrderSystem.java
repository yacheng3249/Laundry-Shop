package week3.exam;

public class OrderSystem {
    private class Node {
        private Order data;
        private Node next;

        public Node() {
        }

        public Node(Order data) {
            this.data = data;
        }
    }

    private Node root;
    private Node tail;
    private int count;

    public OrderSystem() {
        this.root = new Node();
        this.tail = root;
        this.count = 0;
    }

    /**
     * 新建訂單
     *
     * @param data
     */
    public void addOrder(Order data) {
        tail.next = new Node(data);
        tail = tail.next;
        count++;
    }

    /**
     * 取出訂單(依照先來先處理的順序處理)
     *
     * @return
     */
    public Order getOrder() {
        if (root.next == null) {
            return null;
        }
        Node target = root.next;
        root.next = root.next.next;
        count--;
        return target.data;
    }

    /**
     * 輸出指定客戶所需付款的總金額
     *
     * @return 總金額
     */
    public int getBill(String customer) {
        int totalBill = 0;
        Node target = root.next;
        while (target != null) {
            if (target.data.getCustomer().equals(customer)) {
                totalBill += target.data.getOrderBill();
            }
        }
        return totalBill;
    }

    /**
     * 輸出目前所有訂單已付款金額總額
     *
     * @return 已付款金額總額
     */
    public int getTotalPaid() {
        int totalPaid = 0;
        Node target = root.next;
        while (target != null) {
            if (target.data.isPaid()) {
                totalPaid += target.data.getOrderBill();
            }
        }
        return totalPaid;
    }
}
