package Datastructuren.StapelsAfbreken;

public interface StackSmasher {
    void registerMove(int tower, String player);

    int destructHighest();

    int score(String player);

}
