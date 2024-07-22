import java.util.*;
class Solution {
    public String[] solution(String[] record) {
         Map<String, String> map = new HashMap<>(); //k=유저 아이디,v=닉네임
        Queue<Chat> queue = new LinkedList<>();
        for (int i = 0; i < record.length; i++) {
            String[] split = record[i].split(" ");
            if(split[0].equals("Enter")) {
                map.put(split[1], split[2]);
                queue.offer(new Chat(split[1], ENTER_MESSAGE));
            } else if(split[0].equals("Leave")) {
                queue.offer(new Chat(split[1],LEAVE_MESSAGE));
            } else if(split[0].equals("Change")) {
                map.put(split[1], split[2]);
            }
        }
        List<String> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            Chat chat = queue.poll();
            String nickname = map.get(chat.id);
            list.add(nickname + chat.message);
        }

        return list.stream().toArray(String[]::new);
    }
      static String ENTER_MESSAGE = "님이 들어왔습니다.";
    static String LEAVE_MESSAGE = "님이 나갔습니다.";

    public static class Chat {
        String id;
        String message;
        public Chat(String id, String message) {
            this.id = id;
            this.message = message;
        }
    }
}