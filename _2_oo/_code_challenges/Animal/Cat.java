 public Cat() {
        this("");
    }

    @Override
    void eat() {
System.out.println(name + " can eat.");
    }

    @Override
    public void walk() {
        System.out.println(name + " can walk because the cat have " + legs + " legs.");
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    public void play(){
        name = "Flaffy";
        System.out.println("Every cat can play.");

    }

}