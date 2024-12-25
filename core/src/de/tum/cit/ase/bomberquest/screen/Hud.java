package de.tum.cit.ase.bomberquest.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import de.tum.cit.ase.bomberquest.BomberQuestGame;

/**
 * A Heads-Up Display (HUD) that displays information on the screen.
 * It uses a separate camera so that it is always fixed on the screen.
 */
public class Hud {
    
    /** The SpriteBatch used to draw the HUD. This is the same as the one used in the GameScreen. */
    private final SpriteBatch spriteBatch;
    /** The font used to draw text on the screen. */
    private final BitmapFont font;
    /** The camera used to render the HUD. */
    private final OrthographicCamera camera;

    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer amount;

    Label countdownLabel;
    Label scorelabel;
    Label timeLabel;
    Label levelLabel;
    Label worldlabel;
    Label bomberManLabel;
    
    public Hud(SpriteBatch spriteBatch, BitmapFont font) {
        this.spriteBatch = new SpriteBatch();
        this.font = font;
        this.camera = new OrthographicCamera();

        this.worldTimer = 300;
        this.timeCount = 0;
        this.amount = 0;

        this.viewport = new FitViewport(600,500 , new OrthographicCamera());

        stage = new Stage(viewport,spriteBatch);

        Table table = new Table();
        table.top().left();
        table.setFillParent(true);

        timeLabel = new Label("Christmas Time Start: " , new Label.LabelStyle(new BitmapFont() , Color.WHITE));
        countdownLabel = new Label(String.format("%03d" , worldTimer), new Label.LabelStyle(new BitmapFont() , Color.WHITE));

        bomberManLabel = new Label("Remaining number of Enemies: " , new Label.LabelStyle(new BitmapFont() , Color.WHITE));
        scorelabel = new Label(String.format("%02d" , amount), new Label.LabelStyle(new BitmapFont() , Color.WHITE));;

        worldlabel = new Label("Remaining number of Bombs: " , new Label.LabelStyle(new BitmapFont() , Color.WHITE));
        levelLabel = new Label(String.format("%02d" , amount), new Label.LabelStyle(new BitmapFont() , Color.WHITE));;


        // Add "Time: 300"
        table.add(timeLabel).align(Align.left).pad(5);
        table.add(countdownLabel).align(Align.left).pad(5);
        table.row();

        table.add(bomberManLabel).align(Align.left).pad(5);
        table.add(scorelabel).align(Align.left).pad(5);
        table.row(); // Move to the next row

// Add "World: 1-1"
        table.add(worldlabel).align(Align.left).pad(5);
        table.add(levelLabel).align(Align.left).pad(5);



        stage.addActor(table);


    }



    /**
     * Renders the HUD on the screen.
     * This uses a different OrthographicCamera so that the HUD is always fixed on the screen.
     */
    public void render() {
        // Render from the camera's perspective
        spriteBatch.setProjectionMatrix(camera.combined);
        // Start drawing
        spriteBatch.begin();
        // Draw the HUD elements
        //font.draw(spriteBatch, "Press Esc to Pause!", 10, Gdx.graphics.getHeight() - 10);
        //font.draw(spriteBatch, "Christmas Time Start: ", 10, Gdx.graphics.getHeight() - 10);
        //font.draw(spriteBatch, "Amount of Bombs: ", 10, Gdx.graphics.getHeight() - 40);
        //font.draw(spriteBatch, "Remaining number of Enemies: ", 10, Gdx.graphics.getHeight() - 70);
        // Finish drawing
        spriteBatch.end();
    }
    
    /**
     * Resizes the HUD when the screen size changes.
     * This is called when the window is resized.
     * @param width The new width of the screen.
     * @param height The new height of the screen.
     */
    public void resize(int width, int height) {
        camera.setToOrtho(false, width, height);
    }
    
}
