package shop.mtcoding.blog.board;

import lombok.AllArgsConstructor;
import lombok.Data;

    @AllArgsConstructor
    @Data
    public class ApiUtil<T> {
        private Integer status; // 200,400,404,405 200일때는 볼 필요 없음 에러코드가 나오는게 중요
        private String msg; // 성공, 실패했을 때 보내는 메시지 -> 정확한 메시지 필요
        private T body;

        public ApiUtil(T body) {
            this.status = 200;
            this.msg = "성공";
            this.body = body;
        }

        public ApiUtil(Integer status, String msg) {
            this.status = status;
            this.msg = msg;
            this.body = null;
        }
    }
