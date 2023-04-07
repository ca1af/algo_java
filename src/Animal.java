public interface Animal {
    default void breath() {
        System.out.println("숨쉰다");
    }
}
