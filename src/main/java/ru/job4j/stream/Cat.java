package ru.job4j.stream;

public class Cat {
    private String name;
    private String breed;
    private byte age;
    private byte weight;
    private String color;

    @Override
    public String toString() {
        return "Cat{"
                + "name='" + name + '\''
                + ", breed='" + breed + '\''
                + ", age=" + age
                + ", weight=" + weight
                + ", color='" + color + '\''
                + '}';
    }

    static class Builder {
        private String name;
        private String breed;
        private byte age;
        private byte weight;
        private String color;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildBreed(String breed) {
            this.breed = breed;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildWeight(byte weight) {
            this.weight = weight;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Cat build() {
            Cat cat = new Cat();
            cat.name = name;
            cat.breed = breed;
            cat.age = age;
            cat.weight = weight;
            cat.color = color;
            return cat;
        }
    }

    public static void main(String[] args) {
        Cat cat = new Builder().buildName("Sharik")
                .buildBreed("noname")
                .buildAge((byte) 9)
                .buildWeight((byte) 9)
                .buildColor("black")
                .build();
        System.out.println(cat);
    }
}
