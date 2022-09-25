import javax.swing.*;

public class Main {

    checkData check;
    static Main starter;
    ConnectDB connectDB;
    public static void main(String[] args) {
        starter = new Main();
        starter.run();
    }

    public void run() {
        JFrame JFrame = new LoginGui("Login");
        LoginGui gui = new LoginGui();

        check = gui.getCheck();
        connectDB = new ConnectDB();
        connectDB.connect();

    }

    public void dataCheck (checkData check) {
        for (int i = 0; i < connectDB.usersList.size(); i++) {
            if (check.getLogin().equals(connectDB.usersList.get(i)) || check.getPassword().equals(connectDB.passwordList.get(i))) {
                System.out.println("Correct data");
                return;
            }
        }
        System.out.println("Incorrect data");
    }
}