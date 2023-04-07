import java.util.Arrays;

public class Sol0407 {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int i = 0; i < sizes.length; i++) {
            int w = sizes[i][0];
            int h = sizes[i][1];

            if (w < h) {
                // 무조건 더 큰놈이 가로가 되게
                int temp = w;
                w = h;
                h = temp;
            }
            if (w > maxW) {
                maxW = w;
            }
            if (h > maxH) {
                maxH = h;
            }
        }

        return maxW * maxH;
    }

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }


}
