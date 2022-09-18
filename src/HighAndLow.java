import java.util.Arrays;
import java.util.Scanner;

public class HighAndLow{
    public static void main(String[] args) {
        int[] deck = {1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13,1,2,3,4,5,6,7,8,9,10,11,12,13};
        shuffleDeck(deck);
        System.out.println(Arrays.toString(deck));
        
        int[] playerHand=Arrays.copyOfRange(deck, 0, deck.length/2);
        int[] cpuHand=Arrays.copyOfRange(deck, deck.length/2, deck.length);
        
        //0ならlow,それ以外はhigh
        int playerSelect=0;
        int cpuSelect=0;  

        int playerScore=0;
        int cpuScore=0;

        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < playerHand.length; i+=2) {
            //ゲームループ
            System.out.println("あなたが親です");
            System.out.println("あなたは"+convertToTrumpChar(playerHand[i])+"を出しました。");
            System.out.println("cpuはカードを出しました");
            if(Math.random()>0.5){
                System.out.println("cpuはhighを選択しました");
                cpuSelect=1;
            }else{
                System.out.println("cpuはlowを選択しました");
                cpuSelect=0;
            }
            System.out.println("cpuは"+convertToTrumpChar(cpuHand[i])+"でした");
            if((cpuSelect>0&&playerHand[i]<cpuHand[i])||(cpuSelect==0&&playerHand[i]>cpuHand[i])){
                System.out.println("よってcpuの勝ちです");
                System.out.println("cpuは1ポイント獲得しました");
                cpuScore++;
            }else{
                System.out.println("よってあなたの勝ちです");
                System.out.println("あなたは1ポイント獲得しました");
                playerScore++;
            }

            i++;
            System.out.println("-----");

            System.out.println("あなたが子です");
            System.out.println("cpuは"+convertToTrumpChar(cpuHand[i])+"を出しました。");
            System.out.println("あなたはカードを出しました");
            System.out.println("選択してください: high=0以外 low=0");
            System.out.print(">");
            playerSelect=scan.nextInt();

            System.out.println("あなたは"+(playerSelect==0?"low":"high")+"を選択しました");

            System.out.println("あなたは"+convertToTrumpChar(playerHand[i])+"でした");
            if((playerSelect>0&&playerHand[i]>cpuHand[i])||(playerSelect==0&&playerHand[i]<cpuHand[i])){
                System.out.println("よってあなたの勝ちです");
                System.out.println("あなたは1ポイント獲得しました");
                playerScore++;
            }else{
                System.out.println("よってcpuの勝ちです");
                System.out.println("cpuは1ポイント獲得しました");
                cpuScore++;
            }
            System.out.println("-----");
        }
        scan.close();
        System.out.println("終了！");
        System.out.println("あなた:"+playerScore+"ポイント");
        System.out.println("cpu:"+cpuScore+"ポイント");
        System.out.println("よって"+(playerScore>cpuScore?"あなた":"cpu")+"の勝利！");

    }
    public static void shuffleDeck(int[] deck){
        for (int i = deck.length-1; i > 1; i--) {
            int j = new java.util.Random().nextInt(i+1);
            int tmp = deck[i];
            deck[i]=deck[j];
            deck[j]=tmp;
        }
    }
    public static String convertToTrumpChar(int num){
        switch (num) {
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
        }
        return num+"";
    }
}