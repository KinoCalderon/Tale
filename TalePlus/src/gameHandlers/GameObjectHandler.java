package gameHandlers;

import gameObjects.RopeObject;
import gameObjects.SuperGameObject;
import gameObjects.PlatformObject;
import main.Game;
import main.Player;
import gameUI.UI;
import java.util.ArrayList;

public class GameObjectHandler {

    private Game game;
    private Player player;
    private UI ui;
    public ArrayList<PlatformObject> platformObjectsList = new ArrayList<>();
    public ArrayList<RopeObject> ropeObjectsList = new ArrayList<>();

    public GameObjectHandler(Game game, Player player, UI ui) {
        this.player = player;
        this.ui = ui;
        this.game = game;

        PlatformObject platformObject1 = new PlatformObject(game, player, ui, 100, 370, 100, 10);
        PlatformObject platformObject2 = new PlatformObject(game, player, ui, 230, 320, 100, 10);
        AddPlatformToArray(platformObject1);
        AddPlatformToArray(platformObject2);

        RopeObject ropeObject1 = new RopeObject(game, player, ui, 100, 370, 10, 70);
        AddRopeToArray(ropeObject1);
    }

    public void AddPlatformToArray(PlatformObject platformObject) {
        platformObjectsList.add(platformObject);
    }

    public SuperGameObject getPlatformObjectFromList(int i) {
        return platformObjectsList.get(i);
    }

    public void AddRopeToArray(RopeObject ropeObject) {
        ropeObjectsList.add(ropeObject);
    }

    public SuperGameObject getRopeObjectFromList(int i) {
        return ropeObjectsList.get(i);
    }

}
