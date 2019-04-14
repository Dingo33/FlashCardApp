//MADE BY DANIEL INGO
public class Card implements Comparable<Card>{
    String front;
    String back;

    public Card() {
        this.front = "";
        this.back = "";
    }

    public Card(String front, String back){
        this.front = front;
        this.back = back;
    }


    public void editFront(String front) {
        this.front = front;
    }

    public void editBack(String back) {
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public void reverse(){
        String temp = this.back;
        String temp1 = this.front;
        setFront(temp);
        setBack(temp1);
    }

    public void showFront(){
        System.out.println(front);
    }
    public void showBack(){
        System.out.println(back);
    }

    public String toString(){
        return "Front = "+front+", Back = "+back;
    }

    public int compareTo(Card c){
        int frontComp =front.compareTo(c.front);

        if (frontComp==0){
            return back.compareTo(c.back);
        }
        return frontComp;
    }
}
