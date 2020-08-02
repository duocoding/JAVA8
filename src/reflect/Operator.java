package reflect;

/**
 * @ClassName Operator
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/1 23:13
 * @Version 1.0
 */
public class Operator {

    private int a;
    private int b;

    public Operator(){

    }

    public Operator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    private int add(int n1, int n2){
        return n1+n2+a+b;
    }

    private int sub(int n1, int n2){
        return n1+n1-a-b;
    }

    private int getA() {
        return a;
    }

    private void setA(int a) {
        this.a = a;
    }

    private int getB() {
        return b;
    }

    private void setB(int b) {
        this.b = b;
    }
}
