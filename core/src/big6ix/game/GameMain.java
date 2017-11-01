package big6ix.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class GameMain extends Game {
    // Game screens
    ScreenGame screenGame = null;
    ScreenMainMenu screenMainMenu = null;

    // Batch and font used for drawing available for different screen objects
    SpriteBatch batch = null;
    BitmapFont font = null;

    @Override
    public void create() {
        batch = new SpriteBatch();
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/OpenSans-Regular.ttf"));
        FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
        fontParameter.size = 64;
        fontParameter.flip = true;
        font = fontGenerator.generateFont(fontParameter);
        fontGenerator.dispose();

        Cursor gameCursor = Gdx.graphics.newCursor(new Pixmap(Gdx.files.internal("crosshair.png")), 16, 16);
        Gdx.graphics.setCursor(gameCursor);

        screenGame = new ScreenGame(this);
        screenMainMenu = new ScreenMainMenu(this);

        this.setScreen(screenMainMenu);
    }

    @Override
    public void render() {
        // Render method is called on each screen object differently
        super.render();
    }

    @Override
    public void pause() {
        System.out.println("Pause called from GameMain.");
    }

    @Override
    public void resume() {
        System.out.println("Resume called from GameMain.");
    }

    @Override
    public void dispose() {
        // Dispose methods for screens must be used manually
        System.out.println("Dispose called from GameMain.");
        batch.dispose();
        font.dispose();
        screenGame.dispose();
        screenMainMenu.dispose();
    }
}
