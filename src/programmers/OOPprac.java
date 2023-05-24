package programmers;

public class OOPprac {
    /** 캡슐화 예제 **/
    private static class Bank{
        private int balacne;

        public int deposit(int deposit){
            this.balacne += deposit;
            return balacne;
        }

        public int withdraw(int withdraw){
            if (balacne - withdraw < 0){
                throw new IllegalArgumentException("잔액 부족");
            }
            this.balacne -= withdraw;
            return balacne;
        }
    }
}
