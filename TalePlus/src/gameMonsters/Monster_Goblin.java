package gameMonsters;

import main.Game;
import main.Player;
import gameUI.UI;

import javax.swing.*;
import java.awt.*;

public class Monster_Goblin extends SuperMonster{

	public Monster_Goblin(Game game, Player player, UI ui, int x, int y, int origX, int origY) {
		super(game, player, ui);

		setName("Goblin");
		setHp(10);
		setMaxHp(5);
		setMonsterGold(2);
		setMonsterDamage(1);
		setMonsterOriginalX(origX);
		setMonsterOriginalY(origY);
		setMonsterX(x);
		setMonsterY(y);
		setHeight(50);
		setWidth(25);
		setMonsterSpeed(3);
		setMonsterMoveDelay(500);

		monsterLabel = new JLabel();
		monsterLabel.setLocation(getMonsterX(), getMonsterY());
		monsterLabel.setSize(25,50);
		monsterLabel.setBackground(Color.blue);
		monsterLabel.setOpaque(true);
		monsterLabel.setVisible(true);
		ui.mainGraphicsPane.add(monsterLabel, JLayeredPane.MODAL_LAYER);

	}
}
