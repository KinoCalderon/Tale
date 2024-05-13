package gameAbilities;

import gameHandlers.MonsterHandler;
import gameHandlers.PlayerGraphicsHandler;
import gameMonsters.SuperMonster;
import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperAbility {


    private Game game;
    private Player player;
    private UI ui;
    private MonsterHandler monsterHandler;
    private PlayerGraphicsHandler playerGraphicsHandler;
    private String name;
    private int abilityDamage;
    private int abilityMpCost;
    private int abilityX;
    private int abilityY;
    private int width;
    private int height;
    public JLabel abilityLabel;
    private boolean canUseAbility = true;
    private Timer abilityTimer;
    private ImageIcon abilityImageRight;
    private ImageIcon abilityImageRight2;
    private ImageIcon abilityImageLeft;
    private ImageIcon abilityImageLeft2;


    public SuperAbility(Game game, Player player, UI ui, MonsterHandler monsterHandler){
        this.game = game;
        this.player = player;
        this.monsterHandler = monsterHandler;
        this.ui = ui;


        // Initialize the timer
        // Change 5000 to the desired cooldown time in milliseconds
        abilityTimer = new Timer(3000, e -> canUseAbility = true);


    }

    public void useAbility() {
        if (canUseAbility) {
            player.setCurrentMp(-abilityMpCost);
            ui.SetMpLabelText();
            if (player.getPlayerDirection().equals("right")){
                GetCorrectAbilityImage();
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Remove the ability from the screen after 200 milliseconds
                        RemoveAbilityFromScreen();
                    }
                });
                timer.setRepeats(false); // Ensure the timer only fires once
                timer.start();
                System.out.println("Player direction right");
                CheckIfAbilityHitMonster();
                AddAbilityToScreen();

                // Perform ability actions here
                canUseAbility = false; // Set to false to prevent ability spamming
                abilityTimer.restart();

            }
            else if (player.getPlayerDirection().equals("left")) {
                GetCorrectAbilityImage();
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Remove the ability from the screen after 200 milliseconds
                        RemoveAbilityFromScreen();
                    }
                });
                timer.setRepeats(false); // Ensure the timer only fires once
                timer.start();
                System.out.println("Player direction left");
                CheckIfAbilityHitMonster();
                AddAbilityToScreen();

                // Perform ability actions here
                canUseAbility = false; // Set to false to prevent ability spamming
                abilityTimer.restart();

            }
             // Restart the timer
        }
    }

    public void GetCorrectAbilityImage() {
        Timer timer = new Timer(200, new ActionListener() {
            int count = 0;
            boolean isRightDirection = player.getPlayerDirection().equals("right");
            boolean isLeftDirection = player.getPlayerDirection().equals("left");
            int cycles = 2; // Adjust the number of cycles as needed

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isRightDirection) {
                    switch (count % 2) {
                        case 0:
                            abilityLabel.setIcon(abilityImageRight);
                            break;
                        case 1:
                            abilityLabel.setIcon(abilityImageRight2);
                            break;
                    }
                } else if (isLeftDirection) {
                    switch (count % 2) {
                        case 0:
                            abilityLabel.setIcon(abilityImageLeft);
                            break;
                        case 1:
                            abilityLabel.setIcon(abilityImageLeft2);
                            break;
                    }
                }
                ui.mainGraphicsPane.repaint(); // Repaint the UI

                count++;
                if (count / 2 >= cycles) { // Stop the timer after completing the specified number of cycles
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.setInitialDelay(0); // Start immediately
        timer.start();
    }





    public void CheckIfAbilityHitMonster(){
        if (CollidesWithMonster(player)){
            monsterHandler.ShouldMonsterBeKilled();
            System.out.println("Lightning dealt " + getAbilityDamage());

        }
    }



    public void AddAbilityToScreen(){
        ui.mainGraphicsPane.add(abilityLabel, JLayeredPane.POPUP_LAYER);
        ui.mainGraphicsPane.repaint();

        if (player.isPlayerMoving() && player.getPlayerDirection().equals("right")){
            if (player.isPlayerMoving()) {

                this.abilityLabel.setBounds(player.getPlayerX() + (player.getPLAYER_WIDTH_X() / 2 + 15), player.getPlayerY() + 20, getWidth(), getHeight());
                ui.mainGraphicsPane.repaint();
            }



        }
        else if (player.getPlayerDirection().equals("right")){
            this.abilityLabel.setBounds(player.getPlayerX()+(player.getPLAYER_WIDTH_X()/2 +15),player.getPlayerY()+20,getWidth(),getHeight());
            ui.mainGraphicsPane.repaint();



        }
        else if (player.isPlayerMoving() && player.getPlayerDirection().equals("left")) {
            if (player.isPlayerMoving()) {
                this.abilityLabel.setBounds(player.getPlayerX() - player.getPLAYER_WIDTH_X() *2, player.getPlayerY() + 20, getWidth(), getHeight());
                ui.mainGraphicsPane.repaint();
            }

        }
        else if (player.getPlayerDirection().equals("left")) {
            this.abilityLabel.setBounds(player.getPlayerX() - player.getPLAYER_WIDTH_X() *2 , player.getPlayerY() + 20, getWidth(), getHeight());
            ui.mainGraphicsPane.repaint();
        }



    }

    public void RemoveAbilityFromScreen(){
        ui.mainGraphicsPane.remove(abilityLabel);
        ui.mainGraphicsPane.repaint();
    }

    public boolean CollidesWithMonster(Player player) {
        Rectangle abilityBounds = new Rectangle(player.getPlayerX() + (player.getPLAYER_WIDTH_X() / 2), player.getPlayerY() + 20, getWidth(), getHeight());
        if (player.getPlayerDirection().equals("right")){

            abilityBounds.setBounds(player.getPlayerX() + (player.getPLAYER_WIDTH_X() / 2 + 15), player.getPlayerY() + 20, getWidth(), getHeight());
        }
        else if (player.getPlayerDirection().equals("left")) {

            abilityBounds.setBounds(player.getPlayerX() - (player.getPLAYER_WIDTH_X() * 2), player.getPlayerY() + 20, getWidth(), getHeight());
        }

        for (int i = 0; i < monsterHandler.monsterList.size(); i++) {
            Rectangle monsterBounds = new Rectangle(monsterHandler.monsterList.get(i).getMonsterX(), monsterHandler.monsterList.get(i).getMonsterY(), monsterHandler.monsterList.get(i).getWidth(), monsterHandler.monsterList.get(i).getHeight());

            if (monsterBounds.intersects(abilityBounds)) {
                monsterHandler.monsterList.get(i).HurtMonster(getAbilityDamage());
                System.out.println("ability hit monster " + monsterHandler.monsterList.get(i).getName() + " at the index of " + i);
                return true; // Collision detected with this monster
            }
        }

        return false; // No collision detected with any monster
    }




    private int GetMonsterWithLowestHpX() {
        return monsterHandler.GetMonsterWithLowestHp().getMonsterX();
    }

    private int GetMonsterWithLowestHpY() {
        return monsterHandler.GetMonsterWithLowestHp().getMonsterY();
    }


    public int getAbilityDamage() {
        return abilityDamage;
    }

    public void setAbilityDamage(int abilityDamage) {
        this.abilityDamage = abilityDamage;
    }

    public int getAbilityX() {
        return abilityX;
    }

    public void setAbilityX(int abilityX) {
        this.abilityX = abilityX;
    }

    public int getAbilityY() {
        return abilityY;
    }

    public void setAbilityY(int abilityY) {
        this.abilityY = abilityY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ImageIcon getAbilityImageLeft() {
        return abilityImageLeft;
    }

    public void setAbilityImageLeft(ImageIcon abilityImageLeft) {
        this.abilityImageLeft = abilityImageLeft;
    }

    public int getAbilityMpCost() {
        return abilityMpCost;
    }

    public void setAbilityMpCost(int abilityMpCost) {
        this.abilityMpCost = abilityMpCost;
    }

    public ImageIcon getAbilityImageRight() {
        return abilityImageRight;
    }

    public void setAbilityImageRight(ImageIcon abilityImageRight) {
        this.abilityImageRight = abilityImageRight;
    }

    public ImageIcon getAbilityImageLeft2() {
        return abilityImageLeft2;
    }

    public void setAbilityImageLeft2(ImageIcon abilityImageLeft2) {
        this.abilityImageLeft2 = abilityImageLeft2;
    }

    public ImageIcon getAbilityImageRight2() {
        return abilityImageRight2;
    }

    public void setAbilityImageRight2(ImageIcon abilityImageRight2) {
        this.abilityImageRight2 = abilityImageRight2;
    }
}
