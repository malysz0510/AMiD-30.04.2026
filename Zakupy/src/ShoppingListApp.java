import javax.swing.*;

public class ShoppingListApp {

    public JPanel mainPanel;
    private JTextField itemInput;
    private JButton addButton;
    private JList<String> itemsList;
    private JButton deleteButton;

    private DefaultListModel<String> listModel;

    public ShoppingListApp() {
        listModel = new DefaultListModel<>();
        itemsList.setModel(listModel);
        addButton.addActionListener(e -> {
            String text = itemInput.getText();
            if (!text.isEmpty()) {
                listModel.addElement(text);

                itemInput.setText("");
            }
        });

        deleteButton.addActionListener(e -> {
            int index = itemsList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            }
        });
    }
}