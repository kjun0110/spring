package kr.ai.kjun.api.user.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ai.kjun.api.common.domain.Messenger;
import kr.ai.kjun.api.user.domain.UserDTO;

@Repository
public class UserRepository {

    private List<UserDTO> userList = new ArrayList<>();

    public Messenger save(UserDTO user) {
        try {
            userList.add(user);
            Messenger messenger = new Messenger();
            messenger.setCode(200);
            messenger.setMessage("User saved successfully");
            return messenger;
        } catch (Exception e) {
            e.printStackTrace();
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("User save error: " + e.getMessage());
            return messenger;
        }
    }

    public Messenger saveAll(List<UserDTO> users) {
        try {
            System.out.println("🔄 UserRepository.saveAll 시작");
            System.out.println("📊 받은 승객 데이터 크기: " + users.size());

            // 데이터 저장
            this.userList = users;
            System.out.println("✅ 승객 데이터 저장 완료");

            // 콘솔에 출력
            System.out.println("🖨️ 터미널 출력 시작...");
            printUsers();
            System.out.println("✅ 터미널 출력 완료");

            // 성공 메시지 반환 (저장된 데이터 포함)
            Messenger messenger = new Messenger();
            messenger.setCode(200);
            messenger.setMessage("타이타닉 승객 데이터 저장 및 출력 성공 - 총 " + users.size() + "명");
            messenger.setData(userList); // 저장된 데이터를 메신저에 포함
            System.out.println("✅ UserRepository.saveAll 완료");
            return messenger;

        } catch (Exception e) {
            System.out.println("❌ UserRepository에서 오류 발생: " + e.getMessage());
            e.printStackTrace();
            Messenger messenger = new Messenger();
            messenger.setCode(500);
            messenger.setMessage("승객 데이터 저장 오류: " + e.getMessage());
            return messenger;
        }
    }

    public void printUsers() {
        System.out.println("================================");
        System.out.println("타이타닉 승객 정보 (상위 5명)");
        System.out.println("List 크기: " + userList.size());
        System.out.println("================================");

        if (userList.isEmpty()) {
            System.out.println("⚠️ userList가 비어있습니다!");
            return;
        }

        // forEach를 사용하여 배열 출력
        final int[] index = { 1 }; // 승객 번호를 위한 카운터
        userList.forEach(user -> {
            System.out.println("\n[승객 " + index[0] + "]");
            System.out.println("PassengerId: " + (user.getUserId() != null ? user.getUserId() : "null"));
            System.out.println("Survived: " + (user.getSurvived() != null ? user.getSurvived() : "null"));
            System.out.println("Pclass: " + (user.getPclass() != null ? user.getPclass() : "null"));
            System.out.println("Name: " + (user.getName() != null ? user.getName() : "null"));
            System.out.println("Sex: " + (user.getGender() != null ? user.getGender() : "null"));
            System.out.println("Age: " + (user.getAge() != null ? user.getAge() : "null"));
            System.out.println("SibSp: " + (user.getSibSp() != null ? user.getSibSp() : "null"));
            System.out.println("Parch: " + (user.getParch() != null ? user.getParch() : "null"));
            System.out.println("Ticket: " + (user.getTicket() != null ? user.getTicket() : "null"));
            System.out.println("Fare: " + (user.getFare() != null ? user.getFare() : "null"));
            System.out.println("Cabin: " + (user.getCabin() != null ? user.getCabin() : "null"));
            System.out.println("Embarked: " + (user.getEmbarked() != null ? user.getEmbarked() : "null"));
            index[0]++;
        });

        System.out.println("\n================================");
        System.out.println("총 " + userList.size() + "명의 승객 정보를 출력했습니다.");
        System.out.println("================================\n");
    }

    public Messenger update(UserDTO user) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Users updated successfully");
        return messenger;
    }

    public Messenger delete(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Users deleted successfully");
        return messenger;
    }

    public Messenger findById(String id) {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("User found successfully");
        return messenger;
    }

    public Messenger findAll() {
        Messenger messenger = new Messenger();
        messenger.setCode(200);
        messenger.setMessage("Users found successfully");
        return messenger;
    }

}
