import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayThree {

    static int first(String filePath) throws IOException {
        BufferedReader reader = new FileUtils().getFileAsIOStream(filePath);
        List<char[]> data = new ArrayList<>();
        reader.lines().forEach(s -> data.add(s.toCharArray()));

        int result = 0;
        for (int i = 1; i < data.size() - 1; i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                if (isSymbol(data.get(i)[j])) {
                    result += sumOfAdjacentNumbersToSymbol(data, i, j);
                }
            }
        }

        return result;
    }

    static boolean isSymbol(char c) {
        return (c >= 33 && c <= 47 && c != 46) || c == 61 || c == 64;
    }

    static int sumOfAdjacentNumbersToSymbol(List<char[]> data, int i, int j) {
        int sum = 0;

        //up
        char[] line = data.get(i - 1);
        if (isNumber(line[j - 1]) && isNumber(data.get(i - 1)[j]) && isNumber(data.get(i - 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i - 1), j - 1, j + 1);
        } else if (isNumber(data.get(i - 1)[j - 1]) && isNumber(data.get(i - 1)[j]) && !isNumber(data.get(i - 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i - 1), j - 2, j);
        } else if (isNumber(data.get(i - 1)[j - 1]) && !isNumber(data.get(i - 1)[j]) && !isNumber(data.get(i - 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i - 1), j - 3, j - 1);
        } else if (isNumber(data.get(i - 1)[j - 1]) && !isNumber(data.get(i - 1)[j]) && isNumber(data.get(i - 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i - 1), j - 3, j + 3);
        } else if (!isNumber(data.get(i - 1)[j - 1]) && isNumber(data.get(i - 1)[j]) && isNumber(data.get(i - 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i - 1), j, j + 2);
        } else if (!isNumber(data.get(i - 1)[j - 1]) && !isNumber(data.get(i - 1)[j]) && isNumber(data.get(i - 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i - 1), j + 1, j + 3);
        } else if (!isNumber(data.get(i - 1)[j - 1]) && isNumber(data.get(i - 1)[j]) && !isNumber(data.get(i - 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i - 1), j, j);
        }

        //down
        if (isNumber(data.get(i + 1)[j - 1]) && isNumber(data.get(i + 1)[j]) && isNumber(data.get(i + 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i + 1), j - 1, j + 1);
        } else if (isNumber(data.get(i + 1)[j - 1]) && isNumber(data.get(i + 1)[j]) && !isNumber(data.get(i + 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i + 1), j - 2, j);
        } else if (isNumber(data.get(i + 1)[j - 1]) && !isNumber(data.get(i + 1)[j]) && !isNumber(data.get(i + 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i + 1), j - 3, j - 1);
        } else if (isNumber(data.get(i + 1)[j - 1]) && !isNumber(data.get(i + 1)[j]) && isNumber(data.get(i + 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i + 1), j - 3, j + 3);
        } else if (!isNumber(data.get(i + 1)[j - 1]) && isNumber(data.get(i + 1)[j]) && isNumber(data.get(i + 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i + 1), j, j + 2);
        } else if (!isNumber(data.get(i + 1)[j - 1]) && !isNumber(data.get(i + 1)[j]) && isNumber(data.get(i + 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i + 1), j + 1, j + 3);
        } else if (!isNumber(data.get(i + 1)[j - 1]) && isNumber(data.get(i + 1)[j]) && !isNumber(data.get(i + 1)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i + 1), j, j);
        }

        //left
        if (isNumber(data.get(i)[j - 1])) {
            sum += sumOfNumbersInSequence(data.get(i), j - 3, j - 1);
        }

        //right
        if (isNumber(data.get(i)[j + 1])) {
            sum += sumOfNumbersInSequence(data.get(i), j + 1, j + 3);
        }

        return sum;
    }

    static int sumOfNumbersInSequence(char[] line, int begin, int end) {
        int totalSum = 0;
        int partialSum = 0;
        for (int x = begin; x <= end; x++) {
            if (isNumber(line[x])) {
                partialSum = partialSum * 10 + (line[x] - 48);
            } else {
                totalSum += partialSum;
                partialSum = 0;
            }
        }

        if (partialSum > 0) {
            totalSum += partialSum;
        }

        return totalSum;
    }

    static boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    static int second(String filePath) throws IOException {
        BufferedReader reader = new FileUtils().getFileAsIOStream(filePath);
        List<char[]> data = new ArrayList<>();
        reader.lines().forEach(s -> data.add(s.toCharArray()));

        int result = 0;
        for (int i = 1; i < data.size() - 1; i++) {
            for (int j = 0; j < data.get(i).length; j++) {
                if (isAsterisk(data.get(i)[j])) {
                    result += gearRatio(data, i, j);
                }
            }
        }

        return result;
    }

    static boolean isAsterisk(char c) {
        return c == '*';
    }

    static int gearRatio(List<char[]> data, int i, int j) {
        var gearParts = new ArrayList<Integer>();

        //up
        char[] line = data.get(i - 1);
        if (isNumber(line[j - 1]) && isNumber(data.get(i - 1)[j]) && isNumber(data.get(i - 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i - 1), j - 1, j + 1));
        } else if (isNumber(data.get(i - 1)[j - 1]) && isNumber(data.get(i - 1)[j]) && !isNumber(data.get(i - 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i - 1), j - 2, j));
        } else if (isNumber(data.get(i - 1)[j - 1]) && !isNumber(data.get(i - 1)[j]) && !isNumber(data.get(i - 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i - 1), j - 3, j - 1));
        } else if (isNumber(data.get(i - 1)[j - 1]) && !isNumber(data.get(i - 1)[j]) && isNumber(data.get(i - 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i - 1), j - 3, j + 3));
        } else if (!isNumber(data.get(i - 1)[j - 1]) && isNumber(data.get(i - 1)[j]) && isNumber(data.get(i - 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i - 1), j, j + 2));
        } else if (!isNumber(data.get(i - 1)[j - 1]) && !isNumber(data.get(i - 1)[j]) && isNumber(data.get(i - 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i - 1), j + 1, j + 3));
        } else if (!isNumber(data.get(i - 1)[j - 1]) && isNumber(data.get(i - 1)[j]) && !isNumber(data.get(i - 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i - 1), j, j));
        }

        //down
        if (isNumber(data.get(i + 1)[j - 1]) && isNumber(data.get(i + 1)[j]) && isNumber(data.get(i + 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i + 1), j - 1, j + 1));
        } else if (isNumber(data.get(i + 1)[j - 1]) && isNumber(data.get(i + 1)[j]) && !isNumber(data.get(i + 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i + 1), j - 2, j));
        } else if (isNumber(data.get(i + 1)[j - 1]) && !isNumber(data.get(i + 1)[j]) && !isNumber(data.get(i + 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i + 1), j - 3, j - 1));
        } else if (isNumber(data.get(i + 1)[j - 1]) && !isNumber(data.get(i + 1)[j]) && isNumber(data.get(i + 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i + 1), j - 3, j + 3));
        } else if (!isNumber(data.get(i + 1)[j - 1]) && isNumber(data.get(i + 1)[j]) && isNumber(data.get(i + 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i + 1), j, j + 2));
        } else if (!isNumber(data.get(i + 1)[j - 1]) && !isNumber(data.get(i + 1)[j]) && isNumber(data.get(i + 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i + 1), j + 1, j + 3));
        } else if (!isNumber(data.get(i + 1)[j - 1]) && isNumber(data.get(i + 1)[j]) && !isNumber(data.get(i + 1)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i + 1), j, j));
        }

        //left
        if (isNumber(data.get(i)[j - 1])) {
            gearParts.addAll(listGearParts(data.get(i), j - 3, j - 1));
        }

        //right
        if (isNumber(data.get(i)[j + 1])) {
            gearParts.addAll(listGearParts(data.get(i), j + 1, j + 3));
        }

        if (gearParts.size() == 2) {
            return gearParts.getFirst() * gearParts.getLast();
        } else {
            return 0;
        }
    }

    static List<Integer> listGearParts(char[] line, int begin, int end) {
        var result = new ArrayList<Integer>();
        int partialSum = 0;
        for (int x = begin; x <= end; x++) {
            if (isNumber(line[x])) {
                partialSum = partialSum * 10 + (line[x] - 48);
            } else if (partialSum > 0) {
                result.add(partialSum);
                partialSum = 0;
            }
        }

        if (partialSum > 0) {
            result.add(partialSum);
        }

        return result;
    }
}
