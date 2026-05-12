import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TodoListApp {

    public JPanel mainPanel;

    private JTextField taskInput;
    private JButton addButton;
    private JList<String> taskList;
    private JButton deleteButton;
    private JLabel counterLabel;

    private DefaultListModel<String> listModel;

    public TodoListApp() {
        listModel = new DefaultListModel<>();

        taskList.setModel(listModel);

        addButton.addActionListener(e -> {

            String task = taskInput.getText().trim();
            if (task.isEmpty()) {

                JOptionPane.showMessageDialog(
                        null,
                        "Zadanie nie może być puste"
                );
            } else {

                listModel.addElement(task);

                taskInput.setText("");

                updateCounter();
            }
        });
        deleteButton.addActionListener(e -> {

            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
                updateCounter();
            }
        });

        taskList.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = taskList.locationToIndex(e.getPoint());
                    if (index != -1) {
                        listModel.remove(index);

                        updateCounter();
                    }
                }
            }
        });
    }

    private void updateCounter() {
        counterLabel.setText(
                "Liczba zadań: " + listModel.getSize()
        );
    }
}