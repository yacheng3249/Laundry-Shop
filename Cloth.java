package week3.exam;

public class Cloth {
    /**
     * 衣服類型
     */
    private ClothType type;
    /**
     * 衣服尺寸
     */
    private ClothSize size;
    /**
     * 衣服顏色
     */
    private ClothColor color;
    /**
     * 是否洗過
     */
    private boolean isClean;

    public ClothType getType() {
        return type;
    }

    public ClothSize getSize() {
        return size;
    }

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public enum ClothType{
        TShirt,
        Jacket,
        PoloShirt
    }

    public enum ClothSize{
        S(1),
        M(2),
        L(3),
        XL(4),
        XXL(5);

        private int input;

        ClothSize(int input) {
            this.input = input;
        }

        public int getInput() {
            return input;
        }
    }

    public enum ClothColor{
        Red,
        Green,
        Grey,
        Blue,
        Yellow
    }
}
