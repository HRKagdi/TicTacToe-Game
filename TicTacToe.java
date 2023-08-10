import java.util.*;
class Player{
    String name;
    char symbol;
    public Player(String name,char symbol){
        this.name=name;
        this.symbol=symbol;
    }
}
class Board{
    private static char board[][]=new char[3][3];
    public Board(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';
            }
        }
    }
    public static void setCoordinates(int x,int y,char symbol){
        board[x][y]=symbol;
        return;
    }
    public static char getCoordinates(int x,int y){
        return board[x][y];
    }
}
class TicTacToe{
    private static Player p1,p2;
    private static Board b;
    public TicTacToe(String name1,char symbol1,String name2,char symbol2){
        p1=new Player(name1,symbol1);
        p2=new Player(name2,symbol2);
        b=new Board();
    }
    private static void printBoard(){
        System.out.println("---------------");
        System.out.println("| "+b.getCoordinates(0,0)+" || "+b.getCoordinates(0,1)+" || "+b.getCoordinates(0,2)+" |");
        System.out.println("| "+b.getCoordinates(1,0)+" || "+b.getCoordinates(1,1)+" || "+b.getCoordinates(1,2)+" |");
        System.out.println("| "+b.getCoordinates(2,0)+" || "+b.getCoordinates(2,1)+" || "+b.getCoordinates(2,2)+" |");
        System.out.println("---------------");
    }
    private static void makeMove(String name,char symbol){
        while(true){
            System.out.println("Enter the coordinates of your move "+name+":");
            Scanner sc=new Scanner(System.in);
            int x=sc.nextInt(); int y=sc.nextInt();
            if(x<0 || y<0 || x>=3 || y>=3 || b.getCoordinates(x,y)!=' '){
                System.out.println("Invalid coordinates!! Please Enter valid coordinates");
                continue;
            }
            else{
                b.setCoordinates(x,y,symbol);
                break;
            }
        }
    }
    private static boolean canTerminate(){
        if(b.getCoordinates(0,0)!=' ' && b.getCoordinates(0,0)==b.getCoordinates(0,1) && b.getCoordinates(0,1)==b.getCoordinates(0,2)){
            return true;
        }
        if(b.getCoordinates(1,0)!=' ' && b.getCoordinates(1,0)==b.getCoordinates(1,1) && b.getCoordinates(1,1)==b.getCoordinates(1,2)){
            return true;
        }
        if(b.getCoordinates(2,0)!=' ' && b.getCoordinates(2,0)==b.getCoordinates(2,1) && b.getCoordinates(2,1)==b.getCoordinates(2,2)){
            return true;
        }
        if(b.getCoordinates(0,0)!=' ' && b.getCoordinates(0,0)==b.getCoordinates(1,0) && b.getCoordinates(1,0)==b.getCoordinates(2,0)){
            return true;
        }
        if(b.getCoordinates(0,1)!=' ' && b.getCoordinates(0,1)==b.getCoordinates(1,1) && b.getCoordinates(1,1)==b.getCoordinates(2,1)){
            return true;
        }
        if(b.getCoordinates(0,2)!=' ' && b.getCoordinates(0,2)==b.getCoordinates(1,2) && b.getCoordinates(1,2)==b.getCoordinates(2,2)){
            return true;
        }
        if(b.getCoordinates(0,0)!=' ' && b.getCoordinates(0,0)==b.getCoordinates(1,1) && b.getCoordinates(1,1)==b.getCoordinates(2,2)){
            return true;
        }
        if(b.getCoordinates(0,2)!=' ' && b.getCoordinates(0,2)==b.getCoordinates(1,1) && b.getCoordinates(1,1)==b.getCoordinates(2,0)){
            return true;
        }
        return false;
    }
    public static void simulate(){
        boolean chance=true;
        for(int i=1;i<=9;i++){
            if(chance){
                makeMove(p1.name,p1.symbol);
            }
            else{
                makeMove(p2.name,p2.symbol);
            }
            printBoard();
            chance=!chance;
            if(canTerminate()){
                if(chance) {
                    System.out.println("Player 2 wins : "+p2.name);
                }
                else{
                    System.out.println("Player 1 wins : "+p1.name);
                }
                return;
            }

        }
        System.out.println("The game was a tie!!");
    }
}
public class MyClass {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to HRK's TicTacToe Game!!");
        System.out.println("Enter player1's name and symbol");
        String name1=sc.next(); char symbol1=sc.next().charAt(0);
        System.out.println("Enter player2's name and symbol");
        String name2=sc.next(); char symbol2=sc.next().charAt(0);
        TicTacToe game = new TicTacToe(name1,symbol1,name2,symbol2);
        game.simulate();
    }
}
