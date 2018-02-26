/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.MyGame;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Andreina
 */
public class GuiFrame {
private final JFrame frame = new JFrame();

    private final JPanel cards = new JPanel(new CardLayout());
    private final Menu MenuCard = new Menu(this);
    private final Help InstructionsCard = new Help(this);
    private final Display mDisplayGame = new Display();

    private final Game game;

    public GuiFrame(Game _game) {
        game = _game;
        init();
    }


    private void init() {

        MenuCard.setVisible(true);
        InstructionsCard.setVisible(true);
        mDisplayGame.setVisible(true);

        cards.setVisible(true);
        cards.add(mDisplayGame, "GamePanel");
        cards.add(InstructionsCard, "InstructionsPanel");
        cards.add(MenuCard, "MenuPanel");

        frame.add(cards);        
        
        frame.pack();
        frame.setResizable(false);
        frame.setLocation(300, 150);
        frame.setSize(852, 451);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Show on screen a certain JPanel.
     *
     * @param card JPanel which will be shown
     */
    public void showOnScreen(String card) {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, card);
        if(card.equals("GamePanel")){
            frame.setSize(1200, 720);
            frame.setLocation(100, 0);
            mDisplayGame.start();
            game.start();
        }
    }
}
