package Calculator;

public class HugeInteger {
    private final int[] number;

    public HugeInteger(String n) {
        this.number = new int[n.length()];

        for (int i = 0, j = number.length - 1; i < number.length; i++, j--) {
            char c = n.charAt(j);

            number[i] = Character.digit(c, 10);
        }
    }

    public HugeInteger(int[] n) {
        this.number = revert(n);
    }
    public HugeInteger minus(HugeInteger other) {
        int[] result = null;
        int[] max = null;
        int[] min = null;
        if(compare(other) == 0){
            result = new int[1];
            result[0] = 0;
            return new HugeInteger(result);
        } else if(compare(other) == 1) {
            max = this.number;
            min = other.number;
        }else{
            max = other.number;
            min = this.number;
        }

        result = new int[max.length];

        int vaiUm = 0;
        for (int i = 0; i < min.length; i++) {
            if ((max[i] - min[i] - vaiUm) < 0) {
                result[i] = (max[i] - min[i] - vaiUm) + 10;
                System.out.println((max[i] + " - " + min[i] + " - " + vaiUm + " = " + result[i]));
                vaiUm = 1;
            } else {
                result[i] = (max[i] - min[i] - vaiUm);
                System.out.println((max[i] + " - " + min[i] + " - " + vaiUm + " = " + result[i]));
                vaiUm = 0;
            }
        }

        for (int i = min.length; i < max.length; i++) {
            if ((max[i] - vaiUm) < 0) {
                result[i] = max[i] - vaiUm + 10;
                System.out.println((max[i] + " - " + vaiUm + " = " + result[i]));
                vaiUm = 1;
            } else {
                result[i] = max[i] - vaiUm;
                System.out.println((max[i] + " - " + vaiUm + " = " + result[i]));
                vaiUm = 0;
            }
        }

        result = revert(result);

        return new HugeInteger(result);
    }

    public int compare(HugeInteger other) {
        if (this.number.length > other.number.length) {
            return 1;
        } else if(this.number.length < other.number.length) {
            return -1;
        }else {
            for(int i = this.number.length-1; i >= 0; i--){
                if(this.number[i] > other.number[i]) {
                    return 1;
                }else if(this.number[i] < other.number[i]){
                    return -1;
                }
            }
            return 0;
        }
    }

    public HugeInteger plus(HugeInteger other) {
        int[] max = null;
        int[] min = null;

        if (this.number.length > other.number.length) {
            max = this.number;
            min = other.number;
        } else {
            max = other.number;
            min = this.number;
        }

        int[] result = new int[max.length + 1];

        int vaiUm = 0;
        for (int i = 0; i < min.length; i++) {
            if ((max[i] + min[i] + vaiUm) >= 10) {
                result[i] = (max[i] + min[i] + vaiUm) - 10;
                vaiUm = 1;
            } else {
                result[i] = (max[i] + min[i] + vaiUm);
                vaiUm = 0;
            }
        }

        for (int i = min.length; i < max.length; i++) {
            if ((max[i] + vaiUm) >= 10) {
                result[i] = max[i] + vaiUm - 10;
                vaiUm = 1;
            } else {
                result[i] = max[i] + vaiUm;
                vaiUm = 0;
            }
        }

        result[result.length - 1] = vaiUm;

        result = revert(result);

        return new HugeInteger(result);
    }

    private int[] revert(int[] array) {
        int[] result = new int[array.length];

        for (int i = 0, j = array.length - 1; i < result.length; i++, j--) {
            result[i] = array[j];
        }

        return result;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();

        int[] copy = revert(number);

        int i = 0;
        if (copy[0] == 0) {
            i = 1;
        }

        for (; i < copy.length; i++) {
            int n = copy[i];
            buffer.append(n);
        }

        return buffer.toString();
    }
}