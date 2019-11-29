package effectivejava.staticfactorymethod.monster;

public class Monster {
	public enum Map {
		FOREST, OCEAN, DESERT
	}

	private String name;
	private Map appearanceMap;
	private int hp;
	private int rewardExp;

	/* No need to create instance every time (for immutable class) */
	private static final Monster VINE_MONSTER = new Monster("Vine", Map.FOREST, 100, 10);
	private static final Monster SHELL_MONSTER = new Monster("Shell", Map.OCEAN, 200, 15);
	private static final Monster SNAKE_MONSTER = new Monster("Snake", Map.DESERT, 250, 40);

	private Monster(String name, Map apperanceMap, int hp, int rewardExp) {
		this.name = name;
		this.appearanceMap = apperanceMap;
		this.hp = hp;
		this.rewardExp = rewardExp;
	}

	/* static factory method can have its own name */
	public Monster getInstanceVineMonster() {
		return new Monster("Vine", Map.FOREST, 100, 10);
//		return VINE_MONSTER;	// return already created instance
	}

	public Monster getInstanceShellMonster() {
		return new Monster("Shell", Map.OCEAN, 200, 15);
	}

	public Monster getInstanceSnakeMonster() {
		return new Monster("Snake", Map.DESERT, 250, 40);
	}
}