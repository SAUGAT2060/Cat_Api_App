package catapp.model;

import java.util.List;

public class CatImage {
    private String id;
    private String url;
    private List<Breed> breeds;

    public String getId() { return id; }
    public String getUrl() { return url; }
    public List<Breed> getBreeds() { return breeds; }
}
