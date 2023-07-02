package programmers.전화번호목록;

// 정확성 테스트 통과, 효율성 테스트(0/4) 실패
class fail {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        int l = 0;

        for(String phone : phone_book) {
            l = phone.length();
            for(String other : phone_book) {
                try {
                    if(other.length() == l) {
                        continue;
                    } else {
                        if(phone.equals(other.substring(0,l))) {
                            answer = false;
                        } else {
                        }
                    }
                } catch (StringIndexOutOfBoundsException e) {
                }
            }

        }
        return answer;
    }
}