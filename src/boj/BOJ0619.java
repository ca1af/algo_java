package boj;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ0619 {
    public static class BOJ1966 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken()); // 주어지는 개수 (테스트 케이스의 길이)
                int targetIndex = Integer.parseInt(st.nextToken());

                Queue<Document> queue = new LinkedList<>();
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < count; j++) {
                    int priority = Integer.parseInt(st.nextToken());
                    queue.add(new Document(j, priority));
                }

                int order = 1;
                while (!queue.isEmpty()) {
                    Document doc = queue.poll();
                    boolean hasHighPriority = false;

                    for (Document d : queue) {
                        if (d.priority > doc.priority) {
                            hasHighPriority = true;
                            break;
                        }
                    }

                    if (hasHighPriority) {
                        queue.add(doc);
                    } else {
                        if (doc.index == targetIndex) {
                            System.out.println(order);
                            break;
                        }
                        order++;
                    }
                }
            }
        }

        static class Document {
            int index;
            int priority;

            public Document(int index, int priority) {
                this.index = index;
                this.priority = priority;
            }
        }
    }

}
