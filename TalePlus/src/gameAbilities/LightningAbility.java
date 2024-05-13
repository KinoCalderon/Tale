package gameAbilities;

import gameHandlers.MonsterHandler;
import gameUI.UI;
import main.Game;
import main.Player;

import javax.swing.*;
import java.awt.*;

public class LightningAbility extends SuperAbility{
    private ImageIcon abilityImageRight = new ImageIcon(".//media//lightningAbilityImageRight.png");
    private ImageIcon abilityImageRight2 = new ImageIcon(".//media//lightningAbilityImageRight2.png");
    private ImageIcon abilityImageLeft = new ImageIcon(".//media//lightningAbilityImageLeft.png");
    private ImageIcon abilityImageLeft2 = new ImageIcon(".//media//lightningAbilityImageLeft2.png");
    public LightningAbility(Game game, Player player, UI ui, MonsterHandler monsterHandler) {
        super(game, player, ui, monsterHandler);

        setName("Lightning");
        setAbilityDamage(4);
        setAbilityMpCost(2);
        setWidth(60);
        setHeight(20);
        setAbilityImageLeft(abilityImageLeft);
        setAbilityImageLeft2(abilityImageLeft2);
        setAbilityImageRight(abilityImageRight);
        setAbilityImageRight2(abilityImageRight2);


        abilityLabel = new JLabel();
        abilityLabel.setIcon(abilityImageRight);
        abilityLabel.setVisible(true);


    }




}
