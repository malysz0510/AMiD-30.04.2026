import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List");
        frame.setContentPane(new TodoListApp().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}