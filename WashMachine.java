package week3.exam;

public class WashMachine {
    private class Node {
        private Cloth data;
        private Node next;
        private Node previous;

        public Node() {
        }

        public Node(Cloth data) {
            this.data = data;
        }
    }

    private static final int MAX_SIZE = 10;
    private Node root;
    private Node tail;
    private int count;

    public WashMachine() {
        this.root = new Node();
        this.tail = root;
        this.count = 0;
    }

    /**
     * 放入一件衣服，如果成功放入則將輸入的衣服清洗過(將衣服中的是否洗過設定為true)
     *
     * @param dirtyCloth
     * @return
     */
    public boolean add(Cloth dirtyCloth) {
        //如果洗衣機已有10件衣服，回傳失敗
        if (count >= MAX_SIZE) {
            return false;
        }

        //先把目前最後節點保存
        Node temp = tail;
        //再把新的節點加到尾巴後面
        tail.next = new Node(dirtyCloth);
        //更新尾巴位置
        tail = tail.next;
        tail.previous = temp;

        dirtyCloth.setClean(true);
        count++;
        return true;
    }

    /**
     * 拿出一件衣服
     * 最後放入的衣服最先取出
     *
     * @return cloth
     */
    public Cloth getCloth() {
        Node target = tail;
        tail = tail.previous;
        return target.data;
    }

    public boolean isEmpty() {
        return root == tail;
    }
}
