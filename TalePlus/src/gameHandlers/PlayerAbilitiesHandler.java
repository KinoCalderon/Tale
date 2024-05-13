package gameHandlers;

import gameAbilities.LightningAbility;
import gameAbilities.SuperAbility;
import gameMonsters.SuperMonster;
import gameUI.UI;
import main.Game;
import main.Player;

public class PlayerAbilitiesHandler {
    private Game game;
    private Player player;
    private UI ui;
    private SuperAbility[] abilityArray = new SuperAbility[1];
    private MonsterHandler monsterHandler;


    public PlayerAbilitiesHandler(Game game, Player player, UI ui, MonsterHandler monsterHandler){
        this.game = game;
        this.player = player;
        this.ui = ui;
        this.monsterHandler = monsterHandler;

        LightningAbility lightningAbility = new LightningAbility(game,player,ui,monsterHandler);
        AddAbilityToArray(lightningAbility,0);



    }



    public void RemoveAbilityFromScreen(int i){
        ui.mainGraphicsPane.remove(abilityArray[i].abilityLabel);
    }

    public void AddAbilityToArray(SuperAbility superAbility, int i) {
        abilityArray[i] = superAbility;
    }

    public SuperAbility GetAbilityFromIndex(int i) {
        return abilityArray[i];
    }
}
