package sockets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChatClientUI {

    JFrame window;

    public ChatClientUI() {

        window = new JFrame("Chat Client: ");
        window.setMinimumSize(new Dimension(400, 400));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container content = window.getContentPane();
        content.setLayout(new GridBagLayout());

        // UI elements are located here
        createUI();

        window.pack();
        window.setVisible(true);
    }

    private void createUI() {
        JTextField serverAddress = new JTextField();
        addComponent(serverAddress, 0, 0, 2, 1, 0f, 0f );

        JButton connect = new JButton("Connect");
        addComponent(connect, 0, 1, 2, 1 , 0f, 0f);
        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Connect Pressed with " + serverAddress.getText());
            }
        });

        JList chatHistory = new JList();
        addComponent(chatHistory, 0, 2, 2, 1, 1f, 1f);

        JTextField chatBox = new JTextField();
        addComponent(chatBox, 0, 3, 1, 1, 1f, 0f);

        JButton sendButton = new JButton("Full Send");
        sendButton.setBackground(Color.BLUE);
        addComponent(sendButton, 1, 3, 1, 1, 0f, 0f);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Full Send" + chatBox.getText());
            }
        });
    }

    private <C extends Component> C addComponent(
            C component,
            int gridX,
            int gridY,
            int gridWidth,
            int gridHeight,
            float weightX,
            float weightY) {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.gridwidth = gridWidth;
        constraints.gridheight = gridHeight;
        constraints.weightx = weightX;
        constraints.weighty = weightY;

        window.getContentPane().add(component, constraints);

        return component;

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChatClientUI client = new ChatClientUI();
            }
        });
    }

}
