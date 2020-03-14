package test.lambda;

interface Settable<C extends WithNameAndAge> {
    void set(C entity, String name, int age);
}
