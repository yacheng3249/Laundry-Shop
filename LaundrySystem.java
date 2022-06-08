package week3.exam;

import java.util.ArrayList;
import java.util.HashMap;

public class LaundrySystem {
    private WashMachine machine = new WashMachine();
    private OrderSystem orderSystem = new OrderSystem();

    private HashMap<String, ArrayList<Order>> unfinishedOrderRecord = new HashMap();
    private HashMap<String, ArrayList<Order>> finishedOrderRecord = new HashMap();


    /**
     * 輸入訂單並照順序將要清洗的衣服送入洗衣機，若是輸入失敗則回傳false，並將該訂單記錄下來
     *
     * @return
     */
    public boolean cleanCloth(Order inputOrder) {
        for (int i = 0; i < inputOrder.clothAmount(); i++) {
            if (inputOrder.getCloth(i).isClean()) {
                continue;
            }

            //訂單未完成
            if (!machine.add(inputOrder.getCloth(i))) {
                if (unfinishedOrderRecord.containsKey(inputOrder.getCustomer())) {
                    unfinishedOrderRecord.get(inputOrder.getCustomer()).add(inputOrder);
                } else {
                    ArrayList<Order> unfinishedOrderList = new ArrayList<>();
                    unfinishedOrderList.add(inputOrder);
                    unfinishedOrderRecord.put(inputOrder.getCustomer(), unfinishedOrderList);
                }
                return false;
            }
        }

        //訂單已完成
        if (finishedOrderRecord.containsKey(inputOrder.getCustomer())) {
            finishedOrderRecord.get(inputOrder.getCustomer()).add(inputOrder);
        } else {
            ArrayList<Order> finishedOrderList = new ArrayList<>();
            finishedOrderList.add(inputOrder);
            unfinishedOrderRecord.put(inputOrder.getCustomer(), finishedOrderList);
        }
        return true;
    }


    /**
     * 從洗衣機取出所有衣服，同時將未完成訂單的衣服送進洗衣機中
     */
    public void manageMachine(Order inputOrder) {
        while (!machine.isEmpty()) {
            machine.getCloth();
        }
        cleanCloth(inputOrder);
    }

    /**
     * 取出指定客戶的已完成訂單
     */
    public ArrayList<Order> getOrder(String customer) {
        for (String key : finishedOrderRecord.keySet()) {
            if (key.equals(customer)){
                return finishedOrderRecord.get(key);
            }
        }
        return null;
    }
}
