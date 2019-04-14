//MADE BY DANIEL INGO
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class gui extends JFrame implements ActionListener {
    JButton use;
    JLabel L;

    gui(String title){
        super(title);
        setLayout (new FlowLayout());
        setBounds (50,50, 100, 200);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        L = new JLabel("Label L");
        add(L);
        use = new JButton("USE");
        add(use);

        use.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        ArrayList<Card> deck = new ArrayList<>();
        Card card1 = new Card("What is the capital of GA", "Atlanta");
        Card card2 = new Card("card2", "card2");
        Card card3 = new Card("card3", "card3");


        deck.add(card1);
        deck.add(card3);
        deck.add(card2);

        Card c = new Card();
        Main.useDeck(deck,c);
    }
}









public class Main {
    public static void main(String[] args) {
        ArrayList<Card> deck = new ArrayList<>();
        Card card1 = new Card("What is the capital of GA", "Atlanta");
        Card card2 = new Card("card2", "card2");
        Card card3 = new Card("card3", "card3");


        deck.add(card1);
        deck.add(card3);
        deck.add(card2);

        ArrayList<mathCard> mathDeck = new ArrayList<>();
        mathCard mathCard1 = new mathCard("What is 1+1",2);
        mathDeck.add(mathCard1);


        //Directions
        System.out.println("ENTER \"START\" TO START OR \"STOP\" TO STOP");
      Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.toUpperCase().equals("START")) {

            //MORE DIRECTIONS
            System.out.println("ENTER \"ADD\" TO ADD CARDS TO DECK \n\nENTER \"USE\" TO USE DECK \n\nENTER \"SEARCH\" TO SEARCH DECK FOR A CHARACTER \n\nENTER \"SORT\" TO SORT DECK");

            while (!input.toUpperCase().equals("STOP")) {
                input = sc.nextLine();

                //USE
                if (input.toUpperCase().equals("USE")) {
                    System.out.println("ENTER \"MATH CARD\" TO USE MATH CARD OR ENTER TO USE NORMAL CARD");
                    input = sc.nextLine();
                    if(input.toUpperCase().equals("MATH CARD")){
                        mathCard c = new mathCard();
                        useDeck(mathDeck,c);

                    }
                    else {
                        Card c = new Card();
                        useDeck(deck,c);
                    }

                }


                //ADD
                if (input.toUpperCase().equals("ADD")) {
                    System.out.println("ENTER \"MATH\" TO ADD MATH CARDS OR ENTER TO ADD NORMAL CARD");
                    input = sc.nextLine();
                    if(input.toUpperCase().equals("MATH")){
                        addMathCard(mathDeck);
                    }
                    else {
                        addCard(deck);
                    }
                }

                //Search
                if (input.toUpperCase().equals("SEARCH")) {
                    System.out.println("ENTER THE CHARACTER THAT YOU WOULD LIKE TO SEARCH FOR\n");
                    int fIndex = 0;
                    int bIndex = 0;
                    char searchChar = sc.next().charAt(0);

                    for (int i = 0; i < deck.size(); i++) {
                        Card card = new Card();
                        card = deck.get(i);

                        if (find(card.front, searchChar)) {
                            fIndex++;
                        }
                        if (find(card.back, searchChar)) {
                            bIndex++;
                        }
                    }
                    System.out.println("YOUR SEARCH CHARACTER WAS FOUND " + fIndex + bIndex + " TIMES");

                }

                //SORT
                if (input.toUpperCase().equals("SORT")) {
                    System.out.println("ENTER \"MATH\" TO SORT MATH DECK OR ENTER TO SORT NORMAL DECK");
                    input = sc.nextLine();
                    if (input.toUpperCase().equals("MATH")){
                        Collections.sort(mathDeck);
                        System.out.println("MATH DECK WAS SORTED");
                    }
                    else{
                        Collections.sort(deck);
                        System.out.println("DECK WAS SORTED");
                    }
                }
                }
        }


    }


    //ADD CARDS TO THE DECK
    public static ArrayList<Card> addCard(ArrayList<Card> a){

        boolean userDone = false;
        Scanner sc = new Scanner(System.in);

        while(!userDone){
            System.out.println("Please enter front of card");
            String f = sc.nextLine();
            System.out.println("Please enter back of card");
            String b = sc.nextLine();
            Card card = new Card(f,b);
            a.add(card);
            System.out.println("Enter DONE if you are done adding");
            System.out.println("To add more press enter");
            String stop = sc.nextLine();
            if(stop.toUpperCase().equals("DONE")){
                break;
            }
        }
        return a;
    }
    public static ArrayList<mathCard> addMathCard(ArrayList<mathCard> a){

        boolean userDone = false;
        Scanner sc = new Scanner(System.in);
        String input;
        while(!userDone){
            System.out.println("Please enter front of card");
            String f = sc.nextLine();
            System.out.println("Please enter back of card");
            double b = sc.nextDouble();
            mathCard mathcard = new mathCard(f,b);
            a.add(mathcard);

            System.out.println("Enter DONE if you are done adding");
            System.out.println("To add more press enter");

            input = sc.nextLine();

            if(input.toUpperCase().equals("DONE")){
                userDone = true;
            }
        }
        return a;
    }


    //THIS IS THE SEARCH METHOD
    //IT USES RECURSION :) \(^-^)/
    public static boolean find(String S, char c) {
        if (S == "") {
            return false;
        } else if (S.length() == 1) {
            return (S.charAt(0) == c);
        } else {
            return ((S.charAt(0) == c) || find(S.substring(1), c));
        }
    }



    //USE METHOD
    public static void useDeck(ArrayList<Card> deck, Card c){
        Scanner sc = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < deck.size(); i++) {
            if (deck.size() < 1) {
                System.out.println("No cards in deck");
                break;
            }

            c = deck.get(i);
            c.showFront();
            System.out.println("\nEnter the answer");
            String answer = sc.nextLine();
            if(answer.toUpperCase().equals("STOP")){break;}
            if (answer.toUpperCase().equals(c.getBack().toUpperCase())) {
                System.out.println("Correct!\n");
                count++;
            } else {
                System.out.println("Wrong!\n");
                count++;
            }
            System.out.println(deck.size()-count+" CARDS LEFT IN DECK\n");

            System.out.println("ENTER \"STOP\" TO STOP OR ENTER TO CONTINUE");
            String input = sc.nextLine();
            if(input.toUpperCase().equals("STOP")){break;}
        }
    }
    public static void useDeck(ArrayList<mathCard> deck, mathCard mathCard){
        Scanner sc = new Scanner(System.in);

        int count = 0;
        for (int i = 0; i < deck.size(); i++) {
            if (deck.size() < 1) {
                System.out.println("No cards in deck");
            }

            mathCard = deck.get(i);
            mathCard.showFront();
            System.out.println("\nEnter the answer");
            double answer = sc.nextDouble();

            if (answer == mathCard.getAnswer()) {
                System.out.println("Correct!\n");
                count++;
            } else {
                System.out.println("Wrong!\n");
                count++;
            }
            System.out.println(deck.size()-count+" CARDS LEFT IN DECK\n");
            if(deck.size()-count==0){break;}
            System.out.println("ENTER \"STOP\" TO STOP OR ENTER TO CONTINUE");
            String input = sc.nextLine();
            if(input.toUpperCase().equals("STOP")){break;}

        }
    }


}
