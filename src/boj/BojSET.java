package boj;

import java.io.*;
import java.util.*;

public class BojSET {
    public static class BOJ10815_0 {  // 시간 초과
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine()); // 가지고있는 N개의 카드수

            st = new StringTokenizer(br.readLine());

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arrayList.add(Integer.parseInt(st.nextToken())); // ArrayList 에 넣기
            }

            int M = Integer.parseInt(br.readLine()); // 대조군 M개의 카드수

            st = new StringTokenizer(br.readLine());

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < M; i++) {
                int mInteger = Integer.parseInt(st.nextToken());
                if (arrayList.contains(mInteger)) bw.append("1");
                else bw.append("0");

                if (i != M - 1) {
                    bw.append(" ");
                }
            }

            bw.flush();
            br.close();
            bw.close();
        }
    }

    public static class BOJ10815 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine()); // 가지고있는 N개의 카드수

            st = new StringTokenizer(br.readLine());

            boolean[] hasCard = new boolean[10000001]; // 카드 숫자 범위에 따라 배열 크기 설정

            for (int i = 0; i < N; i++) {
                int card = Integer.parseInt(st.nextToken());
                hasCard[card] = true; // 해당 카드의 존재 여부 표시
            }

            int M = Integer.parseInt(br.readLine()); // 대조군 M개의 카드수

            st = new StringTokenizer(br.readLine());

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < M; i++) {
                int mInteger = Integer.parseInt(st.nextToken());
                if (hasCard[mInteger]) bw.append("1");
                else bw.append("0");

                if (i != M - 1) {
                    bw.append(" ");
                }
            }

            bw.flush();
            br.close();
            bw.close();
        }
    }

    public static class BOJ14425 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 주어지는 표본수
            int M = Integer.parseInt(st.nextToken()); // 검사해야 하는 녀석들

            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(br.readLine(), 1);
            }

            int answer = 0;

            for (int i = 0; i < M; i++) {
                if (map.containsKey(br.readLine())) {
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }

    public static class BOJ7785 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 주어지는 로그 수

            HashMap<String, String> map = new HashMap<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String entranceLog = st.nextToken();

                if (entranceLog.equals("enter")) {
                    map.put(name, name);
                } else {
                    map.remove(name);
                }
            }
            ArrayList<String> list = new ArrayList<String>(map.keySet());
            list.sort(Collections.reverseOrder());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < list.size(); i++) {
                bw.append(list.get(i));
                if (i != list.size() - 1) {
                    bw.append("\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();
        }
    }

    public static class BOJ1620 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> map = new HashMap<>();
            String[] names = new String[N + 1];

            for (int i = 1; i <= N; i++) { //1 ~ N 까지 번호의 인덱스로 할당해주기 위함
                String pokemon = br.readLine();
                map.put(pokemon, i);
                names[i] = pokemon;
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < M; i++) {
                String pokemon = br.readLine();
                if (isNumber(pokemon)){ // 숫자로 받았다면
                    bw.append(names[Integer.parseInt(pokemon)]);
                } else {
                    bw.append(String.valueOf(map.get(pokemon)));
                }
                if (i != M - 1){
                    bw.append("\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();
        }

        public static boolean isNumber(String pokemon){
            try {
                Integer.parseInt(pokemon);
                return true;
            } catch (NumberFormatException e){
                return false;
            }
        }
    }
}
