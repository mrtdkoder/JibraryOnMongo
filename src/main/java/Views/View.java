package Views;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class View {

    public  String  title;


    public void titleBar() {
        titleBar(this.title, 0);
    }
    public void titleBar(int alignment) {
        titleBar(this.title, alignment);
    }

    public void titleBar(String caption, int alignment) {
        if (caption == null) {caption = "";}
        int tLen = caption.length();
        String s = "";
        caption = ((tLen%2==0) ? " " : "") + caption;
        switch (alignment){
            case 1 -> {
                s = "# " + caption + " " + "#".repeat(80-tLen-3);
            }
            case 0 -> {
                s = "#".repeat(39-(tLen/2)) + " " + caption + " " + "#".repeat(38-(tLen/2));
            }
            case -1 -> {
                s = "#".repeat(80-tLen-3) + " " + caption + " #";
            }
        }
        System.out.println(s);
    }

    public void buttomBar() {
        System.out.println("#".repeat(80));
    }

    public String readString(String prompt) {
        Scanner input = new Scanner(System.in);
        System.out.print(prompt);
        return input.nextLine();
    }

    public int readInt(String prompt) {
        return readInt(prompt,0,true);
    }
    public int readInt(String prompt, int defaultValue, boolean force) {
        Scanner input = new Scanner(System.in);
        int r; boolean _ok = true;
        do {
        try {
            System.out.print(prompt); _ok = true;
            r = Integer.valueOf(input.nextLine());
        } catch (Exception e) {
            _ok = !force; prompt= ">" + prompt;
            r = defaultValue;
        }
        } while (!_ok);
        return r;
    }

    public double readDouble(String prompt) {
        return readDouble(prompt,0, false);
    }
    public double readDouble(String prompt, double defaultValue, boolean force) {
        Scanner input = new Scanner(System.in);
        double r=0; boolean _ok = true;
        do {
            try {
                System.out.print(prompt); _ok = true;
                r = Double.valueOf(input.nextDouble());
            } catch (Exception e) {
                _ok = !force; prompt= ">" + prompt;
                r = defaultValue;
            }
        } while (!_ok);
        return r;
    }

    public Date readDate(String prompt) {
       return readDate(prompt,new Date(),true);
    }
    public Date readDate(String prompt, Date defaultValue, boolean force) {
        Scanner input = new Scanner(System.in);
        Date r; boolean _ok = true;
        do {
        try {
            System.out.print(prompt); _ok = true;
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy"); //yyyy-MM-dd
            r = sdf.parse(input.nextLine());
        } catch (Exception e) {
            _ok = !force; prompt= ">" + prompt;
            r = defaultValue;
        }
        } while (!_ok);
        return r;
    }




}
