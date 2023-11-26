import java.util.List;

public class PublicationTrack {
    private List<AlchemyMarker> alchemyMarkers;
    private List<PublicationCard> availableCards;
    private List<AlchemyMarker> availableAlchemies;

    public void makeUnavailable(PublicationCard card, AlchemyMarker marker) {
       
    }

    public void removeTheory(Theory t) {
        
    }

    public List<AlchemyMarker> getAlchemyMarkers() {
        return alchemyMarkers;
    }

    public void setAlchemyMarkers(List<AlchemyMarker> alchemyMarkers) {
        this.alchemyMarkers = alchemyMarkers;
    }

    public List<PublicationCard> getAvailableCards() {
        return availableCards;
    }

    public void setAvailableCards(List<PublicationCard> availableCards) {
        this.availableCards = availableCards;
    }

    public List<AlchemyMarker> getAvailableAlchemies() {
        return availableAlchemies;
    }

    public void setAvailableAlchemies(List<AlchemyMarker> availableAlchemies) {
        this.availableAlchemies = availableAlchemies;
    }
}
