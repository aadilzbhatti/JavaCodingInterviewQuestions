package interviewing.algorithms.bitmanipulation;

public class BinaryString {
    private int number;
    private String representation;

    public BinaryString(String rep) {
        int num = 0;
        int pos = 0;
        for (int i = rep.length() - 1; i >= 0; i--) {
            int bit = Character.getNumericValue(rep.charAt(i));
            assert bit == 1 || bit == 0;
            num += bit * Math.pow(2, pos);
            pos++;
        }
        number = num;
        representation = rep;
    }

    public BinaryString(int number) {
        this.number = number;
        recomputeRepresentation();
    }

    public int getNumber() {
        return number;
    }

    public String getStringRepresentation() {
        return representation;
    }

    public int getBit(int i) {
        return (number & (1 << i)) != 0 ? 1 : 0;
    }

    public void setBit(int i) {
        number = number | (1 << i);
        recomputeRepresentation();
    }

    public void clearBit(int i) {
        number = number & ~(1 << i);
        recomputeRepresentation();
    }

    public void clearBitsMsbThroughI(int i) {
        number = number & (1 << (i - 1));
        recomputeRepresentation();
    }

    public void clearBitsIThroughZero(int i) {
        number = number & (-1 << (i + 1));
        recomputeRepresentation();
    }

    public void updateBit(int i, boolean isSet) {
        int val = isSet ? 1 : 0;
        number = (number & ~(1 << i)) | (val << i);
        recomputeRepresentation();
    }

    @Override
    public String toString() {
        return representation;
    }

    private void recomputeRepresentation() {
        StringBuilder sb = new StringBuilder();
        int num = number;
        if (num == 0) {
            this.representation = "0";
            return;
        }
        if (num < 0) {
            int numBits = 0;
            int posNum = num * -1;
            while (Math.pow(2, numBits) < posNum) {
                numBits++;
            }
            num = (int) (Math.pow(2, numBits) - posNum);
            sb.append(1).append("0".repeat(numBits));
            int i = sb.length() - 1;
            while (num > 0) {
                int bit = num % 2;
                num = num / 2;
                sb.setCharAt(i--, Character.forDigit(bit, 10));
            }
            this.representation = sb.toString();
        } else {
            while (num > 0) {
                int bit = num % 2;
                num = num / 2;
                sb.append(bit);
            }
            this.representation = sb.reverse().toString();
        }
    }
}
