package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardRepository boardRepository;

    @GetMapping("/api/boards") // api 주소를 복수형으로 쓴다
    public ApiUtil<?> findAll(HttpServletResponse response){ // <List<Board>>
//        response.setStatus(401);
        List<Board> boardList = boardRepository.selectAll(); // 상태코드와 메시지를 줘야한다.
        return new ApiUtil<>(boardList); //status 코드 확인 200인지 MessageConverter 발동 (JSON으로 알아서 바꿔줌)

    }
}
