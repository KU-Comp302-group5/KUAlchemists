package domain;

public class WisdomIdolArtifact implements ArtifactBehavior<Integer> {

	@Override
	public void useCard(Integer item) {
		KUAlchemistsGame.getCurrentPlayer().increaseReputation(item);
	}
}