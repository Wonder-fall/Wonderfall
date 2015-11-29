package com.wonderfall.game.entities.enemy.fallingobject;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.wonderfall.game.entities.enemy.fallingobject.bad.BadFallingObject;
import com.wonderfall.game.entities.enemy.fallingobject.good.GoodFallingObject;
import com.wonderfall.game.entities.enemy.fallingobject.special.SpecialFallingObject;
import com.wonderfall.game.level.difficulty.LevelDifficulty;
import com.wonderfall.game.level.entities.LevelEntities;
import com.wonderfall.game.level.entities.objects.LevelBadObject;
import com.wonderfall.game.level.entities.objects.LevelGoodObject;
import com.wonderfall.game.level.entities.objects.LevelObject;
import com.wonderfall.game.level.entities.objects.LevelSpecialObject;
import com.wonderfall.game.utils.Assets;
import com.wonderfall.game.utils.LevelState;
import com.wonderfall.game.utils.LevelsManager;

/**
 * This class is used to integrate between the current level entities and the
 * generation of falling objects.
 * 
 * It does so using biased random for generating good or bad object, and biased
 * random again for generating specific object in the chosen group.
 * 
 * The motivation for creating this class was to out source the responsibility
 * for summoning new objects
 * 
 * @author BarDavid
 * @since 27/11/2015 21:39
 *
 */
public class FallingObjectGenerator extends Actor {

	private LevelEntities levelEntities;
	private LevelDifficulty levelDifficulty;

	// 0 - good object, 1 - bad object, 2 - special object
	private enum ObjectType {
		GOOD, BAD, SPECIAL
	};

	private ArrayList<ObjectType> biasedObjectType;

	private ArrayList<LevelGoodObject> biasedGoodObject;
	private ArrayList<LevelBadObject> biasedBadObject;
	private ArrayList<LevelSpecialObject> biasedSpecialObject;

	public FallingObjectGenerator() {

		levelEntities = LevelsManager.curLevel.getEntities();
		levelDifficulty = LevelsManager.curLevel.getDifficulty();

		// BIASED OBJECT TYPE INITIALIZATION
		biasedObjectType = new ArrayList<ObjectType>();
		for (int i = 0; i < levelEntities.getGoodRatio(); i++)
			biasedObjectType.add(ObjectType.GOOD);
		for (int i = 0; i < levelEntities.getBadRatio(); i++)
			biasedObjectType.add(ObjectType.BAD);
		for (int i = 0; i < levelEntities.getSpecialRatio(); i++)
			biasedObjectType.add(ObjectType.SPECIAL);

		// BIASED GOOD OBJECT INITIALIZATION
		biasedGoodObject = new ArrayList<LevelGoodObject>();
		for (int i = 0; i < levelEntities.getGoodObjects().size(); i++)
			for (int j = 0; j < levelEntities.getGoodObjects().get(i).getRatio(); j++)
				biasedGoodObject.add(levelEntities.getGoodObjects().get(i));

		// BIASED BAD OBJECT INITIALIZATION
		biasedBadObject = new ArrayList<LevelBadObject>();
		for (int i = 0; i < levelEntities.getBadObjects().size(); i++)
			for (int j = 0; j < levelEntities.getBadObjects().get(i).getRatio(); j++)
				biasedBadObject.add(levelEntities.getBadObjects().get(i));

		// BIASED SPECIAL OBJECT INITIALIZATION
		biasedSpecialObject = new ArrayList<LevelSpecialObject>();
		for (int i = 0; i < levelEntities.getSpecialObjects().size(); i++)
			for (int j = 0; j < levelEntities.getSpecialObjects().get(i).getRatio(); j++)
				biasedSpecialObject.add(levelEntities.getSpecialObjects().get(i));
	}

	/**
	 * This method first randomizes between choosing either a good or a bad
	 * object Then it randomizes which object within the chosen type. All done
	 * biased as in: good->5. bad->1 equals to 5 times good versus 1 times bad.
	 * 
	 * It is implemented using an occurrence array, so the example would be
	 * this: [g,g,g,g,g,b] and then it picks a random index
	 * 
	 * @return generated LevelObject parent
	 */
	public CommonFallingObject generate() {

		ObjectType objectType = biasedObjectType.get(MathUtils.random(0, biasedObjectType.size() - 1));

		LevelObject levelObj;
		Texture newFObjTexture;
		Vector2 newFObjPosition, newFObjVelocity;

		switch (objectType) {
		case GOOD:
			// texture string from json levels file
			levelObj = biasedGoodObject.get(MathUtils.random(0, biasedGoodObject.size() - 1));
			// real texture from assets
			newFObjTexture = Assets.entitiesMap.get(levelObj.getTexture());
			// random position based on stage dimensions
			newFObjPosition = new Vector2(MathUtils.random() * (getStage().getWidth() - newFObjTexture.getWidth()),
					getStage().getHeight() - 20f);

			// random velocity based on difficulty
			newFObjVelocity = new Vector2(0, -(MathUtils.random(levelDifficulty.getInitialObjectsVelocity(),
					levelDifficulty.getInitialObjectsVelocity() + LevelState.DIFFICULTY)));

			int score = ((LevelGoodObject) levelObj).getScore();
			return new GoodFallingObject(newFObjTexture, newFObjPosition, newFObjVelocity, score);
		case BAD:
			// texture string from json levels file
			levelObj = biasedBadObject.get(MathUtils.random(0, biasedBadObject.size() - 1));
			// real texture from assets
			newFObjTexture = Assets.entitiesMap.get(levelObj.getTexture());
			// random position based on stage dimensions
			newFObjPosition = new Vector2(MathUtils.random() * (getStage().getWidth() - newFObjTexture.getWidth()),
					getStage().getHeight() - 20f);
			// random velocity based on difficulty
			newFObjVelocity = new Vector2(0, -(MathUtils.random(levelDifficulty.getInitialObjectsVelocity(),
					levelDifficulty.getInitialObjectsVelocity() + LevelState.DIFFICULTY)));

			return new BadFallingObject(newFObjTexture, newFObjPosition, newFObjVelocity);
		case SPECIAL:
			// texture string from json levels file
			levelObj = biasedSpecialObject.get(MathUtils.random(0, biasedSpecialObject.size() - 1));
			// real texture from assets
			newFObjTexture = Assets.entitiesMap.get(levelObj.getTexture());
			// random position based on stage dimensions
			newFObjPosition = new Vector2(MathUtils.random() * (getStage().getWidth() - newFObjTexture.getWidth()),
					getStage().getHeight() - 20f);
			// random velocity based on difficulty
			newFObjVelocity = new Vector2(0, -(MathUtils.random(levelDifficulty.getInitialObjectsVelocity(),
					levelDifficulty.getInitialObjectsVelocity() + LevelState.DIFFICULTY)));

			String speciality = ((LevelSpecialObject) levelObj).getAction();

			return new SpecialFallingObject(newFObjTexture, newFObjPosition, newFObjVelocity, speciality);

		default:
			return null;
		}
	}
}
