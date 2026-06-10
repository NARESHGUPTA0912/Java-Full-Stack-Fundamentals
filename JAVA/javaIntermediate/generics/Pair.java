package javaIntermediate.generics;

// Multiple Type Parameters
class Pair<K, V> {

    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    void display() {
        System.out.println(key + " : " + value);
    }
}