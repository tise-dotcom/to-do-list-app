import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ToDoListApp {
    private AppControls controller;
    private String title = "To Do List App";

    JFrame frame = new JFrame();
    JPanel displayPanel = new JPanel();
    JScrollPane scrollPane = new JScrollPane(displayPanel);
    CardLayout cardLayout = new CardLayout();
    JPanel bottomPanel = new JPanel(cardLayout);
    JPanel inputCard = new JPanel();
    JPanel buttonCard = new JPanel();
    JTextField textField = new JTextField();
    JButton taskButton = new JButton();
    JButton saveButton = new JButton();
    JButton cancelButton = new JButton();
    

    public ToDoListApp(){

            
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 540);
        frame.setTitle(title);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());

        bottomPanel.add(buttonCard, "BUTTON_STATE");
        bottomPanel.add(inputCard, "INPUT_STATE");

        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        displayPanel.setBackground(Color.LIGHT_GRAY);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        taskButton.setText("Add Task");
        taskButton.setBackground(Color.BLUE);
        taskButton.setForeground(Color.white);
        taskButton.setFont(new Font("Arial", Font.PLAIN, 30));
        taskButton.setFocusable(false);

        buttonCard.add(taskButton);
        buttonCard.setBackground(Color.LIGHT_GRAY);

        inputCard.setLayout(new BoxLayout(inputCard, BoxLayout.X_AXIS));
        inputCard.setBackground(Color.LIGHT_GRAY);

        saveButton.setText("Save");
        saveButton.setBackground(Color.GREEN);
        saveButton.setForeground(Color.white);
        saveButton.setFont(new Font("Arial", Font.PLAIN, 30));
        saveButton.setFocusable(false);

        cancelButton.setText("Cancel");
        cancelButton.setBackground(Color.DARK_GRAY);
        cancelButton.setForeground(Color.white);
        cancelButton.setFont(new Font("Arial", Font.PLAIN, 30));
        cancelButton.setFocusable(false);

        inputCard.add(textField);
        inputCard.add(saveButton);
        inputCard.add(cancelButton);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        taskButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                cardLayout.show(bottomPanel, "INPUT_STATE");
            };
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                textField.setText(" ");
                cardLayout.show(bottomPanel, "BUTTON_STATE");

            };
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String taskText = textField.getText();
                if (taskText != null) {
                    controller.processNewTask(taskText);
                }

                textField.setText(" ");
                cardLayout.show(bottomPanel, "BUTTON_STATE");

            };
        });



   
    }


    public void addTask(String taskText) {
    
        JPanel taskPanel = new JPanel();
        JLabel taskName = new JLabel(taskText);
        JCheckBox checkBox = new JCheckBox();
        JButton deleteButton = new JButton();

        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.X_AXIS));
        taskPanel.setBackground(Color.LIGHT_GRAY);
        taskPanel.setVisible(true);
            
        taskName.setForeground(Color.black);
        taskName.setFont(new Font("Arial", Font.PLAIN, 30));
        
            
        deleteButton.setText("Delete");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.black);
        deleteButton.setFont(new Font("Arial",Font.PLAIN,30));
        deleteButton.setFocusable(false);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    taskName.setText("<html><s>"+taskText+"</s></html>");
                } else {
                    taskName.setText(taskText);
                }
            }
        } );

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayPanel.remove(taskPanel);
                displayPanel.revalidate();
                displayPanel.repaint();
            }
        } );

        taskPanel.add(taskName);
        taskPanel.add(checkBox);
        taskPanel.add(deleteButton);

        displayPanel.add(taskPanel);
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    public void displayWindow() {
        frame.setVisible(true);
    }

    public void setController(AppControls controller) {
        this.controller = controller;
    }

}
