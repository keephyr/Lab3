package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface Raisable {
    String[] pos = {"junior", "middle", "expert", "professional"};
    List<String> positions = new ArrayList<>(List.of(pos));
    void raiseMember();
    void lowerMember();
    void showPosition();
}
