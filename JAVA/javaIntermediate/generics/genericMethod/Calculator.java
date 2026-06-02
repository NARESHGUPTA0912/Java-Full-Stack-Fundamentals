package generics.genericMethod;

// Bounded Type Parameters
// Upper Bound using extends
class Calculator<T extends Number> { 

    T num;

    Calculator(T num) {
        this.num = num;
    }

    double square() {
        return num.doubleValue() * num.doubleValue();
    }
}
