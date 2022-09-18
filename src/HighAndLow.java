import java.util.Arrays;

public class HighAndLow{
    public static void main(String[] args) {
        int[] deck = {1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13};
        shuffleDeck(deck);
        System.out.println(Arrays.toString(deck));
    }
    public static void shuffleDeck(int[] deck){
        for (int i = deck.length-1; i > 1; i--) {
            int j = new java.util.Random().nextInt(i+1);
            int tmp = deck[i];
            deck[i]=deck[j];
            deck[j]=tmp;
        }
    }
}