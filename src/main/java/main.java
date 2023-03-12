import Models.*;
import Views.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.Scanner;

public class main {
    public static Scanner input = new Scanner(System.in);
    public static BookRepostory br = new BookRepostory(true);
    public static void main(String[] args) {

        HomeView homeView = new HomeView();
        //homeView.showHome();



    }


}
