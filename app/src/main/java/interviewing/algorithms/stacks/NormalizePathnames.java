package interviewing.algorithms.stacks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NormalizePathnames {

    public static String normalizePathname(String pathname) {
        String[] dirs = pathname.split("/");
        Deque<String> pathDeque = new ArrayDeque<>();
        for (String dir : dirs) {
            if (!dir.matches("\\.") && !dir.matches("\\.\\.")) {
                pathDeque.push(dir);
            } else if (dir.matches("\\.\\.")) {
                while (pathDeque.peek() != null && pathDeque.peek().isEmpty()) {
                    pathDeque.pop();
                }
                pathDeque.pop();
            }
        }
        List<String> out = new ArrayList<>();
        while (!pathDeque.isEmpty()) {
            out.add(pathDeque.pollLast());
        }
        return String.join("/", out);
    }
}
