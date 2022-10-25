package com.example.playerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@RestController
@SpringBootApplication
public class PlayerspringbootApplication extends JFrame{
    private JButton outputBtn;
    private JTextPane nameTextPane;
    private JPanel playersPanel;
    private JLabel outLabel;


   public PlayerspringbootApplication() {
        outputBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               outLabel.setText(getDataByName(nameTextPane.getText()));

            }
        });
    }

    @GetMapping
    public String getDataByName(String name){
            String url = "https://balldontlie.io/api/v1/players?search={playerName}";
           url = url.replace("{playerName}",name);
        System.out.println("Url: "+url);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);


       return result;
    }

    public static void main(String[] args) {
        SpringApplication.run(PlayerspringbootApplication.class, args);
        PlayerspringbootApplication o = new PlayerspringbootApplication();
        o.setContentPane(o.playersPanel);
        o.pack();
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
