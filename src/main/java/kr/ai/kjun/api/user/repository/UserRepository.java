package kr.ai.kjun.api.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.user.domain.UserDTO;
import kr.ai.kjun.api.user.domain.UserEntity;

@Repository
public class UserRepository {

    private List<UserDTO> userList = new ArrayList<>();

    public void saveUsers(List<UserDTO> users) {
        this.userList = users;
    }

    public void printUsers() {
        System.out.println("================================");
        System.out.println("타이타닉 승객 정보 (상위 5명)");
        System.out.println("List 크기: " + userList.size());
        System.out.println("================================");

        // forEach를 사용하여 배열 출력
        final int[] index = { 1 }; // 승객 번호를 위한 카운터
        userList.forEach(user -> {
            System.out.println("\n[승객 " + index[0] + "]");
            System.out.println("UserId: " + user.getUserId());
            System.out.println("Survived: " + user.getSurvived());
            System.out.println("Pclass: " + user.getPclass());
            System.out.println("Name: " + user.getName());
            System.out.println("Gender: " + user.getGender());
            System.out.println("Age: " + user.getAge());
            System.out.println("SibSp: " + user.getSibSp());
            System.out.println("Parch: " + user.getParch());
            System.out.println("Ticket: " + user.getTicket());
            System.out.println("Fare: " + user.getFare());
            System.out.println("Cabin: " + user.getCabin());
            System.out.println("Embarked: " + user.getEmbarked());
            index[0]++;
        });

        System.out.println("\n================================");
        System.out.println("총 " + userList.size() + "명의 정보를 출력했습니다.");
        System.out.println("================================\n");
    }

    public Messenger login(UserEntity UserEntity) {
        return null;
    }
}
