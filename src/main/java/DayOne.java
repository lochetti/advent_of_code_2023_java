import com.google.common.collect.Streams;
import models.Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

public class DayOne {

    static int first(String file_path) throws IOException {

        BufferedReader reader = new FileUtils().getFileAsIOStream(file_path);

        int result = 0;
        String line = reader.readLine();
        while (line != null) {
            var first = line.chars().filter(v -> v >= 48 && v <= 57).findFirst();
            var reversedLine = new StringBuffer(line).reverse().toString();
            var last = reversedLine.chars().filter(v -> v >= 48 && v <= 57).findFirst();
            result += ((first.orElseThrow() - 48) * 10 + (last.orElseThrow() - 48));

            line = reader.readLine();
        }

        reader.close();

        return result;
    }

    static int second(String file_path) throws IOException {

        BufferedReader reader = new FileUtils().getFileAsIOStream(file_path);

        int result = 0;

        String line = reader.readLine();
        while (line != null) {
            var first = findNumberInLine(line, false);
            var reversedLine = new StringBuffer(line).reverse().toString();
            var last = findNumberInLine(reversedLine, true);
            result += (first * 10 + last);

            line = reader.readLine();
        }

        reader.close();
        return result;
    }

    static int findNumberInLine(String line, boolean reversed) {
        Stream<String> stream;
        if (reversed) {
            stream = Stream.of("eno", "owt", "eerht", "ruof", "evif", "xis", "neves", "thgie", "enin");

        } else {
            stream = Stream.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        }
        var indexOfStrNumbers = Streams.mapWithIndex(stream, (s, index) -> new Tuple<>(line.indexOf(s), (int) index + 1)).collect(ArrayList<Tuple<Integer, Integer>>::new, ArrayList::add, ArrayList::addAll);

        var indexOfNumbers = Streams.mapWithIndex(line.chars(), (c, index) -> new Tuple<>((int) index, c - 48)).filter(v -> v.second() >= 0 && v.second() <= 9).findFirst().orElse(new Tuple<>(-1, 0));

        indexOfStrNumbers.add(indexOfNumbers);

        return indexOfStrNumbers.stream().filter(o -> o.first() >= 0).min(new TupleComparator()).map(Tuple::second).orElse(-1);
    }

    static class TupleComparator implements Comparator<Tuple<Integer, Integer>> {

        @Override
        public int compare(Tuple<Integer, Integer> o1, Tuple<Integer, Integer> o2) {
            return o1.first() - o2.first();
        }
    }
}
