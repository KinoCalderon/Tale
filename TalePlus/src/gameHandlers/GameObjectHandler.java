package gameHandlers;

import gameMonsters.SuperGameObject;
import gameMonsters.SuperMonster;
import gameObjects.PlatformObject;
import main.Game;
import main.Player;
import gameUI.UI;

public class GameObjectHandler {

    private Game game;
    private Player player;
    private UI ui;
    public PlatformObject[] platformObjects = new PlatformObject[2];

    public GameObjectHandler(Game game, Player player, UI ui) {

        this.player = player;
        this.ui = ui;
        this.game = game;
        PlatformObject platformObject1 = new PlatformObject(game, player,ui,100,370,100,10);
        PlatformObject platformObject2 = new PlatformObject(game, player,ui,200,330,100,10);
        AddPlatformToArray(platformObject1,0);
        AddPlatformToArray(platformObject2,1);



    }

    public void AddPlatformToArray(PlatformObject platformObject, int i){
        platformObjects[i] = platformObject;

    }

    public SuperGameObject GetObjectFromIndex(int i){
        return platformObjects[i];
    }

}
