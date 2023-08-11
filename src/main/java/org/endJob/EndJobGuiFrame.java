package org.endJob;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static org.endJob.Main.*;


public class EndJobGuiFrame extends JFrame {
    public EndJobGuiFrame() {
        setTitle("퇴근체크");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container contentPane = getContentPane();

        contentPane.setLayout(null);
        JLabel IdLabel = new JLabel("ID");
        JLabel PasswordLabel = new JLabel("PW");
        JTextField IdField = new JTextField(15);
        JPasswordField PassswordField = new JPasswordField(15);
        JButton EndJobButton = new JButton("퇴근체크");
        JButton EndJobTestButton = new JButton("퇴근체크 테스트");

        IdLabel.setLocation(60,20);
        IdLabel.setSize(20,20);
        this.add(IdLabel);
        IdField.setLocation(90,20);
        IdField.setSize(150,20);
        this.add(IdField);
        PasswordLabel.setLocation(60,50);
        PasswordLabel.setSize(20,20);
        this.add(PasswordLabel);
        PassswordField.setLocation(90,50);
        PassswordField.setSize(150,20);
        this.add(PassswordField);
        EndJobTestButton.setLocation(20,100);
        EndJobTestButton.setSize(130,80);
        this.add(EndJobTestButton);
        EndJobButton.setLocation(180,100);
        EndJobButton.setSize(130,80);
        this.add(EndJobButton);

        setSize(330,250);
        setVisible(true);

        ActionListener endJobTestButtonlistener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent endJobTestButtonActionEvent) {
                if(endJobTestButtonActionEvent.getSource()
                        == EndJobTestButton) {
                    String my_id = IdField.getText();
                    String my_pwd = PassswordField.getText();
                    try {
                        endJobTest(my_id, my_pwd);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        ActionListener endJobButtonlistener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent endJobTestButtonActionEvent) {
                if(endJobTestButtonActionEvent.getSource() == EndJobButton) {
                    String my_id = IdField.getText();
                    String my_pwd = PassswordField.getText();
                    try {
                        endJobCheck();
                        endJob(my_id, my_pwd);
                    } catch (InterruptedException e) {
                        throw new
                                RuntimeException(e);
                    }
                }
            }
        };
        EndJobTestButton.addActionListener(endJobTestButtonlistener);
        EndJobButton.addActionListener(endJobButtonlistener);
    }
}
