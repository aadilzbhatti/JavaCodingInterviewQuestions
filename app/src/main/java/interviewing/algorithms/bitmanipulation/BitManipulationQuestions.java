package interviewing.algorithms.bitmanipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitManipulationQuestions {

    public static void insert(BinaryString m, BinaryString n, int i, int j) {
        assert j - i + 1 == n.getStringRepresentation().length();
        for (int p = j; p >= i; p--) {
            int bit = n.getBit(p - i);
            if (bit == 1) {
                m.setBit(p);
            } else {
                m.clearBit(p);
            }
        }
    }

    public static BinaryString insertWithOps(BinaryString m, BinaryString n, int i, int j) {
        int mask = (-1 << (j + 1)) | ~(-1 << i);
        int num = (m.getNumber() & mask) | (n.getNumber() << i);
        return new BinaryString(num);
    }

    public static String printBinaryRepresentation(double num) throws Exception {
        assert num > 0 && num < 1;
        StringBuilder binary = new StringBuilder();
        binary.append("0").append(".");
        while (num > 0) {
            if (binary.length() >= 32) {
                throw new Exception("Cannot express " + num + " in 32 bits or less");
            }
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static int getLongestSequenceOfOnes(BinaryString binaryString) {
        int num = binaryString.getNumber();
        List<List<Integer>> sequences = new ArrayList<>();
        int currBitVal = -1;
        while (num > 0) {
            int lsb = num & 1;
            if (lsb != currBitVal) {
                currBitVal = lsb;
                sequences.add(Arrays.asList(currBitVal, 1));
            } else {
                List<Integer> pair = sequences.get(sequences.size() - 1);
                int currVal = pair.get(1);
                pair.set(1, currVal + 1);
            }
            num >>= 1;
        }
        int longestSequence = Integer.MIN_VALUE;
        for (int i = 0; i < sequences.size(); i++) {
            List<Integer> pair = sequences.get(i);
            if (pair.get(0) == 0 && pair.get(1) == 1) {
                int sequence = 1;
                if (i > 0) {
                    sequence += sequences.get(i - 1).get(1);
                }
                if (i < sequences.size() - 1) {
                    sequence += sequences.get(i + 1).get(1);
                }
                if (sequence > longestSequence) {
                    longestSequence = sequence;
                }
            } else if (pair.get(0) == 0) {
                if (i > 0) {
                    int sequence = 1;
                    sequence += sequences.get(i - 1).get(1);
                    if (sequence > longestSequence) {
                        longestSequence = sequence;
                    }
                }
                if (i < sequences.size() - 1) {
                    int sequence = 1;
                    sequence += sequences.get(i + 1).get(1);
                    if (sequence > longestSequence) {
                        longestSequence = sequence;
                    }
                }
            }
        }
        return longestSequence;
    }

    public static int[] getPreviousAndNextIntWithSameNumberOfOnes(int num) {
        System.out.println(new BinaryString(num));
        int n1 = num;
        int p = 0;
        boolean foundOne = false;
        while (n1 > 0) {
            if ((n1 & 1) == 0 && foundOne) {
                break;
            }
            if ((n1 & 1) == 1) {
                foundOne = true;
            }
            p++;
            n1 >>= 1;
        }
        int n2 = num;
        n2 |= (1 << p);
        System.out.println("p: " + p);
        System.out.println(new BinaryString(n2));
        int n3 = n2;
        int i = 0;
        int numOnes = 0;
        int numZeros = 0;
        while (i < p) {
            int bit = n3 & 1;
            if (bit == 1) {
                numOnes++;
            } else {
                numZeros++;
            }
            i++;
            n3 >>= 1;
        }
        int mask = -(1 << p);
        n2 &= mask;
        n2 |= (1 << (numOnes - 1)) - 1;
        System.out.println("Next: " + new BinaryString(n2));

        int n4 = num;
        boolean foundZero = false;
        foundOne = false;
        int numTrailingOnes = 0;
        int numZerosLeftOfTrailingOnes = 0;
        while (n4 > 0) {
            if ((n4 & 1) == 1 && foundZero) {
                break;
            }
            if ((n4 & 1) == 1) {
                numTrailingOnes++;
                foundOne = true;
            }
            if ((n4 & 1) == 0 && foundOne) {
                numZerosLeftOfTrailingOnes++;
                foundZero = true;
            }
            n4 >>= 1;
        }
        int n5 = num;
        p = numTrailingOnes + numZeros;
        n5 &= ~(1 << (p - 1));
        System.out.println(new BinaryString(n5));
        System.out.println("NumTrailingOnes: " + numTrailingOnes + ", NumZeros: " + numZerosLeftOfTrailingOnes + ", P: " + p);
        n5 &= ~0 << (p + 1);
        System.out.println("New mask: " + new BinaryString(~0 << (p + 1)));
        System.out.println("N5: " + new BinaryString(n5));
        int a = 1  << (numTrailingOnes + 1);
        System.out.println("a: " + new BinaryString(a));
        int b = a - 1;
        System.out.println("b: " + new BinaryString(b));
        int c = b << (numZerosLeftOfTrailingOnes - 1);
        System.out.println("c: " + new BinaryString(c));

        n5 |= c;
        System.out.println("Previous: " + new BinaryString(n5));

        return new int[] {n5, n2};
    }

    public static int numFlipsRequired(BinaryString a, BinaryString b) {
        int val = a.getNumber() ^ b.getNumber();
        int numFlips = 0;
        while (val != 0) {
            numFlips += val & 1;
            val >>= 1;
        }
        return numFlips;
    }
}
