package Day3;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Part 1: Number of Trees: " + part1(treeMap, new Point(3,1)));
        System.out.println("Part 2: Total Multiplied Number of Trees: " + part2(treeMap));
    }

    static char[][] treeMap;
    static int width;

    static {
        try {
            treeMap =  Files.readAllLines(Paths.get("src/Day3/trees.txt"))
                    .stream()
                    .map(e -> e.toCharArray())
                    .toArray(char[][]::new);
            width = treeMap[0].length;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    static int part1(char[][] treeMap, Point move) {
        int cnt = 0;
        Point cur = new Point(0,0);
        while (cur.y < treeMap.length) {
            if (treeMap[cur.y][cur.x] == '#') {
                cnt++;
            }
            cur.translate(move.x,move.y);
            cur.x = cur.x % width;
        }
        return cnt;
    }

    static long part2(char[][] treeMap) {
        List<Point> movements = new ArrayList<>();
        movements.add(new Point(1,1));
        movements.add(new Point(3,1));
        movements.add(new Point(5,1));
        movements.add(new Point(7,1));
        movements.add(new Point(1,2));

        long result = 1L;
        for(Point p : movements) {
            result = result * part1(treeMap, p);
        }
        return result;
    }
}
