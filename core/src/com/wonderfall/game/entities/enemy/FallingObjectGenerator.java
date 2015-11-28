package com.wonderfall.game.entities.enemy;

import java.util.ArrayList;

import com.badlogic.gdx.math.MathUtils;
import com.wonderfall.game.level.entities.LevelEntities;
import com.wonderfall.game.level.entities.objects.LevelBadObject;
import com.wonderfall.game.level.entities.objects.LevelGoodObject;
import com.wonderfall.game.level.entities.objects.LevelObject;
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
public class FallingObjectGenerator {

	private LevelEntities levelEntities;

	// 0 - good object, 1 - bad object
	private enum ObjectType {
		GOOD, BAD
	};

	private ArrayList<ObjectType> biasedObjectType;

	private ArrayList<LevelGoodObject> biasedGoodObject;
	private ArrayList<LevelBadObject> biasedBadObject;

	public FallingObjectGenerator() {

		levelEntities = LevelsManager.curLevel.getEntities();

		// BIASED OBJECT TYPE INITIALIZATION
		biasedObjectType = new ArrayList<ObjectType>(levelEntities.getGoodRatio() + levelEntities.getBadRatio());
		for (int i = 0; i < levelEntities.getGoodRatio(); i++)
			biasedObjectType.add(ObjectType.GOOD);
		for (int i = 0; i < levelEntities.getBadRatio(); i++)
			biasedObjectType.add(ObjectType.BAD);

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
	public LevelObject generate() {

		ObjectType objectType = biasedObjectType.get(MathUtils.random(0, biasedObjectType.size() - 1));

		LevelObject generated = null;
		switch (objectType) {
		case GOOD:
			generated = biasedGoodObject.get(MathUtils.random(0, biasedGoodObject.size() - 1));
			break;
		case BAD:
			generated = biasedBadObject.get(MathUtils.random(0, biasedBadObject.size() - 1));
			break;
		}
		return generated;
	}
}
