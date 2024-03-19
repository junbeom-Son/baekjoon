import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int alphabets[] = new int[26];
        int max = 0, numMax = 1, maxNum = 0;
        String str = sc.next();
        for(int i = 0; i < str.length(); i++){
            char alpha = str.charAt(i);
            switch(alpha){
                case 'a' :
                case 'A' :
                    alphabets[0]++;
                    break;
                case 'b' :
                case 'B' :
                    alphabets[1]++;
                    break;
                case 'c' :
                case 'C' :
                    alphabets[2]++;
                    break;
                case 'd' :
                case 'D' :
                    alphabets[3]++;
                    break;
                case 'e' :
                case 'E' :
                    alphabets[4]++;
                    break;
                case 'f' :
                case 'F' :
                    alphabets[5]++;
                    break;
                case 'g' :
                case 'G' :
                    alphabets[6]++;
                    break;
                case 'h' :
                case 'H' :
                    alphabets[7]++;
                    break;
                case 'i' :
                case 'I' :
                    alphabets[8]++;
                    break;
                case 'j' :
                case 'J' :
                    alphabets[9]++;
                    break;
                case 'k' :
                case 'K' :
                    alphabets[10]++;
                    break;
                case 'l' :
                case 'L' :
                    alphabets[11]++;
                    break;
                case 'm' :
                case 'M' :
                    alphabets[12]++;
                    break;
                case 'n' :
                case 'N' :
                    alphabets[13]++;
                    break;
                case 'o' :
                case 'O' :
                    alphabets[14]++;
                    break;
                case 'p' :
                case 'P' :
                    alphabets[15]++;
                    break;
                case 'q' :
                case 'Q' :
                    alphabets[16]++;
                    break;
                case 'r' :
                case 'R' :
                    alphabets[17]++;
                    break;
                case 's' :
                case 'S' :
                    alphabets[18]++;
                    break;
                case 't' :
                case 'T' :
                    alphabets[19]++;
                    break;
                case 'u' :
                case 'U' :
                    alphabets[20]++;
                    break;
                case 'v' :
                case 'V' :
                    alphabets[21]++;
                    break;
                case 'w' :
                case 'W' :
                    alphabets[22]++;
                    break;
                case 'x' :
                case 'X' :
                    alphabets[23]++;
                    break;
                case 'y' :
                case 'Y' :
                    alphabets[24]++;
                    break;
                case 'z' :
                case 'Z' :
                    alphabets[25]++;
                    break;
            }
        }
        for(int i = 0; i < alphabets.length; i++){
            if(alphabets[i] > max) {
                numMax = 1;
                max = alphabets[i];
                maxNum = i;
            } else if(alphabets[i] == max){
                numMax++;
            }
        }
        if(numMax == 1){
            System.out.println((char)(maxNum + 65));
        } else if(numMax > 1){
            System.out.println("?");
        }
    }
}