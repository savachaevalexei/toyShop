package toys;

public abstract  class Toy {
    protected Integer id;
    protected String name;
    protected Integer freq;

    public Toy(Integer id, String name, Integer freq) {
        this.id = id;
        this.name = name;
        this.freq = freq;
    }

    public String toString(){
        return String.format("%s, %s, %s", id, name, freq);
    }

}

