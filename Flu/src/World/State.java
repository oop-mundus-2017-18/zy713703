package World;

/**
 * @Author: Zhang Yuxin
 * @Date: 2018/2/23
 */
public enum State {
    HEALTHY("healthy"),INFECTED("infected"),SICK("sick"),DEAD("dead"),CONTAGIOUS("contagioous"),RECOVERING("recovering"),
    CONTA_SICK("conta_sick");
    private String state;
    State(String state) {
        this.state = state;
    };


}
