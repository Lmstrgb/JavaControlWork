import java.util.Objects;

public class Joy implements Comparable<Joy> {
    private String id;
    private String name;
    private int weight;

    public Joy(String id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Joy other) {
        return  Integer.compare(this.weight,other.weight);
    }
}

