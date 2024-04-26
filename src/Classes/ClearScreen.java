package Classes;

import java.io.Serializable;

public class ClearScreen implements Serializable {
    public static void cs() {
        for(int i=0;i<50;i++)
            System.out.println("");
    }
}
