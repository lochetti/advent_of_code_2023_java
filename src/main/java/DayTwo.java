import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwo {

    static final int RED = 12;
    static final int GREEN = 13;
    static final int BLUE = 14;

    static int first(String file_path) throws IOException {

        BufferedReader reader = new FileUtils().getFileAsIOStream(file_path);
        Pattern pattern = Pattern.compile("(\\d+)\\s*green|(\\d+)\\s*red|(\\d+)\\s*blue");
        List<Integer> possibleGames = new ArrayList<>(100);

        String line = reader.readLine();
        int currentLine = 1;
        while (line != null) {
            int maxGreen = 0, maxRed = 0, maxBlue = 0;
            var parts = line.split(";");
            for (String part : parts) {
                Matcher matcher = pattern.matcher(part);

                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        var green = Integer.parseInt(matcher.group(1));
                        if (green > maxGreen) {
                            maxGreen = green;
                        }
                    } else if (matcher.group(2) != null) {
                        var red = Integer.parseInt(matcher.group(2));
                        if (red > maxRed) {
                            maxRed = red;
                        }
                    } else if (matcher.group(3) != null) {
                        var blue = Integer.parseInt(matcher.group(3));
                        if (blue > maxBlue) {
                            maxBlue = blue;
                        }
                    }
                }
            }

            if (maxGreen <= GREEN && maxRed <= RED && maxBlue <= BLUE) {
                possibleGames.add(currentLine);
            }

            currentLine++;
            line = reader.readLine();
        }

        reader.close();

        return possibleGames.stream().reduce(0, Integer::sum);
    }

    static int second(String file_path) throws IOException {

        BufferedReader reader = new FileUtils().getFileAsIOStream(file_path);
        Pattern pattern = Pattern.compile("(\\d+)\\s*green|(\\d+)\\s*red|(\\d+)\\s*blue");
        List<Integer> possibleGames = new ArrayList<>(100);

        String line = reader.readLine();
        while (line != null) {
            int maxGreen = 0, maxRed = 0, maxBlue = 0;
            var parts = line.split(";");
            for (String part : parts) {
                Matcher matcher = pattern.matcher(part);

                while (matcher.find()) {
                    if (matcher.group(1) != null) {
                        var green = Integer.parseInt(matcher.group(1));
                        if (green > maxGreen) {
                            maxGreen = green;
                        }
                    } else if (matcher.group(2) != null) {
                        var red = Integer.parseInt(matcher.group(2));
                        if (red > maxRed) {
                            maxRed = red;
                        }
                    } else if (matcher.group(3) != null) {
                        var blue = Integer.parseInt(matcher.group(3));
                        if (blue > maxBlue) {
                            maxBlue = blue;
                        }
                    }
                }
            }

            possibleGames.add(maxGreen * maxBlue * maxRed);
            line = reader.readLine();
        }

        reader.close();

        return possibleGames.stream().reduce(0, Integer::sum);
    }
}
