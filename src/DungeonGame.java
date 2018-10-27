import java.io.*;

public class DungeonGame implements Serializable {
    public int x = 3;
    transient long y = 4;
    private short z = 5;

    int getx () {
        return x;
    }

    short getz () {
        return z;
    }

    long gety () {
        return y;
    }
}

class DungeonTest {
    public static void main(String[] args) {
        DungeonGame d = new DungeonGame();

        try{
            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            System.out.println(d.getx()+ d.getz()+d.gety());
            oos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

        try{
            FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (DungeonGame) ois.readObject();
            System.out.println(d.getx()+ d.getz()+d.gety());
            ois.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
